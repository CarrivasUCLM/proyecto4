$(document).ready(function() {
	loadTasks();
	$('#new').click(function() {
		agregarFila();
	});

});

function EliminarFila(fila) {
	$(fila).parents("tr").remove();

}

function agregarFila() {
	$("#tabla")
			.append(
					"<tr>"
							+ "<td>"
							+ "<input type='text' class= 'form-control' id='tareaName'>"
							+ "</td>"
							+ "<td>"
							+ "<div class='form-check'> <input class='form-check-input position-static' type='checkbox' value='option1' aria-label='...' id='checkDone'></div>"
							+ "</td>"
							+ "<td class='text-center'>"
							+ "<div class='btn btn-primary' onclick='addTarea(this)'>Save</div>"
							+ "<div class='btn btn-danger' onclick='EliminarFila(this)'>Delete</div>"
							+ "</td>" + "</tr>")
}

function addTarea(fila) {
	
	
	var info = {
		type : "AddTarea",
		tarea : $(fila).parents("tr")[0].firstChild.children.tareaName.value,
		done : checkDone.value
	};
	var data = {
		data : JSON.stringify(info),
		url : "addTarea",
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
			type : "post",
			
			success : function(response) {
				var options ="";
				for (var i=0; i<response.length; i++) {
					options = options + "<tr><td>" + response[i].nombre + "</td></tr>";
				}
				document.getElementById('cuerpo').innerHTML = options;
			},
			error : function(response) {
				alert(response.message);
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
