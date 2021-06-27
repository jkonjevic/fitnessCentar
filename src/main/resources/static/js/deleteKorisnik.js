$(document).on("submit", "#registracija", function (event) {
    event.preventDefault();

    // preuzimamo vrednosti unete u formi
    let id = $("#id").val();

    let newFitnesCentar = {
        id
    }
    console.log(newFitnesCentar);


    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/deleteKorisnik/"+id,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newFitnesCentar),
        success: function (response) {
            console.log(response);

            alert("Korisnik" + response.id + " je uspešno obrisan!");
            window.location.href = "adminHomePage.html";
        },
        error: function () {
            window.location.href = "adminHomePage.html";
        }
    });
});