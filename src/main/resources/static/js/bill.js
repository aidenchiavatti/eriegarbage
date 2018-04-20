$(document).ready(function(){
    $(".payBillButton").click(function (event) {
        var token = $("input[name='_csrf']").val();
        var paymentInfo = {};
        paymentInfo.cardType = "discover";
        paymentInfo.cardNumber = "1234";
        paymentInfo.paymentAmount = 20;
        $.ajax({
            url:'/payBill?id=' + event.target.id,
            type:'post',
            beforeSend: function(xhr) {
                xhr.setRequestHeader('X-CSRF-TOKEN', token);
            },
            contentType: 'application/json',
            data: JSON.stringify(paymentInfo),
            success:function(){
                alert("Bill Has Been Paid");
            },
            error:function(error) {
                alert(error);
            }
        });
    })
});