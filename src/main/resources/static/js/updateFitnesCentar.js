$(document).on("submit", "#registracija", function (event) {
    event.preventDefault();

    // preuzimamo vrednosti unete u formi
    let id = $("#id").val();
    let naziv = $("#ime").val();
    let adresa = $("#adresa").val();
    let brCentrale = $("#kontakt").val();
    let email = $("#email").val();


    let newFitnesCentar = {
        id,
        naziv,
        adresa,
        brCentrale,
        email
    }
    console.log(newFitnesCentar);


    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/fitnesCentar/updateFitnesCentar/"+id,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newFitnesCentar),
        success: function (response) {
            console.log(response);

            alert("FitnesCentar" + response.id + " je uspešno updateovan!");
            window.location.href = "sviFitnesCentri.html";
        },
        error: function () {
            alert("Greška prilikom updateovanja fitnes centra!");
        }
    });
});