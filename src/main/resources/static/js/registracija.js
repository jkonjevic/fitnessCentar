$(document).on("submit", "#registracija", function (event) {
    event.preventDefault();

    // preuzimamo vrednosti unete u formi
    let ime = $("#ime").val();
    let prezime = $("#prezime").val();
    let korisnickoIme = $("#korisnickoIme").val();
    let email = $("#email").val();
    let lozinka = $("#lozinka").val();
    let kontakt = $("#kontakt").val();
    let datum = $("#datum").val();
    let uloga = $("#uloga").is(":checked")?"TRENER":"CLAN";


    let newEmployee = {
        ime,
        prezime,
        korisnickoIme,
        email,
        lozinka,
        kontakt,
        datum,
        uloga
    }


    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/registration",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newEmployee),
        success: function (response) {
            console.log(response);

            alert("Korisnik " + response.id + " je uspešno kreiran!");
            window.location.href = "login.html";
        },
        error: function () {
            alert("Greška prilikom Registracije!");
        }
    });
});