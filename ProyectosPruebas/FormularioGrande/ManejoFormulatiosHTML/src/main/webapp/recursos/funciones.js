/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validarForma(forma){
    var usuario = forma.usuario;
    if(usuario.value === "" || usuario.value === "Escribe el usuario"){
        alert("Debe proporcionar un nombre de usuario");
        usuario.focus();
        usuario.select();
        return false;
    }
    
    var password = forma.password;
    if(usuario.value === "" || password.value.length < 3){
        alert("Debe proporcionar una contraseña de almenos 3 caracteres");
        usuario.focus();
        usuario.select();
        return false;
    }
    
    var tecnologia = forma.tecnologia;
    var checkSeleccionado = false;
    for (var i = 0; i < tecnologia.length; i++){
        if (tecnologia[i].checked){
            checkSeleccionado =  true;
        }
    }
    
    if(!checkSeleccionado){
        alert("Debe seleecionar una tecnología");
        return false;
    }
    
    var genero = forma.genero;
    var radioSeleccionado =  false;
    
    for (var i = 0; i < genero.length; i++){
        if (genero[i].checked){
            radioSeleccionado =  true;
        }
    }
    
    if(!radioSeleccionado){
        alert("Debe seleecionar un género");
        return false;
    }
    
    var ocupacion = forma.ocupacion;
    if(ocupacion.value === ""){
        alert("Debe seleccionar una ocupación");
        return false;
    }
    
    //El formulario es valido
    alert("Enviando datos al servidor");
    
    return true;
}