package com.agibilibus.listaToDo;



import com.agibilibus.listaToDo.dao.TareaDAO;
import com.agibilibus.listaToDo.model.Tarea;
import junit.framework.TestCase;

public class pruebas extends TestCase {
	

	private static int inicio = 0;
	private static int repeticiones = 10;
	private static int prueba;

	public pruebas(String sTestName)
	{
		super(sTestName);
	}

	public void setUp() throws Exception
	{
	}

	public void tearDown() throws Exception
	{
	}

	private void test() throws InterruptedException
	{
		Tarea nuevo = new Tarea();
		
		System.out.println("inicio del test: crear admin, p"+prueba+" ["+inicio+","+(inicio+repeticiones)+"]");
		Thread.sleep(7000);
		System.out.println("...");
		
		try
		{
			for(int i=inicio; i< inicio+repeticiones ;i++) {
				nuevo = new Tarea("tarea"+i,true);
				assertNotNull(new TareaDAO().insert(nuevo) );
				}
		}
		catch (Exception e)
		{		
			fail(e.getMessage()+"- User: "+nuevo.getNombre());
		}
		System.out.println("fin del test: crear admin, p"+prueba+" ["+inicio+","+(inicio+repeticiones)+"]");
	}
	
	public void testNuevoAdmin() throws InterruptedException
	{
		for(prueba = 1; prueba<21 ;prueba++) {
			test();
			inicio += repeticiones;
		}
	}

}
