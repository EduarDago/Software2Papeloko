

$(document).ready(function () {
   
    $(".Buscar").hide();
    $("#ActualizarProveedor").hide();
    $("#EliminarProveedor").hide();

    $("#Agregar").click(function () {

        $(".Buscar").hide();
        $("#ActualizarProveedor").hide();
        $("#EliminarProveedor").hide();
        $("#RegistrarProveedor").show();
        Editarcampos("","","","","","");
    });

    $("#Modificar").click(function () {
        $(".Buscar").show();
        $("#ActualizarProveedor").show();
        $("#EliminarProveedor").hide();
        $("#RegistrarProveedor").hide();
        
        Editarcampos("","","","","","");
    });

    $("#Eliminar").click(function () {
        $(".Buscar").show();
        $("#ActualizarProveedor").hide();
        $("#EliminarProveedor").show();
        $("#RegistrarProveedor").hide();
        
        Editarcampos("","","","","","");
    });

    $("#RegistrarProveedor").click(function () {
        AgregarProveedor();
    });

    $("#ActualizarProveedor").click(function () {
        ModificarProveedor();
    });
    
    $("#EliminarProveedor").click(function () {
        EliminarCategoria();
    });

    $("#EnviarBusqueda").click(function(){
        ConsultarProveedor();
    });


});

function AgregarProveedor() {
    var nit = $("#nit").val();
    var nombre = $("#nombre").val();
    var telefono = $("#telefono").val();
    var direccion = $("#direccion").val();

if ( nit != "" && nombre != "" && telefono != "" && direccion != "") {
        
        $.post("../../PeticionesJsProveedores", {Operacion: "Agregar", nit: nit, nombre: nombre, telefono: telefono, direccion: direccion}, function (data) {
            if( data !== "null"){
                alert(data);
            }
            else
                alert("No se pudo Registrar provvedor");
        });
    } else {
        alert("Existen Campos Vacios");
    }
}

function ModificarProveedor() {

    var nit = $("#nit").val();
    var nombre = $("#nombre").val();
    var telefono = $("#telefono").val();
    var direccion = $("#direccion").val();
    var nitB = $("#Buscar1").val();


    if (nit != "" && nombre != "" && telefono != "" && direccion) {
        
        $.post("../../PeticionesJsProveedores", {Operacion: "Actualizar", nit: nit, nombre: nombre, telefono: telefono, direccion: direccion}, function (data) {
            if( data !== "null"){
                var vec = jQuery.parseJSON(data);
                Editarcampos(vec.nit, vec.nombre, vec.telefono, vec.direccion, nitB);
                alert("Se Actualizo con Exito");
            }
            else
                alert("No se pudo Actualizar Proveedor");
        });
    } else {
        alert("Existen Campos Vacios");
    }
    
}

function EliminarProveedor(){
    var id = $("#nit").val();

    if (id !== "") {
        $.post("../../PeticionesJsProveedores", {Operacion: "Eliminar", nit: id}, function (data) {
            if( data !== "null"){
                alert(data);
                Editarcampos("","","","","");
            }
            else
                alert("No se puede Eliminar Proveedor");
        });
    } else {
        alert("Existen Campos Vacios");
    }
}

function ConsultarProveedor(){
    var nit = $("#Buscar1").val();

    if (nit != "") {
        
        $.post("../../PeticionesJsProveedores", { Operacion: "Consultar", nit: nit }, function (data) {
             if( data !== "null"){
                var vec = jQuery.parseJSON(data);
                Editarcampos(vec.nit, vec.nombre, vec.telefono,vec.direccion, nit);
            }
            else
                alert("No se encontro en BD ");
        });
    } else {
        alert("Existen Campos Vacios");
    }
}

function Editarcampos(id, nom, tel, dir, buscar){
    $("#nit").val(id);
    $("#nombre").val(nom); 
    $("#telefono").val(tel); 
    $("#direccion").val(dir);
    $("#Buscar1").val(buscar);
}


