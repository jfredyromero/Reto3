const API_RESERVATION = "http://localhost:8080/api/Reservation/save";

// Agrega una reserva
function agregarReserva(devolutionDate,	idClient,idCabin) {
	if (!validaCampo(devolutionDate)) {
		alert("Debe seleccionar la fecha de entrega.");
		return;
	}
	
	if(!validarFecha(devolutionDate.val())){
		alert("La fecha no es válida")
		return;
	}
	
	var reservation = 
	{
		"startDate" : new Date(),
		"devolutionDate": devolutionDate.val(),
		"client": { "idClient": idClient.val() },
		"cabin": { "id": idCabin.val() }
	}

	$.ajax({
		url: API_RESERVATION,
		data: JSON.stringify(reservation),
		type: "POST",
		dataType: "json",
		contentType: "application/json",

		error: function (xhr, status) {
			limpiar();
			alert("Código de error de la petición: " + xhr.status);
		},
		complete: function (xhr, status) {
			alert("Código de estado de la petición: " + xhr.status);
			alert("Se ha guardado la reserva exitosamente")
		},
		success: function (json) {

			limpiar();
		},
	});
}

// Limpa los input
function limpiar() {
	$("#id_cabin").val("");
	$("#brand_cabin").val("");
	$("#rooms_cabin").val("");
	$("#description").val("");
	$("#name_cabin").val("");
}

// Valida que un campo no se haya dejado vacio
function validaCampo(campo) {
	return campo.val().trim() != "";
}

// Valida que la fecha de devolucion no sea mayor a la actual
function validarFecha(fecha){
	var hoy = new Date()
	var fechaValidar = new Date(fecha)
	return fechaValidar >= hoy
}
