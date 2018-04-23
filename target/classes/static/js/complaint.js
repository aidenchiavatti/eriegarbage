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
<<<<<<< HEAD
});
=======
    $(".complaintResponseBtns").click(function(event){
        var temp = event.target.id.substr(7);
        var selector = "#complaintResponseDiv" + temp;
        $(selector).css("display", "inline-block");
    });
})
>>>>>>> responding to complaints
