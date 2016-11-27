var app=angular.module("formularioExp");
  

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
  
