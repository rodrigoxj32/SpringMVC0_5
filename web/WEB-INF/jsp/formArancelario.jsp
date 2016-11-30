<%-- 
    Document   : formArancelario
    Created on : 11-29-2016, 12:44:14 PM
    Author     : jonathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Formulario Arancelario</title>

        <!-- Bootstrap Core CSS -->
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="${pageContext.request.contextPath}/resources/css/blog-home.css" rel="stylesheet">
    </head>
<body ng-app="formularioAra">  
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="http://localhost:8080/SpringMVC0_5/index">SIECA</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="http://localhost:8080/SpringMVC0_5-bautista/index">Inicio</a>
                    </li>
                    <li>
                        <a href="http://localhost:8080/SpringMVC0_5-bautista">Formularios Exportacion</a>
                    </li>
                    <li>
                        <a href="http://localhost:8080/SpringMVC0_5-bautista/formularioArancelario">Formularios Arancelarios</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="container">
        <div class="generic-container" ng-controller="RestArancel as ctrl">
        <div class="row">

            <!-- Blog Entries Column -->
            <div class="col-md-8">

                <h1 class="page-header">
                    Formulario
                    <small>Arancelario</small>
                </h1>
                <!-- Blog Search Well -->
                <div class="well">
                    <h4>Buscar</h4>
                    <div class="input-group">
                        <input type="text" class="form-control">
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="button">
                                <span class="glyphicon glyphicon-search"></span>
                        </button>
                        </span>
                    </div>
                    <!-- /.input-group -->
                </div>
                <span ng-if="ctrl.flag=='deleted'" class="msg-success">Formulario  Borrado.</span>
                <!-- First Blog Post -->
                <table class="table table-hover table-inverse">
                    <thead>
                      <tr>
                        <th>#</th>
                        <th>Usuario</th>
                        <th>Cod Arancelario</th>
                        <th>Opciones</th>
                      </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="row in ctrl.formularioarancelarios">
                        <td><span ng-bind="row.fid"></span></td>
                        <td><span ng-bind="row.usuario"></span></td>
                        <td><span ng-bind="row.codarancelarioFormarancelario"></span></td>
                        <td>
                        <input type="button" ng-click="ctrl.deleteformularioarancelario(row.pid)" value="Borrar"/>
                        <input type="button" ng-click="ctrl.editFormularioarancelario(row.pid)" value="Editar"/>
                        <span ng-if="ctrl.flag=='updated' && row.pid==ctrl.updatedId" class="msg-success">Formulario Actualizado.</span> 
                        </td> 
                    </tr>	
                    </tbody>
                  </table>
                
                <hr>

                <!-- Pager -->
                <ul class="pager">
                    <li class="previous">
                        <a href="#">&larr; Anterior</a>
                    </li>
                    <li class="next">
                        <a href="#">Siguiente &rarr;</a>
                    </li>
                </ul>

            </div>

            <!-- Blog Sidebar Widgets Column -->
            <div class="col-md-4">
                <!-- Blog Categories Well -->
                
                <div class="well">
                    <div ng-if="ctrl.flag != 'edit'">
                        <h4> Agregado Nuevo Formulario </h4> 
                    </div>
                    <div ng-if="ctrl.flag == 'edit'">
                        <h4> Actualizado Formulario Con  ID: {{ ctrl.formularioarancelario.fid }} </h4> 
                    </div> 
                    <div class="row">
                        <div class="col-lg-6">
                            <!-- /.col-lg-6 -->
                            <form name="FormArancelario" method="POST">     
                            <div class="form-group">
                                <label for="idFormarancelario">Id Form:</label>
                                <input type="text" name="idFormarancelario" required class="form-control" placeholder="ID Formulario" id="idFormarancelario" ng-model="ctrl.formularioarancelario.idFormarancelario" >
                                <span ng-show="FormArancelario.idFormarancelario.$error.required" class="msg-val">Id Formulario Arancelario Requerido.</span>
                            </div>
                            <div class="form-group">
                                <label>Usuario:</label>
                                <select name="usuario" class="form-control" id="usuario" ng-model="ctrl.formularioarancelario.usuario">

                                       <option value="1">1</option>
                                       <option value="2">2</option>

                                </select>
                                <span ng-show="FormArancelario.usuario.$error.required" class="msg-val">usuario Requerido.</span>
                            </div> 
                            
                            <div class="form-group">
                                <label>Cod Arancelario:</label>
                                <input  type="text" name="codarancelarioFormarancelario" id="codarancelarioFormarancelario" required class="form-control"  ng-model="ctrl.formularioarancelario.CodarancelarioFormarancelario"  value="" placeholder="Cod Arancelario" >
                                <span ng-show="FormArancelario.codarancelarioFormarancelario.$error.required" class="msg-val">Codigo Arancelario Requerido.</span>
                            </div>
                                <span ng-if="ctrl.flag=='created'" class="msg-success">Formulario Arancelario Agregado.</span>
                                 <span ng-if="ctrl.flag=='failed'" class="msg-val">Formulario Arancelario Ya Existe.</span> </td>
                            <div class="form-group">
                                <div ng-if="ctrl.flag != 'edit'">
                                   <input  type="submit" ng-click="ctrl.addFormularioarancelario()" value="Agregar"/> 
                                   <input type="button" ng-click="ctrl.reset()" value="Reset"/>
                                </div>
                                <div ng-if="ctrl.flag == 'edit'">
                                   <input  type="submit" ng-click="ctrl.updateFormularioarancelarioDetail()" value="Actualizar Formulario Arancelario"/> 	
                                   <input type="button" ng-click="ctrl.cancelUpdate()" value="Cancel"/>				   
                                </div> 
                                 </div>
                            </form>
                            </div>
                        </div>
                        <!-- /.col-lg-6 -->
                    </div>
                    <!-- /.row -->
                </div>

            </div>

        </div>
        <!-- /.row -->
        
        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Universidad de El Salvador 2016</p>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </footer>

    
</div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

    <script src="${pageContext.request.contextPath}/resources/js/angular.min.js" type="text/javascript"></script>
    
    <script src="${pageContext.request.contextPath}/resources/js/angular-resource.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/app_resource.js"></script>
    

</body>

</html>
