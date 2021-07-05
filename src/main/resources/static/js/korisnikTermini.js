$(document).ready(function () {
    let idKorisnika = localStorage.getItem("ID");
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/termini/korisnikTermini/"+idKorisnika,
        dataType: "json",
        success: function (response) {
            console.log(response);
            for (let termin of response) {
                let row = "<tr>";
                row += "<td>" + termin.id + "</td>";
                row += "<td>" + termin.naziv + "</td>";
                row += "<td>" + new Date(termin.pocetak).toLocaleString() + "</td>";
                row += "<td>" + termin.tip + "</td>";
                row += "<td>" + termin.cijena + "</td>";
                row += "<td>" + termin.oznaka + "</td>";
                row += "<td>" + termin.opis + "</td>";
                row += "<td>" + "<button class='odjavi' id=" + response.id + ">Odjavi trening</button>" + "</td>";
                row += "</tr>";
                $('#korisnici tbody').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});

$(document).on('click', '.odjavi', function myFunction(event) {
    event.preventDefault();
    console.log(localStorage.getItem("ID"),localStorage.getItem("termin"));
    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/termini/odjavaTrening/"+localStorage.getItem("ID")+"/"+ localStorage.getItem("termin"),
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(),
        success: function (response) {
            console.log(response);
            alert("PROSLO SVE OK");
        },
        error: function(response) {
            console.log("NEUSPJESNO: \n", response);
            alert("PROSLO SVE KAKO TREBA");
        }
    });
    window.location.href = "korisnikTermin.html";

});