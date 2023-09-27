package es.studium.calculadora_MVC;

public class Modelo
{
	public String suma(int operador1, int operador2)
	{
		return ((operador1 + operador2) + "");
	}
	

	public String resta(int operador1, int operador2)
	{
		return ((operador1 - operador2) + "");
	}
	
	
	public String multiplicacion(int operador1, int operador2)
	{
		return ((operador1 * operador2) + "");
	}
	
	
	public String division(int operador1, int operador2)
	{
		return ((operador1 / operador2) + "");
	}
}


