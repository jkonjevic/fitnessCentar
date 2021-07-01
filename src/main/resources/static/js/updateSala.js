$(document).on("submit", "#registracija", function (event) {
    event.preventDefault();

    // preuzimamo vrednosti unete u formi
    let id = $("#id").val();
    let kapacitet = $("#kapacitet").val();
    let oznaka = $("#oznaka").val();
    let idCentra = $("#idCentra").val();


    let newFitnesCentar = {
        id,
        kapacitet,
        oznaka,
        idCentra
    }
    console.log(newFitnesCentar);


    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/Sale/updateSala/"+id,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newFitnesCentar),
        success: function (response) {
            console.log(response);

            alert("Sala" + response.id + " je uspešno updateovana!");
            window.location.href = "adminHomePage.html";
        },
        error: function () {
            alert("Greška prilikom update-a!");
        }
    });
});