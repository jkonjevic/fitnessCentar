$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/korisnici/"+localStorage.getItem("ID"),
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);
            console.log(response);


                let row = "<tr>";
                row += "<td>" + response.id + "</td>";
                row += "<td>" + response.ime + "</td>";
                row += "<td>" + response.prezime + "</td>";
                row += "<td>" + response.korisnickoIme + "</td>";
                row += "<td>" + response.email + "</td>";
                row += "<td>" + response.kontakt + "</td>";
                row += "<td>" + response.datum + "</td>";
                row += "</tr>";

                $('#korisnici').append(row);
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });

});


