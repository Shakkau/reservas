function cadastrarUsuario(){
    let nome = $("#nome").val();
    let matricula = $("#matricula").val();
    let cargo = $("#ocupacao option:selected").val();
    let email = $("#email").val();

    $.ajax({
        type: "POST",
        url: "/cadastro",
        data: {
            nome: nome,
            matricula: matricula,
            email: email,
            cargo: cargo
        },
        success: function(data){
            alertaSucesso(data);
        },
        error: function(){
            alert('Falha ao cadastrar o usuário.');
        }
    });
}

function editarUsuario(){
    let nome = $("#novoNome").val();
    let cargo = $("#ocupacao option:selected").val();
    let matricula = $("#novaMatricula").val();
    let email = $("#novoEmail").val();
    let ativo = $("#ativo").prop("checked");
    let senhaAtual = $("#senhaAtual").val();
    let novaSenha = $("#novaSenha").val();
    let confirmaNovaSenha = $("#confirmaNovaSenha").val();

    $.ajax({
        type: "POST",
        url: "/edit/usuario",
        data:{
            nome: nome,
            cargo: cargo,
            matricula: matricula,
            email: email,
            ativo: ativo,
            senhaAtual: senhaAtual,
            novaSenha: novaSenha,
            confirmaNovaSenha: confirmaNovaSenha
        },
        success: function(data){
            if(data.sucesso){
                alert("Ok: " + data.mensagem);
            } else {
                alert("PREENCHE DIREITO" + data.mensagem);
            }
        },
        error: function(){
            alert("não fununcio mt bem");
        }
    })
}