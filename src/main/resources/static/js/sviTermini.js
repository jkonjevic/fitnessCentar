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
                row += "<td>" + new Date( termin.pocetak).toLocaleString() + "</td>";
                row += "<td>" + termin.tip + "</td>";
                row += "<td>" + termin.cijena + "</td>";
                row += "<td>" + termin.oznaka + "</td>";
                row += "</tr>";

                $('#korisnici tbody').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });


    $("#trazi").on("click", function(event){
        event.preventDefault();

        let naziv = $('#nazivField').val();
        let tip = $('#tipField').val();
        let opis = $('#opisField').val();
        let cijenaDo = $('#cijenaDoField').val();
        let datumOd = $('#datumOdField').val();
        let sortVrijeme = $('#sort').val();     //sta je Selektovano za VrijemeSort... Cuvamo u sortVrijeme
        let sortCijena = $('#sort2').val();      //sta je selektovano za CijenaSort... Cuvamo u sortCijena

        if($('#nazivField').val()!=""){
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/api/termini/naziv?naziv="+$('#nazivField').val(),
                dataType: "json",
                success: function (response) {
                    console.log("SUCCESS:\n", response);
                    console.log(response);
                    $('#korisnici tbody').html("");
                    for (let termin of response) {
                        let row = "<tr>";
                        row += "<td>" + termin.id + "</td>";
                        row += "<td>" + termin.naziv + "</td>";
                        row += "<td>" + new Date( termin.pocetak).toLocaleString() + "</td>";
                        row += "<td>" + termin.tip + "</td>";
                        row += "<td>" + termin.cijena + "</td>";
                        row += "<td>" + termin.oznaka + "</td>";
                        row += "</tr>";

                        $('#korisnici tbody').append(row);
                    }
                },
                error: function (response) {
                    console.log("ERROR:\n", response);
                }
            });

        }
        if($('#tipField').val()!=""){
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/api/termini/tip?tip="+$('#tipField').val(),
                dataType: "json",
                success: function (response) {
                    console.log("SUCCESS:\n", response);
                    console.log(response);
                    $('#korisnici tbody').html("");
                    for (let termin of response) {
                        let row = "<tr>";
                        row += "<td>" + termin.id + "</td>";
                        row += "<td>" + termin.naziv + "</td>";
                        row += "<td>" + new Date( termin.pocetak).toLocaleString() + "</td>";
                        row += "<td>" + termin.tip + "</td>";
                        row += "<td>" + termin.cijena + "</td>";
                        row += "<td>" + termin.oznaka + "</td>";
                        row += "</tr>";

                        $('#korisnici tbody').append(row);
                    }
                },
                error: function (response) {
                    console.log("ERROR:\n", response);
                }
            });

        }

        if($('#datumOdField').val()!=""){
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/api/termini/pretragaVrijeme?pocetak="+$('#datumOdField').val(),
                dataType: "json",
                success: function (response) {
                    console.log("SUCCESS:\n", response);
                    console.log(response);
                    $('#korisnici tbody').html("");
                    for (let termin of response) {
                        let row = "<tr>";
                        row += "<td>" + termin.id + "</td>";
                        row += "<td>" + termin.naziv + "</td>";
                        row += "<td>" + new Date( termin.pocetak).toLocaleString() + "</td>";
                        row += "<td>" + termin.tip + "</td>";
                        row += "<td>" + termin.cijena + "</td>";
                        row += "<td>" + termin.oznaka + "</td>";
                        row += "</tr>";

                        $('#korisnici tbody').append(row);
                    }
                },
                error: function (response) {
                    console.log("ERROR:\n", response);
                }
            });

        }
        if($('#opisField').val()!=""){
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/api/termini/opis?opis="+$('#opisField').val(),
                dataType: "json",
                success: function (response) {
                    console.log("SUCCESS:\n", response);
                    console.log(response);
                    $('#korisnici tbody').html("");
                    for (let termin of response) {
                        let row = "<tr>";
                        row += "<td>" + termin.id + "</td>";
                        row += "<td>" + termin.naziv + "</td>";
                        row += "<td>" + new Date( termin.pocetak).toLocaleString() + "</td>";
                        row += "<td>" + termin.tip + "</td>";
                        row += "<td>" + termin.cijena + "</td>";
                        row += "<td>" + termin.oznaka + "</td>";
                        row += "</tr>";

                        $('#korisnici tbody').append(row);
                    }
                },
                error: function (response) {
                    console.log("ERROR:\n", response);
                }
            });

        }

        if($('#cijenaOdField').val()!=""){
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/api/termini/pretraga?cijena="+$('#cijenaOdField').val(),
                dataType: "json",
                success: function (response) {
                    console.log("SUCCESS:\n", response);
                    console.log(response);
                    $('#korisnici tbody').html("");
                    for (let termin of response) {
                        let row = "<tr>";
                        row += "<td>" + termin.id + "</td>";
                        row += "<td>" + termin.naziv + "</td>";
                        row += "<td>" + new Date( termin.pocetak).toLocaleString() + "</td>";
                        row += "<td>" + termin.tip + "</td>";
                        row += "<td>" + termin.cijena + "</td>";
                        row += "<td>" + termin.oznaka + "</td>";
                        row += "</tr>";

                        $('#korisnici tbody').append(row);
                    }
                },
                error: function (response) {
                    console.log("ERROR:\n", response);
                }
            });

        }

        if($('#cijenaOdField').val()!=""){
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/api/termini/pretraga?cijena="+$('#cijenaOdField').val(),
                dataType: "json",
                success: function (response) {
                    console.log("SUCCESS:\n", response);
                    console.log(response);
                    $('#korisnici tbody').html("");
                    for (let termin of response) {
                        let row = "<tr>";
                        row += "<td>" + termin.id + "</td>";
                        row += "<td>" + termin.naziv + "</td>";
                        row += "<td>" + new Date( termin.pocetak).toLocaleString() + "</td>";
                        row += "<td>" + termin.tip + "</td>";
                        row += "<td>" + termin.cijena + "</td>";
                        row += "<td>" + termin.oznaka + "</td>";
                        row += "</tr>";

                        $('#korisnici tbody').append(row);
                    }
                },
                error: function (response) {
                    console.log("ERROR:\n", response);
                }
            });

        }



    });

});


