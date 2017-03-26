/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function() {
    
        $(".Buscar").hide();
	$("#ActualizarUsuario").hide();
        $("#EliminarUsuario").hide();
        
	$("#AgregarUsuario").click(function(){
            $(".Buscar").hide();
            $("#Registrar").show();
            $("#ActualizarUsuario").hide();
            $("#EliminarUsuario").hide();
            Editarcampos("", "", "", "", "", "");
	});
	
	$("#ModificarUsuario").click(function(){
            $(".Buscar").show();
            $("#Registrar").hide();
            $("#ActualizarUsuario").show();
            $("#EliminarUsuario").hide();
            Editarcampos("", "", "", "", "", "");
	});
	
	$("#EliminarUser").click(function(){
            $(".Buscar").show();
            $("#Registrar").hide();
            $("#ActualizarUsuario").hide();
            $("#EliminarUsuario").show();
            Editarcampos("", "", "", "", "", "");
	});
	
	$("#Registrar").click(function(){
            Agregar();
            
	});
        
        //Buscar Usuarios en la BD
        $("#EnviarBusqueda").click(function(){
            var Ced = $("#Buscar1").val();
            
            $.post("../../PeticionesJsUsuarios", {Operacion: "Consultar", Id:Ced}, function (data) {
               
                if(data !== "null"){
                    var vec = jQuery.parseJSON(data);
                    Editarcampos(vec.id, vec.nombre, vec.apellido, vec.rol, vec.credenciales, Ced);
                }
                else
                    alert("No se encuentra en BD");
            });
        });
        
        $("#ActualizarUsuario").click(function(){
          Actailizar();
        });
        
        $("#EliminarUsuario").click(function(){
            Eliminar();            
        });
	
});

function Agregar(){
	var Ced = $("#Cc").val();
	var Nom = $("#Nombre").val();
	var Apell = $("#Apellido").val();
	var Rol = $("#Rol").val();
	var Cred = $("#Credenciales").val();
        
	if( Ced !== "" && Nom !== "" && Apell !== "" && Rol !== "" && Cred !== ""){
		console.log(Ced+" "+Nom+" "+Apell+" "+Rol+" "+Cred);
            //Es una funcion asincrona 
            $.post("../../PeticionesJsUsuarios", {Operacion: "Agregar", Id:Ced,Nombre:Nom,Apellido:Apell,Rol:Rol,Credencial:Cred}, function (data) {
               if(data !== "null")
                alert(data);
                else
                    alert("Error No se Pudo Agregar !");
                });
	}
	else
            alert("Existen Campos Vacios");
        
}

function Actailizar(){
	var Ced = $("#Buscar1").val();
	var Nom = $("#Nombre").val();
	var Apell = $("#Apellido").val();
	var Rol = $("#Rol").val();
	var Cred = $("#Credenciales").val();
        
	if( Ced !== "" && Nom !== "" && Apell !== "" && Rol !== "" && Cred !== ""){
		console.log(Ced+" "+Nom+" "+Apell+" "+Rol+" "+Cred);
            //Es una funcion asincrona 
            $.post("../../PeticionesJsUsuarios", {Operacion: "Actualizar", Id:Ced,Nombre:Nom,Apellido:Apell,Rol:Rol,Credencial:Cred}, function (data) {
               if( data !== "null"){
                var vec = jQuery.parseJSON(data);
                Editarcampos(vec.id, vec.nombre, vec.apellido, vec.rol, vec.credenciales,"");
                alert("Se Actualizo con Exito");
            }
            else
                alert("No se Puede Actualizar Usuario");
            });
	}
	else
            alert("Existen Campos Vacios");
        
}

function Eliminar(){
    
	var Nom = $("#Nombre").val();
	var Apell = $("#Apellido").val();
	var Rol = $("#Rol").val();
	var Cred = $("#Credenciales").val();
	var Ced = $("#Buscar1").val();
            //Es una funcion asincrona 
        $.post("../../PeticionesJsUsuarios", {Operacion: "Eliminar", Id:Ced,Nombre:Nom,Apellido:Apell,Rol:Rol,Credencial:Cred}, function (data) {   
           if( data !== "null" ){
                alert(data);
                Editarcampos("", "", "", "", "", "");
            }
            else
                alert("Error! No se puede eliminar");
        });
	
}

function Editarcampos(cc, nom, ape, rol, cred, buscar){
    $("#Cc").val(cc);
    $("#Nombre").val(nom); 
    $("#Apellido").val(ape); 
    $("#Rol").val(rol); 
    $("#Credenciales").val(cred); 
    $("#Buscar1").val(buscar);
}