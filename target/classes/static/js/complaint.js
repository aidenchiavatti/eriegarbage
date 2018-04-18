$(document).ready(function(){
    $('#submitComplaintButton').click(function(){
        $.ajax({
            url:'/submitComplaint',
            type:'post',
            data:$('#complaintInput').serialize(),
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

    /*$("#viewComplaintsButton").click(function(event) {
        var id = event.target.id;
        $.ajax({
            url:'/viewComplaintPage',
            type:'get',
            success:function(result){
                console.log(result);
            }
        });
    });*/
})