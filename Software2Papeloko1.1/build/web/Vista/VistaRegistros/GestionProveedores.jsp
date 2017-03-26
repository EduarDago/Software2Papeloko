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
        

        <script src="../../Includes/jquery-2.1.0.min.js" type="text/javascript"></script>
        <script src="../../Controlador/VistaRegistros/JsProveedores.js" type="text/javascript" language="javascript1.5"></script>


    </head>
    <body class="container">
        <div class="container">


            <header>
                <h1> <span>InnovationCreative</span>
                   Proveedores 
                </h1>
            </header> 


            <div class="form2">
                <button class="boton" id="Agregar"> Registrar </button>
                <button class="boton" id="Modificar"> Modificar </button>
                <button class="boton" id="Eliminar"> Eliminar </button>
            </div>
            <br>
            <div class="form">
                
                <div class="Buscar">
                    <p class="contact"><label for="name">Buscar</label></p> 
                    <input id="Buscar1" placeholder="Buscar por Id" required tabindex="1" type="text">
                    <button class="buttom" id="EnviarBusqueda"> Buscar </button>
                </div>
                
                <p class="contact">Nit</p> 
                <input id="nit" required tabindex="1" type="text">

                <p class="contact">Nombre</p> 
                <input id="nombre" required tabindex="1" type="text"> 

                <p class="contact">Telefono</p> 
                <input id="telefono"  required tabindex="1" type="text">


                <p class="contact">Direccion</p> 
                <input id="direccion" required tabindex="1" type="text">

                <button class="buttom" id="RegistrarProveedor"> Registrar </button>
                <button class="buttom" id="ActualizarProveedor"> Actualizar </button>
                <button class="buttom" id="EliminarProveedor">Eliminar</button>
            </div>    
            <!--div id="VistaActualizar"  class="form">
                <div>
                    <p class="contact"><label for="name">Buscar Proveedor</label></p> 
                    <input id="txtBuscar" placeholder="Buscar por Nit" required tabindex="1" type="text">

                    <input class="buttom" id="btnRegistrarProovedor" tabindex="5" value="Buscar" type="submit">
                </div>

                <p class="contact"><label for="name">Nit</label></p> 
                <input id="nit" required tabindex="1" type="text">

                <p class="contact"><label for="name">Nombre</label></p> 
                <input id="nombre" required tabindex="1" type="text"> 

                <p class="contact"><label for="name">Telefono</label></p> 
                <input id="telefono"  required tabindex="1" type="text">


                <p class="contact"><label for="name">Direccion</label></p> 
                <input id="direccion" required tabindex="1" type="text">

                <input class="buttom" id="btnActualizarProoverdor" tabindex="5" value="Actualizar" type="submit">	 
            </div> 

            <div id="VistaEliminar"  class="form">
                <div>
                    <p class="contact"><label for="name">Buscar</label></p> 
                    <input id="Buscar" placeholder="Buscar por Nit" required tabindex="1" type="text">
                    <input class="buttom" id="btnRegistrarProovedorProveedor" tabindex="5" value="Buscar" type="submit">
                </div>
                
                <p class="contact"><label for="name">Nit</label></p> 
                <input id="nit" required tabindex="1" type="text">

                <p class="contact"><label for="name">Nombre</label></p> 
                <input id="nombre" required tabindex="1" type="text"> 

                <p class="contact"><label for="name">Telefono</label></p> 
                <input id="telefono"  required tabindex="1" type="text">


                <p class="contact"><label for="name">Direccion</label></p> 
                <input id="direccion" required tabindex="1" type="text">

                <input class="buttom" id="btnEliminarProovedor" tabindex="5" value="Eliminar" type="submit"> 	 
            </div--> 
        </div>
    </body>
</html>
