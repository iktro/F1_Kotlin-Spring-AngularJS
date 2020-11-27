angular.module("mainModule", []).controller("mainController", function ($http) {
    let that = this
    const baseURL = 'http://localhost:8080/f1/api/'

    $http({
        method: 'GET',
        url: baseURL + ''
    }).then(function succesCallBack(response) {
        that.result = response.data;
    })
})