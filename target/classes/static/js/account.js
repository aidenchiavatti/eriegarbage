$(document).ready(function(){
    $("#editAccountButton").click(function () {
        window.location.href = "/viewAccountPageEdit"
    })
    $("#cancelAccountButton").click(function () {
        $("#suspendDiv").html("");
        $("#cancelDiv").html("<p>Cancelling is final! You would have to re-register to get an account back</p><br><button "+
            "class=\"btn btn-light btn-lg action-button\" type=\"button\" id='continueToCancelButton'>Continue</button><button "+
            "class=\"btn btn-light btn-lg action-button secondCancelButton\" type=\"button\">Cancel</button>");
    })
    $(document).on("click", "#secondCancelButton", function () {
        $("#cancelDiv").html("");
    })
    $("#suspendAccountButton").click(function () {
        $("#cancelDiv").html("");
        $("#suspendDiv").html("<p>Your account will be suspended the following month.</p><br><button "+
            "class=\"btn btn-light btn-lg action-button\" type=\"button\" id='continueToSuspendButton'>Continue</button><button "+
            "class=\"btn btn-light btn-lg action-button secondCancelButton\" type=\"button\">Cancel</button>");
    })
    $(document).on("click", "#continueToCancelButton", function () {
        $.ajax({
            url:'/cancelAccount',
            type:'get',
            success:function(){
                window.location.href = "/AccountPage"
            }
        });
    })
    $(document).on("click", "#continueToSuspendButton", function () {
        $.ajax({
            url:'/suspendAccountRequest',
            type:'get',
            success:function(){
                $("#suspendDiv").html("");
            }
        });
    })
    $(document).on("click", ".secondCancelButton", function () {
        $("#cancelDiv").html("");
        $("#suspendDiv").html("");
    })
});