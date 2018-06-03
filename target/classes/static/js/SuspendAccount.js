$(document).ready(function () {
    $(".suspendAccountButtons").click(function (event) {
        $.ajax({
            url:'/SuspendAccount',
            type:'post',
            contentType: 'application/json',
            data: JSON.stringify(event.target.id),
            success:function(){
                alert("Account Suspend");
            },
            error:function(error) {
                alert(error);
            }
        });
    });
})