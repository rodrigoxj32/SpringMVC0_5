
    var FE = angular.module("formularioExp", []);

    FE.controller('exportacion', ['$scope',function($scope) {
       
      $scope.origen = "entro";
       
      $scope.guardar = function () {
      $scope.origen = "funciono el metodo";
        }
      
      //FormExportacionService.createFormularioExportacion();
      
    }]);
