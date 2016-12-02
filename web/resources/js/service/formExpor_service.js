'use strict';

var app=angular.module("formularioExpor");
  

app.factory("FormExportacionService",['$http', '$q',function($http, $q) {
  var REST_SERVICE_URI = 'http://localhost:8080/SpringMVC0_5/FE';
  
      var factory = {
        findAllFormularioExportacion: findAllFormularioExportacion,
        saveFormularioExportacion: saveFormularioExportacion,
        updateFormularioExportacion:updateFormularioExportacion,
        deleteFormularioExportacionById:deleteFormularioExportacionById
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

   function saveFormularioExportacion(Fexport) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, Fexport)
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


    function updateFormularioExportacion(Fexport, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, Fexport)
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

    function deleteFormularioExportacionById(id) {
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