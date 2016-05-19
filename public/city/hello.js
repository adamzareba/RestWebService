function Cities($scope, $http) {
    $http.get('http://localhost:8080/cities').
    success(function(data) {
        $scope.cities = data;
    });
}