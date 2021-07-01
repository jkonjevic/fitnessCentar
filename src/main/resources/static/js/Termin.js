/*
$(document).on('load', '.btnSeeMore', function () {

    let id = localStorage.getItem("ID");


    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/termini/getAllSale/" + id,
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for(sala of response){

                let row += "<option value="+"sala.id"+">"+sala.oznaka+"</option>";
            }

            console.log(localStorage.getItem("ID"));
            console.log(localStorage.getItem("ULOGA"));

        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});
*/