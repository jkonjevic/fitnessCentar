$(document).on("submit", "#registracija", function (event) {
    event.preventDefault();

    // preuzimamo vrednosti unete u formi
    let naziv = $("#naziv").val();
    let opis = $("#opis").val();
    let tip = $("#tip").val();
    let trajanje = $("#trajanje").val();


    let newTrening = {
        naziv,
        opis,
        tip,
        trajanje
    }
    console.log(newTrening);


    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/trening/addTrening",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newTrening),
        success: function (response) {
            console.log(response);

            alert("Trening" + response.id + " je uspešno kreiran!");
            window.location.href = "sviTreninzi.html";
        },
        error: function () {
            alert("Greška prilikom kreiranja treninga!");
        }
    });
});