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
        obj.id = event.target.id;
        $.ajax({
            url:'/markComplaintAsViewed',
            type:'post',
            data: JSON.stringify(obj),
            success:function(){
                alert("Complaint Has Been Viewed");
            }
        });
    });
})