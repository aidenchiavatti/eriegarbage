var app = angular.module('myApp', []);
app.controller('billController', function($scope, $http) {
    $('#paymentModal').modal('toggle');

    //set bill for user as table content
    $http.get("/bill").then(function (response) {$scope.bills = response.data;});

    //sets index of bill to be payed. called when opening payment modal
    $scope.selectBillForPayment = function(index) {
        $scope.selectedBillIndex = index;
    };

    //sends payment. will update table if successful, and close modal
    $scope.payBill = function () {
        var paymentInfo = {};
        paymentInfo.creditCardNumber = $("#paymentCreditCardNumber").val();
        paymentInfo.paymentTotal = 20;
        $.ajax({
            url:'/bill/' + $scope.bills[$scope.selectedBillIndex].billId + '/pay',
            type:'post',
            contentType: 'application/json',
            data: JSON.stringify(paymentInfo),
            success:function(){
                $('#paymentModal').modal('toggle');
                $scope.bills.splice($scope.selectedBillIndex, 1);
                $scope.$apply();
            },
            error:function(error) {
                alert(error);
            }
        });
    };
});