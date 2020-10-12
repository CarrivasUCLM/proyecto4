$(document).ready(function(){
    $('#new').click(function(){
        agregarFila();
    });
   
});

function EliminarFila(fila) {
        $(fila).parents("tr").remove();

}

function agregarFila() {
    $("#tabla")
    .append
    (
    	"<tr>" +
             "<td>" + "nº" + "</td>" + //GUARDAR ID DE LA TAREA EN EL MONGO
             "<td>" + "<input type='text' class= 'form-control' id='nombre'>" + "</td>" +
             "<td>" + "<div class='form-check'> <input class='form-check-input position-static' type='checkbox' value='option1' aria-label='...'></div>" + "</td>" +
             "<td class='text-center'>" +
                 "<div class='btn btn-primary' onclick='addTarea(document.getElementById('nombre')'>Save</div>" +
                 "<div class='btn btn-danger' onclick='EliminarFila(this)'>Delete</div>" +
             "</td>" +
         "</tr>"
    )
}


function addTarea(){
	
	
}

function loadTasks(){
	
}

