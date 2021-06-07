$(document).ready(function () {  
    $.ajax({
        type: "GET",                                                
        url: "http://localhost:8080/api/treneri",                 
        dataType: "json",                                           
        success: function (response) {                              
            console.log("SUCCESS:\n", response);
            console.log(response);

            for (let korisnik of response) {                        
                let row = "<tr>";                                   
                row += "<td>" + korisnik.id + "</td>";   
                row += "<td>" + korisnik.ime + "</td>";
                row += "<td>" + korisnik.prezime + "</td>";
                row += "<td>" + korisnik.korisnickoIme + "</td>";
                row += "<td>" + korisnik.email + "</td>";
                row += "<td>" + korisnik.kontakt + "</td>";
                row += "<td>" + korisnik.datum + "</td>";
                row+="<td><input type = 'checkbox' data-id='"+korisnik.id+"' /> </td>"
                row += "</tr>";                                     

                $('#korisnici').append(row);                        
            }
        },
        error: function (response) {                                
            console.log("ERROR:\n", response);
        }
    });
$("#submitDugme").on("click", function(event){
    event.preventDefault();
    let ids = []
    $("[type='checkbox']").each(function(elem){
        console.log(this)
        if($(this).is(":checked")){
            ids.push($(this).attr("data-id"));
            window.location.href = "admin_accept.html";
        }
    })
    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/odobriTrenera",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(ids)
    });
    })

});


