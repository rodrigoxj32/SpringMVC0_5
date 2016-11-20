<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body ng-app="formularioExp" >
        
        <div class="generic-container" ng-controller="exportacion" class="form-group" style="width: 300px;text-align: center;margin: 0 auto;">
            <h1>Formulario de exportacion</h1>

            <form ng-submit="exportacion.submit()" name="exportacion">
                <input type="hidden" ng-model="exportacion.datos.id_formexpor" />
                
                    <p>Origen: <input type="text" id="instancias" ng-model="exportacion.datos.origen_formexpor"  class="form-control"></p> 

                    <p>Instancias: <input type="text" ng-model="exportacion.datos.instancias_formexpor" class="form-control"></p> 

                    <p>Observaciones: <input type="text" ng-model="exportacion.datos.observaciones_formexpor" class="form-control"></p> 

                    <p>Fecha: <input type="date" ng-model="exportacion.datos.fecha_formexpor" class="form-control"></p>

                    <input type="submit" value="Guardar" class="btn btn-primary " ng-disabled="exportacion.$invalid">
            </form>
        </div>
        
      <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">    
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
        
    </body>
</html>



<script>

    var FE = angular.module("formularioExp", []);

    FE.controller("exportacion",['$scope', 'FormExportacionService', function($scope, FormExportacionService) {

    var self = this;
       
    self.datos={id_formexpor:null,id_usuario:null,id_transp:null,codigo_formexpor:'',origen_formexpor:'rodrigo',instancias_formexpor:'',observaciones_formexpor:'',fecha_formexpor:''};

    self.Fexports=[];
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
 

    fetchAllFormularioExportacion();
 
    function fetchAllFormularioExportacion(){
        FormExportacionService.fetchAllFormularioExportacion()
            .then(
            function(d) {
                self.Fexports = d;
            },
            function(errResponse){
                console.error('Error buscando formulario');
            }
        );
    }
 
    function createFormularioExportacion(datos){
        FormExportacionService.createFormularioExportacion(datos)
            .then(
            fetchAllFormularioExportacion,
            function(errResponse){
                console.error('Error creando formulario');
            }
        );
    }
 
    function updateFormularioExportacion(datos, id){
        FormExportacionService.updateFormularioExportacion(datos, id)
            .then(
            fetchAllFormularioExportacion,
            function(errResponse){
                console.error('Error actualizando formulario');
            }
        );
    }
 
    function deleteFormularioExportacion(id){
        FormExportacionService.deleteFormularioExportacion(id)
            .then(
            fetchAllFormularioExportacion,
            function(errResponse){
                console.error('Error borrando formulario');
            }
        );
    }
 
    function submit() {
        console.log('Nuevo formulario guardado', self.datos);
        createFormularioExportacion(self.datos);
 
        reset();
    }
 
    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.Fexports.length; i++){
            if(self.Fexports[i].id === id) {
                self.Fexport = angular.copy(self.Fexports[i]);
                break;
            }
        }
    }
 
    function remove(id){
        console.log('id to be deleted', id);
        if(self.Fexport.id === id) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deleteFormularioExportacion(id);
    }
 
 
    function reset(){
        self.datos={id_formexpor:null,id_usuario:null,id_transp:null,codigo_formexpor:'',origen_formexpor:'',instancias_formexpor:'',observaciones_formexpor:'',fecha_formexpor:''};
        $scope.exportacion.$setPristine(); //reset Form
    }

    }]);
    
    
  FE.factory('FormExportacionService', ['$http', '$q', function($http, $q){
 
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
 
}]);

</script>