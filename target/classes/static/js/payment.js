$(document).ready(function(){
    $(".sendReceiptButtons").click(function(event) {
        $("#" + event.target.id).hide();
        $("#loader" + event.target.id).show();
        var token = $("input[name='_csrf']").val();
        $.ajax({
            url:'/sendReceipt?id=' + event.target.id,
            type:'post',
            beforeSend: function(xhr) {
                xhr.setRequestHeader('X-CSRF-TOKEN', token);
            },
            success:function(){
                $("#loader" + event.target.id).hide();
                alert("Receipt has been sent");
            }
        });
    });
});