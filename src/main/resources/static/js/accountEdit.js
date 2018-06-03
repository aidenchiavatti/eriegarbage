$(document).ready(function(){
    $('#submitButton').click(function(e){
        e.preventDefault();
        var formData = {};
        formData.firstName = $("#firstName").val();
        formData.lastName = $("#lastName").val();
        formData.address = $("#address").val();
        $.ajax({
            url:'/submitAccountEdit',
            type:'post',
            contentType: "application/json; charset=utf-8",
            data:JSON.stringify(formData),
            success:function(){
                window.location.href = "/viewAccountPage"
            }
        });
    });

});