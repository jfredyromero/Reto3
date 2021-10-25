const API_CLIENT = "http://localhost:8080/api/Client/save";
   
// Agrega un cliente
function agregarCliente(name, email, passwd, age) {
	if (!validaCampo(name)) {
		alert("Debe ingresar el nombre del cliente");
		return;
	}
	if (!validaCampo(email)) {
		alert("Debe ingresar el correo");
		return;
	} if (!validaCampo(passwd)) {
		alert("Debe ingresar la contraseña");
		return;
	}
	if (!validaCampo(age)) {
		alert("Debe ingresar la edad del cliente");
		return;
	}

	var client = {
        "name":name.val(),
        "email":email.val(),
        "password":passwd.val(),
        "age": parseInt(age.val())
	}

	$.ajax({
		url: API_CLIENT,
		data: JSON.stringify(client),
		type: "POST",
		dataType: "json",
		contentType: "application/json",

		error: function(xhr, status) {
			limpiar();
			alert("Código de error de la petición: " + xhr.status);
		},
		complete: function(xhr, status) {
			alert("Código de estado de la petición: " + xhr.status);
			alert("Se ha agregar el cliente exitosamente")
		},
		success: function(json) {

			limpiar();
		},
	});
}

// Limpa los input
function limpiar() {
	$("#client_name").val("");
	$("#client_email").val("");
	$("#client_passwd").val("");
	$("#client_age").val("");
}

// Valida que un campo no se haya dejado vacio
function validaCampo(campo) {
	return campo.val().trim() != "";
}
