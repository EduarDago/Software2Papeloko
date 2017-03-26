
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
        <script src="../../Controlador/VistaRegistros/JsCategorias.js" type="text/javascript" language="javascript1.5"></script>


    </head>
    <body >
        <div class="container">


            <header>
                <h1> <span>InnovationCreative</span>
                    Registrar nueva categoria 
                </h1>
            </header><!--Fin header--> 

            <div class="form2">
                <button class="boton" id="Agregar"> Registrar </button>
                <button class="boton" id="Actualizar"> Modificar </button>
                <button class="boton" id="Eliminar"> Eliminar </button>
            </div>
            <br>
            <div class="form">
                <div class="Buscar">
                    <p class="contact"><label for="name">Buscar</label></p> 
                    <input id="Buscar1" placeholder="Buscar por Id" required tabindex="1" type="text">
                    <button class="buttom" id="EnviarBusqueda"> Buscar </button>
                </div>
                <p class="contact"> Id </p> 
                <input id="Id" required tabindex="1" type="text">

                <p class="contact"> Nombre </p> 
                <input id="Nombre" required tabindex="1" type="text"> 

                <p class="contact"> Descripcion </p> 
                <input id="Descripcion"  required tabindex="1" type="text">

                <button class="buttom" id="RegistrarCategoria"> Registrar </button>
                <button class="buttom" id="ActualizarCategoria"> Actualizar </button>
                <button class="buttom" id="EliminarCategoria">Eliminar</button>
            </div> 

            <!--div id="VistaActualizar"  class="form">
                <div>
                    <p class="contact"><label for="name">Buscar</label></p> 
                    <input id="Buscar" placeholder="Buscar por Id" required tabindex="1" type="text">
                    <input class="buttom" id="RegistrarCategoria" tabindex="5" value="Buscar" type="submit">
                </div>

                <p class="contact"><label for="name">Id</label></p> 
                <input id="Id" required tabindex="1" type="text">

                <p class="contact"><label for="name">Nombre</label></p> 
                <input id="Nombre" required tabindex="1" type="text"> 

                <p class="contact"><label for="name">Descripcion</label></p> 
                <input id="Descripcion"  required tabindex="1" type="text">

                <input class="buttom" id="ActualizarUsuario" tabindex="5" value="Actualizar" type="submit">	 
            </div> 

            <div id="VistaEliminar"  class="form">
                <div>
                    <p class="contact"><label for="name">Buscar</label></p> 
                    <input id="Buscar" placeholder="Buscar por Id" required tabindex="1" type="text">
                    <input class="buttom" id="Registrar" tabindex="5" value="Buscar" type="submit">
                </div>

                <p class="contact"><label for="name">Id</label></p> 
                <input id="Id" required tabindex="1" type="text">

                <p class="contact"><label for="name">Nombre</label></p> 
                <input id="Nombre" required tabindex="1" type="text"> 

                <p class="contact"><label for="name">Descripcion</label></p> 
                <input id="Descripcion"  required tabindex="1" type="text">

                <input class="buttom" id="EliminarUsuario" tabindex="5" value="Eliminar" type="submit"> 	 
            </div--> 
        </div>
    </body>
</html>
