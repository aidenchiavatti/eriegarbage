var selectedId;

$(document).ready(function(){
    $("#submitDisputeResponse").click(function (event) {
        var response = $(inputSelector).val();
        var token = $("input[name='_csrf']").val();
        var data = {};
        data.id = parseInt(temp);
        data.response = response;
        $.ajax({
            url:'/respondToComplaint',
            type:'post',
            contentType: "application/json",
            data: JSON.stringify(data),
            beforeSend: function(xhr) {
                xhr.setRequestHeader('X-CSRF-TOKEN', token);
            },
            success:function(){
                alert("Response Submitted");
            }
        });
        var divSelector = "#complaintResponseDiv" + temp;
        $(divSelector).css("display", "none");
    });

    $(".respondDisputeButtons").click(function (event) {
        selectedId = event.target.id;
    });
});