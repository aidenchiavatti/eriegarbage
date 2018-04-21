$(document).ready(function(){
    $(".sendReceiptButtons").click(function(event) {
        var token = $("input[name='_csrf']").val();
        $.ajax({
            url:'/sendReceipt?id=' + event.target.id,
            type:'post',
            beforeSend: function(xhr) {
                xhr.setRequestHeader('X-CSRF-TOKEN', token);
            },
            success:function(){
                alert("Receipt has been sent");
            }
        });
    });
});