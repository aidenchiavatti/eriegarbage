var selectedId;

$(document).ready(function(){
    $("#submitDisputeResponse").click(function (event) {
        var response = $("#disputeText").val();
        var token = $("input[name='_csrf']").val();
        var data = {};
        data.id = parseInt(selectedId);
        data.response = response;
        $.ajax({
            url:'/respondToDispute',
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
    });

    $(".respondDisputeButtons").click(function (event) {
        selectedId = event.target.id;
    });
});