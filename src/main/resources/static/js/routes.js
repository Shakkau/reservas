function controleDeRotas(url){
    switch(url){
        case "/logout":
            gerarSwal(url);
            break;
        case "/home":
            $.get(url, function(data){
                $('#mainContainer').html(data);
                $("#salvar-reserva").click(salvarReserva);
            });
            break;
        case "/cadastro/notebook":
            $.get(url, function(data){
                $('#mainContainer').html(data);
                $("#enviar").click(enviaCadastroNotebook);
            });
            break;
        case "/cadastro":
            $.get(url, function(data){
                $('#mainContainer').html(data);
                $('#enviar').click(cadastrarUsuario);
            });
            break;
        case "/edit/usuario":
            $.get(url, function(data){
                $('#mainContainer').html(data);
                $('#editar').click(editarUsuario);
        });
            break;
        default:
            $.get(url, function(data){
                $("mainContainer").html(data);
            });
    }
}