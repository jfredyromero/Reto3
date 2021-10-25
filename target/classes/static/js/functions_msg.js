const API_MSG = "http://localhost:8080/api/Message/save";

// Agrega un mensaje
function agregarMensaje(msg, client, cabin) {
	
	if (!validaCampo(msg)) {
		alert("El cuerpo del mensaje no puede estar vacio.");
		return;
	}

	var msg =     
	{
	messageText: msg.val(),
    "client":{ "idClient": parseInt(client.val()) },
    "cabin": {"id":parseInt(cabin.val())}
	}
	
	$.ajax({
		url: API_MSG,
		data: JSON.stringify(msg),
		type: "POST",
		dataType: "json",
		contentType: "application/json",

		error: function (xhr, status) {
			limpiar();
			alert("Código de error de la petición: " + xhr.status);
		},
		complete: function (xhr, status) {
			alert("Código de estado de la petición: " + xhr.status);
			alert("Se ha guardado el mensaje exitosamente")
		},
		success: function (json) {

			limpiar();
		},
	});
}

// Limpa los input
function limpiar() {
	$("#msg").val("");
	$("#client_msg").val("");
	$("#cabin_msg").val("");
}

// Valida que un campo no se haya dejado vacio
function validaCampo(campo) {
	return campo.val().trim() != "";
}
