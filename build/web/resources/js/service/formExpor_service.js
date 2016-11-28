'use strict';

var app=angular.module("formularioExpor");
  

app.factory("FormExportacionService",['$http', '$q',function($http, $q) {
  var REST_SERVICE_URI = 'http://localhost:8080/proyecto2/FE/';
  
      var factory = {
        findAllFormularioExportacion: findAllFormularioExportacion,
        saveFormularioExportacion: saveFormularioExportacion,
        updateExportacion:updateExportacion,
        deleteExportacion:deleteExportacion
    };

    return factory;

    function findAllFormularioExportacion() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error mientras se obtenian  los Formularios de exportacion');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

   function saveFormularioExportacion(Farancel) {
       alert('save de los servicios angular')
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, Farancel)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error Mientras Se creaba el fomulario de exportacion');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


    function updateExportacion(Farancel, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, Farancel)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error actualizando formulario de exportacion');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteExportacion(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error eliminando formulario de exportacion');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
}]);