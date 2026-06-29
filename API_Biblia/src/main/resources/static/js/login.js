document.getElementById('form-login').addEventListener('submit', async function(event) {
    event.preventDefault();

    const email = document.getElementById('email').value;
    const senha = document.getElementById('senha').value;

    try {
        const resposta = await fetch('/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                email: email,
                senha: senha
            })
        });

        if (resposta.ok) {
            localStorage.setItem('usuarioLogado', 'true');
            window.location.href = 'docs.html';
        } else {
            alert('E-mail ou senha inválidos!');
        }
    } catch (erro) {
        console.error('Erro na requisição:', erro);
        alert('Erro de conexão. O servidor está ligado?');
    }
});

const btnSenha = document.getElementById('btn-senha');
const inputSenha = document.getElementById('senha');

if (btnSenha && inputSenha) {
    btnSenha.addEventListener('click', function() {
        if (inputSenha.type === 'password') {
            inputSenha.type = 'text';
            btnSenha.classList.replace('bx-hide', 'bx-show');
        } else {
            inputSenha.type = 'password';
            btnSenha.classList.replace('bx-show', 'bx-hide');
        }
    });
}