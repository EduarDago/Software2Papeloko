/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    
    $(".Buscar").hide();
    $("#ActualizarCategoria").hide();
    $("#EliminarCategoria").hide();

    $("#Agregar").click(function () {

        $(".Buscar").hide();
        $("#ActualizarCategoria").hide();
        $("#EliminarCategoria").hide();
        $("#RegistrarCategoria").show();
        Editarcampos("","","","","","");
    });

    $("#Actualizar").click(function () {
        $(".Buscar").show();
        $("#ActualizarCategoria").show();
        $("#EliminarCategoria").hide();
        $("#RegistrarCategoria").hide();
        
        Editarcampos("","","","","","");
    });

    $("#Eliminar").click(function () {
        $(".Buscar").show();
        $("#ActualizarCategoria").hide();
        $("#EliminarCategoria").show();
        $("#RegistrarCategoria").hide();
        
        Editarcampos("","","","","","");
    });

    $("#RegistrarCategoria").click(function () {
        AgregarCategoria();
    });

    $("#ActualizarCategoria").click(function () {
        ActulizarCategoria()
    });
    
    $("#EliminarCategoria").click(function () {
        EliminarCategoria();
    });

    $("#EnviarBusqueda").click(function(){
        ConsultarCategoria();
    });

});

function AgregarCategoria() {
    var id = $("#Id").val();
    var nombre = $("#Nombre").val();
    var descripcion = $("#Descripcion").val();

    if (id != "" && nombre != "" && descripcion != "") {
        console.log(id + " " + nombre + " " + descripcion);
        $.post("../../PeticionesJsCategorias", {Operacion: "Agregar", Id: id, Nombre: nombre, Descripcion: descripcion}, function (data) {
            if( data !== "null")
                alert(data);
            else
                alert("No se pudo Agregar Categoria");
        });
    } else {
        alert("Existen Campos Vacios");
    }
}

function ActulizarCategoria() {
    var id = $("#Id").val();
    var idB = $("#Buscar1").val();
    var nombre = $("#Nombre").val();
    var descripcion = $("#Descripcion").val();

    if (id != "" && nombre != "" && descripcion != "") {
        console.log(id + " " + nombre + " " + descripcion);
        $.post("../../PeticionesJsCategorias", {Operacion: "Actualizar", Id: id, Nombre: nombre, Descripcion: descripcion}, function (data) {
            if( data !== "null"){
                var vec = jQuery.parseJSON(data);
                Editarcampos(vec.id, vec.nombre, vec.descripcion, idB);
                alert("Se Actualizo con Exito");
            }
            else
                alert("No se pudo Actualizar Categoria");
        });
    } else {
        alert("Existen Campos Vacios");
    }
}

function EliminarCategoria(){
    var id = $("#Id").val();

    if (id !== "") {
        $.post("../../PeticionesJsCategorias", {Operacion: "Eliminar", Id: id}, function (data) {
            if( data !== "null"){
                alert(data);
                console.log(data);
                Editarcampos("","","","")
            }
            else
                alert("No se puede Eliminar Categoria");
        });
    } else {
        alert("Existen Campos Vacios");
    }
}

function ConsultarCategoria(){
    var id = $("#Buscar1").val();

    if (id != "") {
        
        $.post("../../PeticionesJsCategorias", { Operacion: "Consultar", Id: id }, function (data) {
             if( data !== "null"){
                var vec = jQuery.parseJSON(data);
                Editarcampos(vec.id, vec.nombre, vec.descripcion, id);
            }
            else
                alert("No se encontro en BD ");
        });
    } else {
        alert("Existen Campos Vacios");
    }
}

function Editarcampos(id, nom, des, buscar){
    $("#Id").val(id);
    $("#Nombre").val(nom); 
    $("#Descripcion").val(des); 
    $("#Buscar1").val(buscar);
}