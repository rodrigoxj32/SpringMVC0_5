var app=angular.module("formularioExp",[]);
  

app.factory("FormExportacionService",function($http, $q) {
  var REST_SERVICE_URI = 'http://localhost:8080/proyecto2/FE/';
  
  return {
    guardar:function(dato) {
        alert(dato["codigo_formexpor"]);
        
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, dato)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error creando usuario');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
        
      //return REST_SERVICE_URI;
    },
    restar:function(a,b) {
      return a-b;
    }
  }
});
  


  
app.controller("exportacion",["$scope","FormExportacionService",function($scope,FormExportacionService) {
  var self=this;
  
  self.datos = {id_formexpor:null,id_usuario:null,id_transp:null,codigo_formexpor:'0001',origen_formexpor:1,instancias_formexpor:3,observaciones_formexpor:'pruebo si inicia',fecha_formexpor:'2016-11-14'};
  
    $scope.obtener = function(){
        $scope.idioma = "algo";      

        //$scope.suma=
        FormExportacionService.guardar(self.datos);
    }
    
}]);