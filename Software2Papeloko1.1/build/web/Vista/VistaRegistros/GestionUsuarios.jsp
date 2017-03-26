<%-- 
    Document   : index
    Created on : 13-mar-2017, 14:04:08
    Author     : EDUARD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <title>Software II</title>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link href="../RecursosVisuales/RecursosFramework/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href="../RecursosVisuales/RecursosFramework/estylehtml.css" rel="stylesheet" type="text/css"  media="all" />
        <!--link href="../RecursosVisuales/RecursosFramework/boostrap3/css/bootstrap.min.css" rel="stylesheet" type="text/css" /-->
        
        <script src="../../Includes/jquery-2.1.0.min.js" type="text/javascript"></script>
        <script src="../../Controlador/VistaRegistros/JsUsuarios.js" type="text/javascript" language="javascript1.5"></script>


    </head>
    <body>
    <div class="container">
            <header>
                <h1> <span>InnovationCreative</span>
                    Registrar nuevo ususario 
                </h1>
            </header><!--Fin header-->      
            
            <div class="form2">
                <button class="boton" id="AgregarUsuario"> Registrar </button>
                <button class="boton" id="ModificarUsuario"> Modificar </button>
                <button class="boton" id="EliminarUser"> Eliminar </button>
            </div>
            <br>
            <div id="VistaAgregar"  class="form">
                <div class="Buscar">
                    <p class="contact"><label for="name">Buscar</label></p> 
                    <input id="Buscar1" placeholder="Buscar por Id" required tabindex="1" type="text">
                    <button class="buttom" id="EnviarBusqueda"> Buscar </button>
                </div>
                <p class="contact"><label for="name">C.C</label></p> 
                <input id="Cc" required tabindex="1" type="text">

                <p class="contact"><label for="name">Nombre</label></p> 
                <input id="Nombre" required tabindex="1" type="text"> 

                <p class="contact"><label for="name">Apellido</label></p> 
                <input id="Apellido"  required tabindex="1" type="text">

                <p class="contact"><label for="name">Rol</label></p> 
                <input id="Rol"  required tabindex="1" type="text">

                 <p class="contact"><label for="name">Credenciales</label></p> 
                <input id="Credenciales" required tabindex="1" type="text">

                <button class="buttom" id="Registrar"> Registrar </button>
                <button class="buttom" id="ActualizarUsuario"> Actualizar </button>
                <button class="buttom" id="EliminarUsuario">Eliminar</button> 
                
            </div>    
            <!--div id="VistaActualizar"  class="form">
                <div>
                    <!--p class="contact"><label for="name">Buscar</label></p> 
                    <input id="Buscar" placeholder="Buscar por Id" required tabindex="1" type="text">
                    <input class="buttom" id="RegistrarUsuario" tabindex="5" value="Buscar" type="submit"->
                </div>

                <p class="contact"><label for="name">C.C</label></p> 
                <input id="Cc" required tabindex="1" type="text">

                <p class="contact"><label for="name">Nombre</label></p> 
                <input id="Nombre" required tabindex="1" type="text"> 

                <p class="contact"><label for="name">Apellido</label></p> 
                <input id="Apellido"  required tabindex="1" type="text">

                <p class="contact"><label for="name">Rol</label></p> 
                <input id="Rol"  required tabindex="1" type="text">

                 <p class="contact"><label for="name">Credenciales</label></p> 
                <input id="Credenciales" required tabindex="1" type="text">

                <input class="buttom" id="ActualizarUsuario" tabindex="5" value="Actualizar" type="submit">	 
                </div> 

            <div id="VistaEliminar"  class="form">
                <div>
                    <p class="contact"><label for="name">Buscar</label></p> 
                    <input id="Buscar" placeholder="Buscar por Id" required tabindex="1" type="text">
                    <input class="buttom" id="EnviarBusqueda" tabindex="5" value="Buscar" type="submit">
                </div>


                <p class="contact"><label for="name">C.C</label></p> 
                <input id="Cc" required tabindex="1" type="text">

                <p class="contact"><label for="name">Nombre</label></p> 
                <input id="Nombre" required tabindex="1" type="text"> 

                <p class="contact"><label for="name">Apellido</label></p> 
                <input id="Apellido"  required tabindex="1" type="text">

                <p class="contact"><label for="name">Rol</label></p> 
                <input id="Rol"  required tabindex="1" type="text">

                 <p class="contact"><label for="name">Credenciales</label></p> 
                <input id="Credenciales" required tabindex="1" type="text">

                <input class="buttom" id="EliminarUsuario" tabindex="5" value="Eliminar" type="submit"> 	 
            </div--> 
        </div>
    </body>
</html>
