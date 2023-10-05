$("a").click(function(event){
   event.preventDefault();
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