'use strict';
 
angular.module('proyecto2').controller('FormExportController', ['$scope', 'FormExportacionService', function($scope, FormExportacionService) {
    var self = this;
    self.Fexport={id_formexpor:null,id_usuario:null,id_transp:null,codigo_formexpor:'',origen_formexpor:'',instancias_formexpor:'',observaciones_formexpor:'',fecha_formexpor:''};
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
 
    function createFormularioExportacion(Fexport){
        FormExportacionService.createFormularioExportacion(Fexport)
            .then(
            fetchAllFormularioExportacion,
            function(errResponse){
                console.error('Error creando formulario');
            }
        );
    }
 
    function updateFormularioExportacion(Fexport, id){
        FormExportacionService.updateFormularioExportacion(Fexport, id)
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
        if(self.Fexport.id===null){
            console.log('Nuevo formulario guardado', self.Fexport);
            createFormularioExportacion(self.Fexport);
        }else{
            updateFormularioExportacion(self.user, self.Fexport.id);
            console.log('formulario actualizado ', self.Fexport.id);
        }
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
        self.Fexport={id_formexpor:null,id_usuario:null,id_transp:null,codigo_formexpor:'',origen_formexpor:'',instancias_formexpor:'',observaciones_formexpor:'',fecha_formexpor:''};
        $scope.exportacion.$setPristine(); //reset Form
    }
 
}]);