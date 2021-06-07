$(document).ready(function () {  
    $.ajax({
        type: "GET",                                                
        url: "http://localhost:8080/api/treneri",                 
        dataType: "json",                                           
        success: function (response) {                              
            console.log("SUCCESS:\n", response);                    

            for (let korisnik of response) {                        
                let row = "<tr>";                                   
                row += "<td>" + korisnik.id + "</td>";   
                row += "<td>" + korisnik.ime + "</td>";
                row += "<td>" + korisnik.prezime + "</td>";
                row += "<td>" + korisnik.korisnickoIme + "</td>";
                row += "<td>" + korisnik.email + "</td>";
                row += "<td>" + korisnik.kontakt + "</td>";
                row += "<td>" + korisnik.datum + "</td>";
                row+="<td><input type = 'checkbox' /> </td>"
                row += "</tr>";                                     

                $('#korisnici').append(row);                        
            }
        },
        error: function (response) {                                
            console.log("ERROR:\n", response);
        }
    });
});


