'use strict';


var app=angular.module('formularioAra',[]);
  
app.controller('arancelario',['$scope','FormArancelarioService',function($scope,FormArancelarioService) {
  var self = this;
    self.Farancel={idFa:'',usuario:'',codarancelarioFa:''};
    self.Farancels=[];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;


    findAllFormularioArancelario();

    function findAllFormularioArancelario(){
        FormArancelarioService.findAllFormularioArancelario()
            .then(
            function(d) {
                self.Farancels = d;
            },
            function(errResponse){
                console.error('Error mientras se obtienen los formularios de aranceles');
            }
        );
    }

    function saveFormularioArancelario(Farancel){
        console.log('entro al metodo donde esta el metodo java', FormArancelarioService);
        FormArancelarioService.saveFormularioArancelario(Farancel)
            .then(findAllFormularioArancelario,
            function(errResponse){
                console.error('Error mientras se creaba El Formulario en el metodo java');
            }
        );
    }
    

    function updateFormularioArancelario(Farancel, id){
        FormArancelarioService.updateFormularioArancelario(Farancel, id)
            .then(
            findAllFormularioArancelario,
            function(errResponse){
                console.error('Error mientras se actualizaba Formulario Arancelario');
            }
        );
    }

    function deleteFormularioArancelarioById(id){
        FormArancelarioService.deleteFormularioArancelarioById(id)
            .then(
            findAllFormularioArancelario,
            function(errResponse){
                console.error('Error mientras se borraba Formulario Arancelario');
            }
        );
    }

    function submit() {
        if(self.Farancel.idFa!==null){
            console.log('Guardando El nuevo Formulario Arancelario', self.Farancel);
            saveFormularioArancelario(self.Farancel);
        }else{
            updateFormularioArancelario(self.Farancel, self.Farancel.idFa);
            console.log('Formulario Arancelario Actualizado con id ', self.Farancel.idFa);
        }
        reset();
    }

    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.Farancels.length; i++){
            if(self.Farancels[i].id === id) {
                self.Farancel = angular.copy(self.Farancels[i]);
                break;
            }
        }
    }

    function remove(id){
        console.log('id to be deleted', id);
        if(self.Farancel.idFa === id) {//clean form if the Farancel to be deleted is shown there.
            reset();
        }
        deleteFormularioArancelarioById(id);
    }


    function reset(){
        self.Farancel={idFa:'',usuario:'',codarancelarioFa:''};
        $scope.FormArancelario.$setPristine(); //reset Form
    }
    
}]);