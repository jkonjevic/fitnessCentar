$(document).on("submit", "#registracija", function (event) {
    event.preventDefault();

    // preuzimamo vrednosti unete u formi
    let id = $("#id").val();


    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/fitnesCentar/delete/"+id,
        success: function (response) {
            console.log(response);

            alert("FitnesCentar" + response.id + " je uspešno obrisan!");
            window.location.href = "sviFitnesCentri.html";
        },
        error: function () {
            console.log("usao sam u error");
           // window.location.href = "adminHomePage.html";
        }
    });
});