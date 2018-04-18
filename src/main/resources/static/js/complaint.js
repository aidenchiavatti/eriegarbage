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