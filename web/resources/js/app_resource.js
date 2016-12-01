var app = angular.module('formularioAra', ['ngResource']);

app.factory('Formularioarancelario', ['$resource', function ($resource) {
    return $resource('http://localhost:8080/SpringMVC0_5/FA/:idFormarancelario', {idFormarancelario: '@fid'},
	{
		updateFormularioarancelario: {method: 'PUT'}
	}
    );
}]);

app.controller('RestArancel', ['$scope', 'Formularioarancelario', function($scope, Formularioarancelario) {
    var ob = this;
    ob.formularioarancelarios=[];
    ob.formularioarancelario = new Formularioarancelario(); 
    ob.fetchAllFormularioarancelarios = function(){
        ob.formularioarancelarios = Formularioarancelario.query();
        console.log("valor de Recuperacion",ob.formularioarancelarios);
    };
    ob.fetchAllFormularioarancelarios();
    ob.addFormularioarancelario = function(){
	console.log('dentro de guardar');
	if($scope.FormArancelario.$valid) {

	  ob.formularioarancelario.$save(function(formularioarancelario){
	     console.log("Valores",ob.formularioarancelario);
	     ob.flag= 'created';	
	     ob.reset();	
	     ob.fetchAllFormularioarancelarios();
	  },
	  function(err){
	     console.log(err.status);
	     ob.flag='failed';
	  }
          );
        }
    }; 
    ob.editFormularioarancelario = function(id){
	    console.log('dentro de editar');
        ob.formularioarancelario = Formularioarancelario.get({ idFormarancelario: id}, function() {
	       ob.flag = 'edit'; 
	    });
    };    
    ob.updateFormularioarancelarioDetail = function(){
	console.log('Inside update');
	if($scope.personForm.$valid) {
    	   ob.formularioarancelario.$updateFormularioarancelario(function(formularioarancelario){
    		console.log(formularioarancelario); 
		ob.updatedId = formularioarancelario.fid;
				ob.reset();
		ob.flag = 'updated'; 
    		ob.fetchAllFormularioarancelarios();
           });
	}
    };	
    ob.deleteformularioarancelario = function(id){
	    console.log('Inside delete');
	    ob.formularioarancelario = Formularioarancelario.delete({ idFormarancelario: id}, function() {
		ob.reset();  
		ob.flag = 'deleted';
    		ob.fetchAllFormularioarancelarios(); 
	    });
    };		
    ob.reset = function(){
    	ob.formularioarancelario = new Formularioarancelario();
        $scope.FormArancelario.$setPristine();
    };	
    ob.cancelUpdate = function(id){
	    ob.formularioarancelario = new Formularioarancelario();
	    ob.flag= '';	
   	    ob.fetchAllFormularioarancelarios();
    };    
}]);    
   