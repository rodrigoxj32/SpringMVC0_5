<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de exportacion</title>
    </head>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" />
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/angular.min.js" type="text/javascript"></script>
    
    <script src="${pageContext.request.contextPath}/resources/js/controller/exportacion_controller.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/service/formExpor_service.js" type="text/javascript"></script>
    
    
    
    
    
    
    <body ng-app="formularioExp" >

        <div class="generic-container" ng-controller="exportacion" class="form-group" style="width: 300px;text-align: center;margin: 0 auto;">
            <h1>Formulario de exportacion</h1>

            <form ng-submit="obtener()" name="FormExportacion">  
                <input type="hidden" ng-model="exportacion.datos.id_formexpor" />

                <p>Origen: <input type="text" ng-model="idioma"  class="form-control"></p> 

                <p>Instancias: <input type="text" ng-model="suma" class="form-control"></p> 

                <p>Observaciones: <input type="text" ng-model="exportacion.datos.codigo_formexpor" class="form-control"></p> 

                <p>Fecha: <input type="date" ng-model="algo" class="form-control"></p>
                
                <input type="submit" value="Guardar" class="btn btn-primary " >
                
                <br>
                <br>
                <br>
                
                <a href="http://localhost:8080/proyecto2/index">Regresar</a>
            </form>
        </div>



    </body>
</html>


