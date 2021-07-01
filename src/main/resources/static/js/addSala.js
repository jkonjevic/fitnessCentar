$(document).on("submit", "#registracija", function (event) {
    event.preventDefault();

    // preuzimamo vrednosti unete u formi
    let kapacitet = $("#kapacitet").val();
    let oznaka = $("#oznaka").val();
    let idCentra = $("#idCentra").val();


    let newFitnesCentar = {
        kapacitet,
        oznaka,
        idCentra
    }
    console.log(newFitnesCentar);


    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/Sale/addSala",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newFitnesCentar),
        success: function (response) {
            console.log(response);

            alert("Sala" + response.id + " je uspešno kreirana!");
            window.location.href = "adminHomePage.html";
        },
        error: function () {
            alert("Greška prilikom kreiranja Sale!");
        }
    });
});