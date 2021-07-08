var kap = 0;
$(document).ready(function () {
    let id = localStorage.getItem('termin');
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/termini/getAllOdabraniTermini/"+id,
        dataType: "json",
        success: function (response) {
                let row = "<tr>";
                row += "<td>" + response.id + "</td>";
                row += "<td>" + response.naziv + "</td>";
                row += "<td>" + new Date( response.pocetak).toLocaleString() + "</td>";
                row += "<td>" + response.tip + "</td>";
                row += "<td>" + response.cijena + "</td>";
                row += "<td>" + response.oznaka + "</td>";
                row += "<td>" + response.opis + "</td>";

                row += "<td>" + "<button class='prijavi' id=" + response.id + ">Prijavi se</button>" + "</td>";
                row += "</tr>";
                kap = response.kapacitet;
                $('#korisnici tbody').append(row);

        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});

$(document).on('click', '.prijavi', function myFunction(event) {
    event.preventDefault();
    if(kap <= 0){
        alert("SVA MJESTA SU ZAUZETA");
        window.location.href = "sviTermini.html";
    }
    else {
        console.log(localStorage.getItem("ID"),localStorage.getItem("termin"));
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/termini/prijavaNaTrening/"+localStorage.getItem("ID")+"/"+ localStorage.getItem("termin"),
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(),
            success: function (response) {
                console.log(response);
                alert("PROSLO SVE OK");
                },
            error: function(response) {
                console.log("NEUSPJESNO: \n", response);
                alert("OK");
            }
        });
        window.location.href = "korisnikTermin.html";
    }
});



