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
    let uloga = "TRENER";
    let aktivan = true;


    let newEmployee = {
        ime,
        prezime,
        korisnickoIme,
        email,
        lozinka,
        kontakt,
        datum,
        uloga,
        aktivan: "true"
    }


    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/coachregistration",
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