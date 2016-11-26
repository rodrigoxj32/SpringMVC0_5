'use strict';


var app=angular.module("formularioAra");
  

app.factory("FormArancelarioService",['$http', '$q',function($http, $q) {
  var REST_SERVICE_URI = 'http://localhost:8080/SpringMVC0_5/FA/';
  
      var factory = {
        findAllFormularioArancelario: findAllFormularioArancelario,
        saveFormularioArancelario: saveFormularioArancelario,
        updateUser:updateUser,
        deleteUser:deleteUser
    };

    return factory;

    function findAllFormularioArancelario() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error mientras se obtenian  los Formularios Arancelarios');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function saveFormularioArancelario(Farancel) {
        alert("Entro Ultimo Paso saveFormularioArancelario");
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, Farancel)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error mientras crea el Nuevo Formulario Arancelario');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


    function updateUser(Farancel, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, Farancel)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteUser(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
}]);