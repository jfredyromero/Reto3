const API_ADMIN =
	"http://localhost:8080/api/Admin/save";

// Agrega un administrador
function agregarAdmin(name, email, pass) {
	if (!validaCampo(name)) {
		alert("Debe ingresar su nombre");
		return;
	}
	if (!validaCampo(email)) {
		alert("Debe ingresar el email");
		return;
	} if (!validaCampo(pass)) {
		alert("Debe ingresar la contraseña");
		return;
	}

	var admin = {
	
	    "name" : name.val(),
	    "email" : email.val(),
	    "password" : pass.val()
	}
	

	$.ajax({
		url: API_ADMIN,
		data: JSON.stringify(admin),
		type: "POST",
		dataType: "json",
		contentType: "application/json",

		error: function(xhr, status) {
			limpiar();
			alert("Código de error de la petición: " + xhr.status);
		},
		complete: function(xhr, status) {
			alert("Código de estado de la petición: " + xhr.status);
			alert("Se ha registrado el Administrador en el sistema")
		},
		success: function(json) {

			limpiar();
		},
	});
}

// Limpa los input
function limpiar() {
	$("#name_admin").val("");
	$("#email_admin").val("");
	$("#passwd_admin").val("");
}

// Valida que un campo no se haya dejado vacio
function validaCampo(campo) {
	return campo.val().trim() != "";
}
