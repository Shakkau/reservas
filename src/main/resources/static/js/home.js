$('a').click(function(event){
   event.preventDefault();
   if(!$(this).hasClass('btn')){
      $('a').removeClass('active disabled');
      $(this).addClass('active disabled');
   }
      controleDeRotas($(this).attr("href"));
});

function gerarSwal(urlSucesso){
const swalWithBootstrapButtons = Swal.mixin({
     customClass: {
       confirmButton: 'btn btn-success m-2',
       cancelButton: 'btn btn-danger m-2'
     },
     buttonsStyling: false
   })

   swalWithBootstrapButtons.fire({
     title: 'Tem certeza?',
     text: "Seu login será desfeito!",
     icon: 'warning',
     showCancelButton: true,
     confirmButtonText: 'Sim, finalizar!',
     cancelButtonText: 'Não, cancelar!',
     reverseButtons: true
   }).then((result) => {
     if (result.isConfirmed) {
       $.get("/logout");
       window.location.href="/";
     }
   });
}

function alertaSucesso(mensagem){
    Swal.fire({
        position: 'top-end',
        toast: true,
        icon: 'success',
        title: mensagem,
        showConfirmButton: false,
        timer: 2000
    });
}

function salvarReserva(){
        const dataReserva = $("#data").val();
        const quantidade = $("#qtd").val();
        const dataCriacao = new Date().toLocaleDateString();

        const novaLinha = $("<tr>");
        novaLinha.append($("<td>").text(dataReserva));
        novaLinha.append($("<td>").text(quantidade));
        novaLinha.append($("<td>").text(dataCriacao));

        $("#tabela-reservas").append(novaLinha);

        $("#data").val("");
        $("#qtd").val("");
};