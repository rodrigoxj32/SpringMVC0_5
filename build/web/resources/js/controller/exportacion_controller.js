
    var FE = angular.module("formularioExp", []);

    FE.controller('exportacion', function($scope) {
       
      $scope.origen = "entro";
       
      $scope.guardar = function () {
      $scope.origen = "funciono el metodo";
        }
        
    });
