$(document).ready(function(){
    $('#submitButton').click(function(e){
        e.preventDefault();
        var token = $("input[name='_csrf']").val();
        var formData = {};
        formData.firstName = $("#firstName").val();
        formData.lastName = $("#lastName").val();
        formData.address = $("#address").val();
        $.ajax({
            url:'/submitAccountEdit',
            type:'post',
            contentType: "application/json; charset=utf-8",
            beforeSend: function(xhr) {
                xhr.setRequestHeader('X-CSRF-TOKEN', token);
            },
            data:JSON.stringify(formData),
            success:function(){
                alert("Submitted Account");
            }
        });
    });

});