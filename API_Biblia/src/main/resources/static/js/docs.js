document.getElementById('btn-deslogar').addEventListener('click', function() {
    localStorage.removeItem('token');
    window.location.href = 'login.html';
});

document.addEventListener('DOMContentLoaded', async () => {
    const token = localStorage.getItem('token');

    if (!token) {
        window.location.href = 'login.html';
        return;
    }

    try {
        const response = await fetch('/developer/dashboard', {
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${token}`
            }
        });

        if (response.ok) {
            const dados = await response.json();
            document.getElementById('user-nome').textContent = dados.nome;
            document.getElementById('user-apikey').textContent = dados.apiKey;
            document.getElementById('user-reqs').textContent = dados.requisicoes;
        } else {
            localStorage.removeItem('token');
            window.location.href = 'login.html';
        }
    } catch (error) {
        console.error("Erro ao carregar dashboard:", error);
    }
});

const docData = {
    'aleatorio': {
        method: 'GET',
        path: '/versiculo-aleatorio',
        desc: 'Retorna um único versículo bíblico sorteado aleatoriamente do banco de dados.',
        json: '{\n  "livro": "João",\n  "capitulo": 3,\n  "numVersiculo": 16,\n  "versiculo": "Porque Deus amou o mundo de tal maneira que deu o seu Filho unigênito, para que todo aquele que nele crê não pereça, mas tenha a vida eterna."\n}'
    },
    'temas-lista': {
        method: 'GET',
        path: '/temas',
        desc: 'Retorna uma lista contendo todos os temas bíblicos disponíveis na API.',
        json: '[\n  "Amor",\n  "Perdão",\n  "Unitarismo",\n  "Fé",\n  "Esperança"\n]'
    },
    'temas-unitarismo': {
        method: 'GET',
        path: '/temas/Unitarismo',
        desc: 'Retorna todos os versículos classificados sob o tema específico pesquisado (ex: Unitarismo).',
        json: '[\n  {\n    "livro": "Deuteronômio",\n    "capitulo": 6,\n    "numVersiculo": 4,\n    "versiculo": "Ouve, Israel, o Senhor nosso Deus é o único Senhor."\n  }\n]'
    }
};

const links = document.querySelectorAll('a[data-endpoint]');
const welcomeScreen = document.getElementById('welcome-screen');
const detailsScreen = document.getElementById('endpoint-details');

const epMethod = document.getElementById('ep-method');
const epPath = document.getElementById('ep-path');
const epDesc = document.getElementById('ep-desc');
const epJson = document.getElementById('ep-json');

links.forEach(link => {
    link.addEventListener('click', function(event) {
        event.preventDefault();
        
        const chave = this.getAttribute('data-endpoint');
        const info = docData[chave];
        
        if(info) {
            welcomeScreen.style.display = 'none';
            detailsScreen.style.display = 'block';
            
            epMethod.textContent = info.method;
            epPath.textContent = info.path;
            epDesc.textContent = info.desc;
            epJson.textContent = info.json;
        }
    });
});