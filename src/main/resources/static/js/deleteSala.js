$(document).on("submit", "#registracija", function (event) {
    event.preventDefault();

    // preuzimamo vrednosti unete u formi
        let id =$("#id").val();


    let newFitnesCentar = {
        id
    }
    console.log(newFitnesCentar);


    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/Sale/deleteSala/"+id,
        success: function (response) {
            console.log(response);

            alert("Sala" + response.id + " je uspešno obrisana!");
            window.location.href = "adminHomePage.html";
        },
        error: function () {
            alert("Greska!");
        }
    });
});