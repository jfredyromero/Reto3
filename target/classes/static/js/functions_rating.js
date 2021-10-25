const API_CAL = "http://localhost:8080/api/Score/save";

// Agrega un mensaje
function agregarCalificacion(rate, msg, reservation) {
	
	if (!validaCampo(msg)) {
		alert("El cuerpo del mensaje no puede estar vacio.");
		return;
	}
        
        if (!validaCampo(rate)) {
		alert("La calificación no puede estar vacia.");
		return;
	}

	var rating =     
	{
            "rate": rate.val(),
            "message": msg.val(),
            "reservation":{ "idReservation": reservation.val() }
	};
	
	$.ajax({
		url: API_CAL,
		data: JSON.stringify(rating),
		type: "POST",
		dataType: "json",
		contentType: "application/json",

		error: function (xhr, status) {
			limpiar();
			alert("Código de error de la petición: " + xhr.status);
		},
		complete: function (xhr, status) {
			alert("Código de estado de la petición: " + xhr.status);
			alert("Se ha guardado la calificacion exitosamente");
		},
		success: function (json) {
			limpiar();
		},
	});
}

// Limpa los input
function limpiar() {
	$("#msg").val("");
	$("#rate").val("");
	$("#reservation").val("");
}

// Valida que un campo no se haya dejado vacio
function validaCampo(campo) {
	return campo.val().trim() != "";
}
