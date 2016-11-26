<%-- 
    Document   : formularioArancelario
    Created on : 11-21-2016, 05:09:52 PM
    Author     : jonathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                        <a href="http://localhost:8080/SpringMVC0_5/index">Inicio</a>
                    </li>
                    <li>
                        <a href="http://localhost:8080/SpringMVC0_5">Formularios Exportacion</a>
                    </li>
                    <li>
                        <a href="http://localhost:8080/SpringMVC0_5/formularioArancelario">Formularios Arancelarios</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="container">

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
                      <tr>
                        <th scope="row">1</th>
                        <td>122</td>
                        <td>Otto</td>
                        <td><a ng-click="editArancel(arancelform)" class="blue-button">Edit</a> | <a ng-click="deleteArancel(arancelform)" class="red-button">Borrado</a></td>

                      </tr>
                      <tr>
                        <th scope="row">2</th>
                        <td>Jacob</td>
                        <td>Thornton</td>
                        <td>@fat</td>
                      </tr>
                      <tr>
                        <th scope="row">3</th>
                        <td>Jacob</td>
                        <td>Thornton</td>
                        <td>@fat</td>
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
                    <h4>Ingresar ${mensaje}</h4>
                    <div class="row">
                        <div class="col-lg-6">
                            <!-- /.col-lg-6 -->
                            <div class="generic-container" ng-controller="arancelario as ctrl">
                            <form ng-submit="ctrl.submit()" name="FormArancelario">  
                            <div class="form-group">
                                <label for="idformarancelario">Id Form:</label>
                                <input type="text" name="idformarancelario" required class="form-control" placeholder="ID Formulario" id="idformarancelario" ng-model="exportacion.datos.id_formexpor">
                            </div>
                            <div class="form-group">
                                <label>Usuario:</label>
                                <select name="idusuario" class="form-control" id="idusuario">

                                       <option value="">prueba</option>

                                </select>       
                            </div> 
                            
                            <div class="form-group">
                                <label>Cod Arancelario:</label>
                                <input  type="text" name="codarancelario" id="codarancelario" required class="form-control"  ng-model="arancelario.datos.codigo_formexpor" value="" placeholder="Cod Arancelario" >
                            </div>
                            <div class="form-group">
                                <button class="btn btn-primary" type="submit" id="guardar"><i class="fa fa-floppy-o"></i> Guardar</button>
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

    <!--
    <script src="${pageContext.request.contextPath}/resources/js/angular.min.js" type="text/javascript"></script>
    -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/controller/arancelario_controller.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/service/formAranc_service.js" type="text/javascript"></script>
    

</body>

</html>
