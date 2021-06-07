$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/trening",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);
            console.log(response);

            for (let trening of response) {
                let row = "<tr>";
                row += "<td>" + trening.id + "</td>";
                row += "<td>" + trening.naziv + "</td>";
                row += "<td>" + trening.opis + "</td>";
                row += "<td>" + trening.tip + "</td>";
                row += "<td>" + trening.trajanje + "</td>";
                row += "</tr>";

                $('#korisnici').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });


});


