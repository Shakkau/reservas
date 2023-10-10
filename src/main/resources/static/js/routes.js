function controleDeRotas(url){
    switch(url){
        case "/logout":
            gerarSwal(url);
            break;
        case "/home":
            $.get(url, function(data){
                $('#mainContainer').html(data);
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
    }
}