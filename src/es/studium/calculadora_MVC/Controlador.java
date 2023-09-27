package es.studium.calculadora_MVC;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controlador implements WindowListener, ActionListener
{
	Modelo modelo;
	Vista vista;
	
	int operador1 = 0;
	int operador2 = 0;
	
	String operacion;
	
	boolean nuevoNumeroEnPantalla;

	public Controlador(Modelo m, Vista v)
	{
		modelo = m;
		vista = v;
		
		v.boton0.addActionListener(this);
		v.boton1.addActionListener(this);
		v.boton2.addActionListener(this);
		v.boton10.addActionListener(this);
		v.boton3.addActionListener(this);
		v.boton4.addActionListener(this);
		v.boton5.addActionListener(this);
		v.boton11.addActionListener(this);
		v.boton6.addActionListener(this);
		v.boton7.addActionListener(this);
		v.boton8.addActionListener(this);
		v.boton12.addActionListener(this);
		v.boton9.addActionListener(this);
		v.boton15.addActionListener(this);
		v.boton14.addActionListener(this);
		v.boton13.addActionListener(this);
		v.ventana.addWindowListener(this);
	}
	
	
	@Override
	public void windowClosing(WindowEvent arg0)
	{
		System.exit(0);
	}
	@Override
	public void windowActivated(WindowEvent arg0) {}
	@Override
	public void windowClosed(WindowEvent arg0) {}
	@Override
	public void windowDeactivated(WindowEvent arg0) {}
	@Override
	public void windowDeiconified(WindowEvent arg0) {}
	@Override
	public void windowIconified(WindowEvent arg0) {}
	@Override
	public void windowOpened(WindowEvent arg0) {}
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//Para obtener el número o signo del botón pulsado.
		String botonPulsado = ((Button) e.getSource()).getLabel();
		
		if (botonPulsado.equals("C"))
		{
			vista.pantalla.setText("0");
	
			operador1 = 0;
			operador2 = 0;
			nuevoNumeroEnPantalla = true;
		}
		
		else if (botonPulsado.equals("="))
		{
			operador2 = Integer.parseInt(vista.pantalla.getText());
			
			if (operacion != null)
			{
				if (operacion.equals("+"))
				{
					vista.pantalla.setText(modelo.suma(operador1, operador2));
				}
				
				else if (operacion.equals("-"))
				{
					vista.pantalla.setText(modelo.resta(operador1, operador2));
				}
				
				else if (operacion.equals("*"))
				{
					vista.pantalla.setText(modelo.multiplicacion(operador1, operador2));
				}
				
				else if (operacion.equals("/"))
				{
					vista.pantalla.setText(modelo.division(operador1, operador2));
				}
			}
			
			nuevoNumeroEnPantalla = true;
			operacion = null;
		}
		
		else if (botonPulsado.equals("+") || botonPulsado.equals("-") || botonPulsado.equals("*")
				|| botonPulsado.equals("/"))
		{
			operacion = botonPulsado; //Según el operador pulsado se asigna a la variable "operación".
			//Se guarda el número que se ha introducido antes de pulsar el dicho operador.
			operador1 = Integer.parseInt(vista.pantalla.getText()); 
			nuevoNumeroEnPantalla = true;
		}
		
		else //Sino se ha pulsado ningún operador, comprueba si hay un número en la pantalla.
		{
			//Si hay un número en la pantalla quiere decir que ha pulsado un operador.
			if (nuevoNumeroEnPantalla == true) 
			{
				//Mostrar en pantalla el número que el usuario acaba de pulsar.
				vista.pantalla.setText(botonPulsado); 
				nuevoNumeroEnPantalla = false;
			}
			
			else
			{
				vista.pantalla.setText(vista.pantalla.getText() + botonPulsado);
				
				if ((vista.pantalla.getText().length()>1)&&(vista.pantalla.getText().charAt(0)=='0'))
				{
					vista.pantalla.setText(vista.pantalla.getText().substring(1));
				}
			}
		}
	}
}


