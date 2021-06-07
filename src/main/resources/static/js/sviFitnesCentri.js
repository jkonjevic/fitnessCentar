$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/fitnesCentar",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);
            console.log(response);

            for (let centar of response) {
                let row = "<tr>";
                row += "<td>" + centar.id + "</td>";
                row += "<td>" + centar.naziv + "</td>";
                row += "<td>" + centar.adresa + "</td>";
                row+= "<td>"  + centar.brCentrale + "</td>";
                row += "<td>" + centar.email + "</td>";
                row += "</tr>";

                $('#korisnici').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });


});


