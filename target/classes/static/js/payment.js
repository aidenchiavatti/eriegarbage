$(document).ready(function(){
    $(".sendReceiptButtons").click(function(event) {
        $("#" + event.target.id).hide();
        $("#loader" + event.target.id).show();
        $.ajax({
            url:'/admin/payments/' + event.target.id + '/email',
            type:'post',
            success:function(){
                $("#loader" + event.target.id).hide();
                alert("Receipt has been sent");
            }
        });
    });
});