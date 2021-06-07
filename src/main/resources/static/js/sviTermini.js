$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/termini",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);
            console.log(response);

            for (let termin of response) {
                let row = "<tr>";
                row += "<td>" + termin.id + "</td>";
                row += "<td>" + termin.naziv + "</td>";
                row += "<td>" + termin.pocetak + "</td>";
                row += "<td>" + termin.tip + "</td>";
                row += "<td>" + termin.cijena + "</td>";
                row += "<td>" + termin.oznaka + "</td>";
                row += "</tr>";

                $('#korisnici').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });


});


