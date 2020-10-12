$(document).ready(function() {
	$('#new').click(function() {
		agregarFila();
	});

});

/*function EliminarFila(fila) {
	$(fila).parents("tr").remove();

}*/

function agregarFila() {
	$("#tabla")
			.append(
					"<tr>"
							+ "<td>"
							+ "nº"
							+ "</td>"
							+ // GUARDAR ID DE LA TAREA EN EL MONGO
							"<td>"
							+ "<input type='text' class= 'form-control' id='tareaName'>"
							+ "</td>"
							+ "<td>"
							+ "<div class='form-check'> <input class='form-check-input position-static' type='checkbox' value='option1' aria-label='...' id='checkDone'></div>"
							+ "</td>"
							+ "<td class='text-center'>"
							+ "<div class='btn btn-primary' onclick='addTarea(document.getElementById('nombre')'>Save</div>"
							+ "<div class='btn btn-danger' onclick='deleteTarea(document.getElementById('nombre')'>Delete</div>"
							+ "</td>" + "</tr>")
}

function addTarea() {
	var info = {
		type : "AddTarea",
		tarea : tareaName.value,
		done : checkDone.value
	};
	var data = {
		data : JSON.stringify(info),
		url : "addtarea",
		type : "post",
		contentType : 'application/json',
		dataType : 'json',
		success : function() {
			alert("OK");
		},
		error : function(response) {
			alert(response.responseText);
		}
	};
	$.ajax(data);
}

function deleteTarea() {
	var info = {
		type : "DeleteTarea",
		tarea : tareaName.value,
		done : checkDone.value
	};
	var data = {
		data : JSON.stringify(info),
		url : "deletetarea",
		type : "post",
		contentType : 'application/json',
		dataType : 'json',
		success : function() {
			alert("OK");
		},
		error : function(response) {
			alert(response.responseText);
		}
	};
	$.ajax(data);
}

function loadTasks() {
	var data = {

			url : "loadTareas",
			type : "get",
			
			success : function(response) {
				var options ="<table>";
				for (var i=0; i<response.length; i++) {
					options = options + "<tr><td>" + response[i].nombre + "</td></tr>";
				}
				options = option + "</table>";
				selectAll.innerHTML = options;
			},
			error : function(response) {
				alert(response.message);
			}
		};
		$.ajax(data);
}
