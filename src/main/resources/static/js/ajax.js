

// Begin Something modal population and submit functions
var url = "/owner/";
var editModalTarget = url + "phone/";

var id;
var tableTarget = url + "loadphone/";
// Build the url for the Ajax request for Something.
function showEditModal(index) {
    var editUrl = editModalTarget + index;
    id=index;
    loadEntity(editUrl);
}

/*function showDeleteModal(index) {
    $('#delete-id').val(index);
}*/

// Ajax request for Something to populate the modal form.
function loadEntity(url) {
    $.getJSON(url, {}, function (data) {
        populateModal(data);
    });
}

// Assign the data values to the modal form.
function populateModal(data) {
    $('#update-phoneId').val(data.phoneId);
    $('#update-ownerId').val(data.owner.orderOwnerId);
    $('#update-typeId').val(data.typeId);
    $('#update-countryId').val(data.modelCountry.countryId);
    $('#update-areaCode').val(data.areaCode);
    $('#update-phoneNumber').val(data.phoneNumber);
    $('#update-emergency').prop('checked', data.emergency);
    $('#update-active').prop('checked',data.active);
}

function clearModal() {
	 $('#update-phoneId').val(0);
	    $('#update-typeId').val('');
	    $('#update-countryId').val('');
	    $('#update-areaCode').val('');
	    $('#update-phoneNumber').val('');
	    $('#update-emergency').prop('checked', false);
	    $('#update-active').prop('checked',false);
}

function closeModal(name) {
    $(name).modal('toggle');
}

function clearAndCloseModal(name) {
    clearModal();
   // closeModal(name);
}

// POST the edits to Something to the server.
function postEdit() {
    var phone = $('#edit-form').serialize();
    var editUrl = url + 'update';
    $.post(editUrl, phone, function (data) {
        updateTable(data);
    });
 //   clearAndCloseModal('#umodal');
}

/*function deleteEntity(entity) {
    var input = $('#delete-id');
    var url = '/' + entity + '/delete/' + input.val();
    $.post(url, function (data) {
        updateTable(data);
    });
    closeModal('#dmodal');
    input.val('');
}*/

function updateTable(data) {
    $.ajax({
        dataType: "json",
        url: "/owner/loadphone/20181000018",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: 'GET',
        success: function (response) {
            $('#table-body').empty();
            $.each(response, function (i, e) {
                var end = e.phoneId + ");'";
                var edit = "'showEditModal(" + end;
              
                var row = $('<tr>').append(
                    $('<td>').text(e.phoneId),
                    $('<td>').text(e.ownerId),
                    $('<td>').text(e.typeId),
                    $('<td>').text(e.countryId),
                    $('<td>').text(e.areaCode),
                    $('<td>').text(e.phoneNumber),
                    $('<td>').text(e.sEmergency),
                    $('<td>').text(e.sActive),
                    
                    $('<td>').append(
                        "<a data-toggle='modal' data-target='#umodal' onclick=" +
                        edit + ">Edit</a>"
                    )
                  
                );
                $('#table').append(row);
            });
        }
    });
}