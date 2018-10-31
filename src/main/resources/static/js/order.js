

// Begin Something modal population and submit functions
var url = "/inquery/details/data/";
var editModalTarget = url + "edit/";

var id;

// Build the url for the Ajax request for Something.
function showOrderEditModal(index) {
    var editUrl = editModalTarget + index;
   // id=index;
   // alert(id);
    populateBuyerList(index,editUrl);
    
 
}


// Ajax request for Something to populate the modal form.
function loadEntity(url) {
	
    $.getJSON(url, {}, function (data) {
        populateModal(data);
    });
}

// Assign the data values to the modal form.
function populateBuyerList(index,editUrl){
	var url="/inquery/owner/edit/"+index;
	$.getJSON(url, {
        ajax : 'true'
    }, function(data) {
        var html = '<option value="0">Select Buyer Name</option>';
        var len = data.length;
        for ( var i = 0; i < len; i++) {
            html += '<option value="' + data[i].orderOwnerId + '">'
                    + data[i].ownerName + '</option>';
           // alert(data[i].ownerName);
        }
        html += '</option>';
        $('#update-Buyer-name').html(html);
    }); 
	loadEntity(editUrl);
}
function populateModal(data) {
	$('#update-owner-type').val(data.modelOrderOwnerType.orderOwnerTypeId);
	$('#update-Inquery').val(data.orderId);
    $('#update-mail').val(data.refMailId);
    $('#validationCustom08').val(data.userOrderNo);
    $('#aprox-order').val(data.aprxOrderQty);
    $('#remarks').val(data.orderRemarks);
    $('#update-Buyer-name').val(data.modelOrderOwner.orderOwnerId);
    $('#update-Ultimate-Buyer-Name').val(data.ultimateOwner.orderOwnerId);
    
    $('#update-user-cluster').val(data.modelCluster.clusterId);
    $('#update-user').val(data.enteredBy.userId);
    $('#update-ref-no').val(data.userRefNo);
    $('#update-Inquery-Date').val(data.dateCheck);
    $('#update-Mail-sent-date').val(data.dateMailSent);
    $("#update-Mail-Receive-Date").val(data.dateMailReceive);
    $('#update-aprox-order').val(data.aprxOrderQty);
    $('#update-Buyer-Expected-Date').val(data.dateBuyerExpectedDate);
 
}
