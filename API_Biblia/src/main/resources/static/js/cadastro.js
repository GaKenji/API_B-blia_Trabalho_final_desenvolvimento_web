document.getElementById('form-cadastro').addEventListener('submit', async function(event) {
    event.preventDefault();

    const nome = document.getElementById('nome').value;
    const email = document.getElementById('email').value;
    const senha = document.getElementById('senha').value;

    try {
        const resposta = await fetch('/cadastro', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                nome: nome,
                email: email,
                senha: senha
            })
        });

        if (resposta.ok) {
            alert('Usuário cadastrado com sucesso!');
            window.location.href = 'login.html'; 
        } else {
            alert('Erro ao cadastrar. O e-mail já pode estar em uso ou os dados estão incorretos.');
        }
    } catch (erro) {
        console.error('Erro na requisição:', erro);
        alert('Erro de conexão. Verifique se o banco de dados e o servidor Back-end estão rodando.');
    }
});