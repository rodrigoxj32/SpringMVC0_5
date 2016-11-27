'use strict';


var app=angular.module("formularioAra",[]);
  
app.controller("arancelario",["$scope","FormArancelarioService",function($scope,FormArancelarioService) {
  var self = this;
    self.Farancel={idFormarancelario:'',usuario:'',CodarancelarioFormarancelario:''};
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
        alert("Entro hijo de putas");
        FormArancelarioService.saveFormularioArancelario(Farancel)
            .then(
            function(errResponse){
                console.error('Error mientras se creaba El Formulario en el metodo java');
            }
        );
    }

    function updateUser(Farancel, id){
        FormArancelarioService.updateUser(Farancel, id)
            .then(
            findAllFormularioArancelario,
            function(errResponse){
                console.error('Error while updating User');
            }
        );
    }

    function deleteUser(id){
        FormArancelarioService.deleteUser(id)
            .then(
            findAllFormularioArancelario,
            function(errResponse){
                console.error('Error while deleting User');
            }
        );
    }

    function submit() {
        alert("Entro casi lo crea");
        if(self.Farancel.idFormarancelario!==null){
            console.log('Guardando El nuevo Formulario Arancelario', self.Farancel);
            saveFormularioArancelario(self.Farancel);
        }else{
            updateUser(self.Farancel, self.Farancel.idFormarancelario);
            console.log('Formulario Arancelario actualizado con id ', self.Farancel.idFormarancelario);
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
        if(self.Farancel.idFormarancelario === id) {//clean form if the Farancel to be deleted is shown there.
            reset();
        }
        deleteUser(id);
    }


    function reset(){
        self.Farancel={idFormarancelario:'',usuario:'',CodarancelarioFormarancelario:''};
        $scope.FormArancelario.$setPristine(); //reset Form
    }
    
}]);