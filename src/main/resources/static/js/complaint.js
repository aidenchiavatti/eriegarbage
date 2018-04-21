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
});