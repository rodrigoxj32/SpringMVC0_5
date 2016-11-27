var app=angular.module("formularioExp",[]);
  
app.controller("exportacion",["$scope","FormExportacionService",function($scope,FormExportacionService) {
  var self=this;
  
  self.datos = {id_formexpor:null,id_usuario:null,id_transp:null,codigo_formexpor:'0001',origen_formexpor:1,instancias_formexpor:3,observaciones_formexpor:'pruebo si inicia',fecha_formexpor:'2016-11-14'};
  
    $scope.obtener = function(){
        $scope.idioma = "algo";      

        //$scope.suma=
        FormExportacionService.guardar(self.datos);
    }
    
}]);