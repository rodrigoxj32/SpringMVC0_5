var FE = angular.module("formularioExp");

FE.factory('FormExportacionService', function($http, $q){
 
    var REST_SERVICE_URI = 'http://localhost:8080/proyecto2/FE/';
 
    var factory = {
        fetchAllFormularioExportacion: fetchAllFormularioExportacion,
        createFormularioExportacion: createFormularioExportacion,
        updateFormularioExportacion:updateFormularioExportacion,
        deleteFormularioExportacion:deleteFormularioExportacion
    };
 
    return factory;
 
    function fetchAllFormularioExportacion() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Users');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function createFormularioExportacion(user) {
        alert("entro aca");
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, user)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
 
    function updateFormularioExportacion(user, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, user)
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
 
    function deleteFormularioExportacion(id) {
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
 
});