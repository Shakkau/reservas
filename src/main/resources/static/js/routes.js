function controleDeRotas(url){
    switch(url){
        case "/logout":
            gerarSwal(url);
            break;
        case "cadastro/notebook":
            $("#enviar").click(enviaCadastroNotebook);
            break;
    }
}