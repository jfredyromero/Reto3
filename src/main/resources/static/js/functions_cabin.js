const API_CABIN =
	"http://localhost:8080/api/Cabin/save";

// Agrega una cabaña
function agregarCabana(brand, rooms, name, description, cat) {
	if (!validaCampo(rooms)) {
		alert("Debe ingresar el número de habitaciones");
		return;
	}
	if (cat.val()===null) {
		alert("Debe ingresar la categoria");
		return;
	} 
        if (!validaCampo(name)) {
		alert("Debe ingresar el nombre");
		return;
	}
	if (!validaCampo(description)) {
		alert("Debe ingresar la descripción de la cabaña");
		return;
	}
	var cabin = {
		"brand": brand.val(),
		"rooms": parseInt(rooms.val()),
		"category": { "id": parseInt(cat.val()) },
		"name": name.val(),
		"description": description.val()
	}

	$.ajax({
		url: API_CABIN,
		data: JSON.stringify(cabin),
		type: "POST",
		dataType: "json",
		contentType: "application/json",

		error: function(xhr, status) {
			limpiar();
			alert("Código de error de la petición: " + xhr.status);
		},
		complete: function(xhr, status) {
			alert("Código de estado de la petición: " + xhr.status);
		},
		success: function(json) {

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
