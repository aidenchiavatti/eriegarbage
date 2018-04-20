$(document).ready(function(){
    $("#editButton").click(function () {
        window.location.href = "/viewAccountPageEdit"
    })
    $("#cancelButton").click(function () {
        $("#cancelDiv").html("<p>Cancelling is final! You would have to re-register to get an account back</p><br><button id='continueToCancelButton'>Continue</button><button id='secondCancelButton'>Cancel</button>");
    })
    $(document).on("click", "#secondCancelButton", function () {
        $("#cancelDiv").html("");
    })
    $(document).on("click", "#continueToCancelButton", function () {
        $.ajax({
            url:'/cancelAccount',
            type:'get',
            success:function(){

            }
        });
    })
});