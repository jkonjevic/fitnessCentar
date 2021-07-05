$(document).ready(function () {
    let id = localStorage.getItem("ID");
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/termini/korisnikOcijenjeniTermini/"+id,
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
                row += "<td>" + termin.kapacitet + "</td>";
                row += "</tr>";
                $('#korisnici tbody').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});
