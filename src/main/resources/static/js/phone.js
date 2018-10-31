var url = "/owners/";
var editModalTarget = url + "search/phone/";


function loadData(index) {
   
    var dataUrl = editModalTarget+ index;
    $.getJSON(dataUrl, {}, function (data) {
        updateTable(data,dataUrl);
    });

}


function showAuditModal(index) {
	   
   alert(index);

}

function updateTable(data,dataUrl) {
    $.ajax({
        dataType: "json",
        url: dataUrl,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: 'GET',
        success: function (response) {
           $('#table-body').empty();
        	
            $.each(response, function (i, e) {
            	
            	 var end = e.phoneId + ");'";
                 var audit = "'showAuditModal(" + end;
                 
                var row = $('<tr>').append(
                    $('<td>').text(e.modelCountry.dialCode),
                    $('<td>').text(e.areaCode),
                    $('<td>').text(e.phoneNumber),
                    $('<td>').text(e.sActive),
                    $('<td>').text(e.sEmergency),
                    
                    $('<td>').append(
                            "<a class='btn btn-success btn-sm' onclick=" +
                            audit + ">Audit</a>"
                        )
                      
                    );
                $('#tablePhone').append(row);
            });
        }
    });
}
