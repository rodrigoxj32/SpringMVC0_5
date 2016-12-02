'use strict';


var FE=angular.module("formularioExpor",[]);
  
FE.controller("exportacion",["$scope","FormExportacionService",function($scope,FormExportacionService) {
  var self = this;
    self.Fexport={id_formexpor:'',id_usuario:'',id_transp:'',codigo_formexpor:'',origen_formexpor:'',instancias_formexpor:'',observaciones_formexpor:'',fecha_formexpor:''};
    self.Fexports=[];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;


    findAllFormularioExportacion();

    function findAllFormularioExportacion(){
        FormExportacionService.findAllFormularioExportacion()
            .then(
            function(d) {
                self.Fexports = d;
            },
            function(errResponse){
                console.error('Error mientras se obtienen los formularios de exportacion');
            }
        );
    }

    function saveFormularioExportacion(Fexport){
        FormExportacionService.saveFormularioExportacion(Fexport)
            .then(findAllFormularioExportacion,
            function(errResponse){
                console.error('Error mientras se creaba El Formulario en el metodo java');
            }
        );
    }

    function updateExportacion(Fexport, id){
        FormExportacionService.updateExportacion(Fexport, id)
            .then(
            findAllFormularioExportacion,
            function(errResponse){
                console.error('Error while actualizando exportacion');
            }
        );
    }

    function deleteExportacion(id){
        FormExportacionService.deleteExportacion(id)
            .then(
            findAllFormularioExportacion,
            function(errResponse){
                console.error('Error while Eliminando exportacion');
            }
        );
    }

    function submit() {
        if(self.Fexport.id_formexpor!==null){
            console.log('Guardando El nuevo Formulario de Exportacion', self.Fexport);
            saveFormularioExportacion(self.Fexport);
        }else{
            updateExportacion(self.Fexport, self.Fexport.id_formexpor);
            console.log('Formulario de Exportacion actualizado con id ', self.Fexport.id_formexpor);
        }
        reset();
    }

    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.Fexports.length; i++){
            if(self.Fexports[i].id === id) {
                self.Fexports = angular.copy(self.Fexports[i]);
                break;
            }
        }
    }

    function remove(id){
        console.log('id to be deleted', id);
        if(self.Fexport.id_formexpor === id) {//clean form if the Farancel to be deleted is shown there.
            reset();
        }
        deleteExportacion(id);
    }


    function reset(){
        self.Fexport={id_formexpor:'',id_usuario:'',id_transp:'',codigo_formexpor:'',origen_formexpor:'',instancias_formexpor:'',observaciones_formexpor:'',fecha_formexpor:''};
        $scope.FormExportacion.$setPristine(); //reset Form
    }
    
}]);