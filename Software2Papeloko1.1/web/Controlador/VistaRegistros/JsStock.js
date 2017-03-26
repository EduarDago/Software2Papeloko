/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function() {
    $(".Buscar").hide();
    $("#ActualizarStock").hide();
    $("#EliminarStock").hide();
	
    $("#Agregar").click(function(){
        $(".Buscar").hide();
        $("#RegistrarStock").show();
        $("#ActualizarStock").hide();
        $("#EliminarStock").hide();
        Editarcampos("", "", "", "", "", "");
    });

    $("#Modificar").click(function(){
        $(".Buscar").show();
        $("#RegistrarStock").hide();
        $("#ActualizarStock").show();
        $("#EliminarStock").hide();
        Editarcampos("", "", "", "", "", "");
    });

    $("#Eliminar").click(function(){
        $(".Buscar").show();
        $("#RegistrarStock").hide();
        $("#ActualizarStock").hide();
        $("#EliminarStock").show();
        Editarcampos("", "", "", "", "", "");
    });

    $("#RegistrarStock").click(function(){
        AgregarStock();

    });

    $("#ActualizarStock").click(function () {
        ActualizarStock();
    });
    
    $("#EliminarStock").click(function () {
        EliminarStock();
    });

    $("#EnviarBusqueda").click(function(){
        ConsultarStock()
    });
	
	
});

function AgregarStock(){
	var Id = $("#Id").val();
	var Nom = $("#Nombre").val();
	var Estado = $("#Estado").val();
	
	
	if( Id != "" && Nom != "" && Estado != ""){
		
            $.post("../../PeticionesJsStock", {Operacion: "Agregar", Id:Id,Nombre:Nom,Estado:Estado}, function (data) {
                if(data !== "null")
                alert(data);
                else
                    alert("Error No se Pudo Agregar !");
            });
	}
	else
		alert("Existen Campos Vacios")
}

function ActualizarStock(){
	var Id = $("#Buscar1").val();
	var Nom = $("#Nombre").val();
	var Estado = $("#Estado").val();
        
	if( Id !== "" && Nom !== "" && Estado !== ""){
            //Es una funcion asincrona 
            $.post("../../PeticionesJsStock", {Operacion: "Actualizar", Id:Id,Nombre:Nom,Estado:Estado}, function (data) {
               if( data !== "null"){
                var vec = jQuery.parseJSON(data);
                Editarcampos(vec.id, vec.nombre, vec.estado,"");
                alert("Se Actualizo con Exito");
            }
            else
                alert("No se Puede Actualizar Usuario");
            });
	}
	else
            alert("Existen Campos Vacios");
        
}

function EliminarStock(){
    
	var Nom = $("#Nombre").val();
	var Estado = $("#Estado").val();
	var Ced = $("#Buscar1").val();
            //Es una funcion asincrona 
        $.post("../../PeticionesJsStock", {Operacion: "Eliminar", Id:Ced,Nombre:Nom,Estado:Estado}, function (data) {   
           if( data !== "null" ){
                alert(data);
                Editarcampos("", "", "", "");
            }
            else
                alert("Error! No se puede eliminar");
        });
	
}

function ConsultarStock(){
    var id = $("#Buscar1").val();

    if (id != "") {
        
        $.post("../../PeticionesJsStock", { Operacion: "Consultar", Id: id }, function (data) {
             if( data !== "null"){
                var vec = jQuery.parseJSON(data);
                Editarcampos(vec.id, vec.nombre, vec.estado, id);
            }
            else
                alert("No se encontro en BD ");
        });
    } else {
        alert("Existen Campos Vacios");
    }
}


function Editarcampos(id, nom, estado, buscar){
    $("#Id").val(id);
    $("#Nombre").val(nom); 
    $("#Estado").val(estado); 
    $("#Buscar1").val(buscar);
}
