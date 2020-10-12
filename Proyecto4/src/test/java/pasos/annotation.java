package pasos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.agibilibus.listaToDo.dao.TareaDAO;
import com.agibilibus.listaToDo.model.Tarea;



public class annotation {
	
	private TareaDAO tareaDAO=null;
	Tarea tareaTest = new Tarea();
	Boolean error = false;
	
	@Given("^Una nueva tarea$")
	public void Una_tarea_con_su_id() {
		
		tareaTest = new Tarea ("Prueba cucumber",true);
	}
	
	@Then("^se inserta$")
	public void se_loguea() throws Throwable {
		try {
		tareaDAO.insert(tareaTest);
		}catch(Exception e) {
			error = true;
		}
	}

	@When("^no ha habido fallos$")
	public void id_correcto() {
		assertNotNull(tareaTest.getId());
		assertFalse(error);
		
	}
	


	
}
