$(document).ready(function(){
    $('#submitComplaintButton').click(function(e){
        e.preventDefault();
        $.ajax({
            url:'/submitComplaint',
            type:'post',
            data:$('#submitComplaintForm').serialize(),
            success:function(){
                alert("Submitted Complaint");
            }
        });
    });

    $("#viewComplaintsButton").click(function() {
        $.ajax({
            url:'/viewComplaintsTest',
            type:'get',
            success:function(result){
                console.log(result);
            }
        });
    });

    $(".viewedButtons").click(function(event) {
        var obj = {};
        var temp = event.target.id.substr(6);
        obj.id = temp;
        var token = $("input[name='_csrf']").val();
        $.ajax({
            url:'/markComplaintAsViewed?id=' + obj.id,
            type:'post',
            beforeSend: function(xhr) {
                xhr.setRequestHeader('X-CSRF-TOKEN', token);
            },
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
        var temp = event.target.id.substr(14);
        var inputSelector = "#complaintResponseInput" + temp;
        var response = $(inputSelector).val();
        var token = $("input[name='_csrf']").val();

        var data = {};
        data.id = parseInt(temp);
        data.response = response;
        $.ajax({
            url:'/respondToComplaint',
            type:'post',
<<<<<<< HEAD
            contentType: "application/json",
            data: JSON.stringify(data),
=======
            data: JSON.stringify(response),
>>>>>>> trying to get the response string formatted correctly
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
});
