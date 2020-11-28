angular.module("myApp", []).controller("mainController", function ($http, $scope) {
    let that = this
    const baseURL = '/f1/api/'

    $http({
        method: 'GET',
        url: baseURL + 'seasons/list'
    }).then(function successCallBack(response) {
        that.seasons = response.data;
        console.log(that.seasons)
        $scope.selectedYear = that.seasons[0].year
        $scope.changeSeason()
    })

    $scope.changeSeason = function () {
        $http.get(baseURL + "championship/teams/" + $scope.selectedYear, {cache: false})
            .then(function (teams) {
                console.log(teams.data)
                that.teamsSeason = teams.data
            });
        $http.get(baseURL + "championship/pilots/" + $scope.selectedYear, {cache: false})
            .then(function (pilots) {
                that.pilotsSeason = pilots.data
            });
        $http.get(baseURL + "championship/tracks/" + $scope.selectedYear, {cache: false})
            .then(function (tracks) {
                that.tracksSeason = tracks.data
                $scope.selectedTrack = that.tracksSeason[0].id
                $scope.changeTrack()
            });
    }

    $scope.changeTrack = function () {
        $http({
            method: 'GET',
            url: baseURL + "championship/tracksResult/" + $scope.selectedYear + "/" + $scope.selectedTrack,
            data: $scope.selectedTrack
        }).then(function (trackResult) {
            console.log(trackResult)
            that.trackResult = trackResult.data
        });
    }

})