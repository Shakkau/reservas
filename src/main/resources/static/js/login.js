$("#login").click(enviarDadosLogin);

function enviarDadosLogin(){
    let matricula = $("#matricula").val();
    let senha = $("#senha").val();

    $.ajax({
        type: "POST",
        url: "/login",
        data: {
            matricula: matricula,
            senha: senha
        },
        success: function(data){
            if(data){
                window.location.href="/Home";
            }
        },
        error: function(){
            alert("Falha ao enviar dados");
        }
    });
}