const API_CATEGORY =
	"http://localhost:8080/api/Category/save";

// Agrega una categoria
function agregarCategoria(name, description) {

	if (!validaCampo(name)) {
		alert("Debe ingresar el nombre");
		return;
	}

	if (!validaCampo(description)) {
		alert("Debe ingresar la descripción de la categoria");
	return;
	}
	var category =
	{
		"name": name.val(),
		"description": description.val()
	}

	$.ajax({
		url: API_CATEGORY,
		data: JSON.stringify(category),
		type: "POST",
		dataType: "json",
		contentType: "application/json",

		error: function(xhr, status) {
			limpiar();
			alert("Código de error de la petición: " + xhr.status);
		},
		complete: function(xhr, status) {
			alert("Código de estado de la petición: " + xhr.status);
			alert("Se ha guardado la categoria exitosamente")
		},
		success: function(json) {

			limpiar();
		},
	});
}

// Limpa los input
function limpiar() {
	$("#name_cat").val("");
	$("#cat_description").val("");
}

// Valida que un campo no se haya dejado vacio
function validaCampo(campo) {
	return campo.val().trim() != "";
}
