$(document).on("submit", "#registracija", function (event) {
    event.preventDefault();

    // preuzimamo vrednosti unete u formi
    let naziv = $("#ime").val();
    let adresa = $("#adresa").val();
    let brCentrale = $("#kontakt").val();
    let email = $("#email").val();


    let newFitnesCentar = {
        naziv,
        adresa,
        brCentrale,
        email
    }
    console.log(newFitnesCentar);


    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/fitnesCentar/add",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newFitnesCentar),
        success: function (response) {
            console.log(response);

            alert("FitnesCentar" + response.id + " je uspešno kreiran!");
            window.location.href = "sviFitnesCentri.html";
        },
        error: function () {
            alert("Greška prilikom kreiranja fitnes centra!");
        }
    });
});