$(document).ready(function(){
    $('#submitComplaintButton').click(function(e){
        e.preventDefault();
        $.ajax({
            url:'/complaint',
            type:'post',
            data:$('#submitComplaintForm').serialize(),
            success:function(){
                alert("Submitted Complaint");
            }
        });
    });

    $(".viewedButtons").click(function(event) {
        $.ajax({
            url:'/admin/complaint/' + event.target.id.substr(6) + '/viewed',
            type:'post',
            success:function(){
                alert("Complaint Has Been Viewed");
            }
        });
    });

    $(".respondButtons").click(function(event){
        var temp = event.target.id.substr(7);
        var selector = "#complaintResponseDiv" + temp;
        $(selector).css("display", "inline-block");
    });

    $(".complaintRespCancelButtons").click(function(event){
        var temp = event.target.id.substr(14);
        var selector = "#complaintResponseDiv" + temp;
        $(selector).css("display", "none");
    });

    $(".complaintRespSubmitButtons").click(function(event){
        var id = event.target.id.substr(14);
        var inputSelector = "#complaintResponseInput" + id;
        var response = $(inputSelector).val();
        var data = {};
        data.response = response;
        $.ajax({
            url:'/admin/complaint/' + parseInt(id) + '/respond',
            type:'post',
            contentType: "application/json",
            data: JSON.stringify(data),
            success:function(){
                alert("Response Submitted");
            }
        });
        var divSelector = "#complaintResponseDiv" + temp;
        $(divSelector).css("display", "none");
    });
});
