document.getElementById('form-login').addEventListener('submit', async function(event) {
    event.preventDefault();

    const email = document.getElementById('email').value;
    const senha = document.getElementById('senha').value;

    try {
        console.log(window.location.origin);
        console.log("Enviando login para:", window.location.origin + "/login");

        const resposta = await fetch('/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                email,
                senha
            })
        });

        if (resposta.ok) {
            const dados = await resposta.json();
            localStorage.setItem('token', dados.token);
            window.location.href = 'docs.html';
        } else {
            alert('E-mail ou senha inválidos!');
        }
    } catch (erro) {
        console.error('Erro na requisição:', erro);
        alert('Erro de conexão. O servidor está ligado?');
    }
});