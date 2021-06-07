$(document).on("submit", "#login", function (event) {
    event.preventDefault();
    let korisnickoIme = $("#usernameField").val();
    let lozinka = $("#passwordField").val();



    let newLogin = {
        korisnickoIme,
        lozinka
    }
    console.log(newLogin);
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/login",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newLogin),
        success: function (response) {
            window.location.href = "homePage.html";
        },
        error: function () {                                        // ova f-ja se izvršava posle neuspešnog zahteva
            alert("Greška prilikom dodavanja zaposlenog!");
        }
    });

});
$("#dugme2").on("click", function (event) {
    console.log("test");
    window.location.href = "registracija.html";
});