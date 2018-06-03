var selectedId;

$(document).ready(function(){
    $("#submitDisputeResponse").click(function () {
        var response = $("#disputeText").val();
        var data = {};
        data.response = response;
        $.ajax({
            url:'/admin/disputes/' + parseInt(selectedId) + '/respond',
            type:'post',
            contentType: "application/json",
            data: JSON.stringify(data),
            success:function(){
                alert("Response Submitted");
            }
        });
    });

    $(".respondDisputeButtons").click(function (event) {
        selectedId = event.target.id;
    });
});