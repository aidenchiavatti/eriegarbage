$(document).ready(function () {
    $(".suspendAccountButtons").click(function (event) {
        var token = $("input[name='_csrf']").val();
        $.ajax({
            url:'/SuspendAccount',
            type:'post',
            beforeSend: function(xhr) {
                xhr.setRequestHeader('X-CSRF-TOKEN', token);
            },
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