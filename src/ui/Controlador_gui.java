package ui;

import controlador.ControladorPersonaje;
import entity.Personaje;

public class Controlador_gui {
	
	public void turno(){
		//maneja el turno
	}
	
	ControladorPersonaje c = new ControladorPersonaje();
	
	public boolean alta_datos(Personaje p){
		return c.alta_datos(p);
	}
	
	public boolean baja_datos(Personaje p){
		return c.baja_datos(p);
	}
	
	public boolean modifica_datos(Personaje p){
		return c.modifica_datos(p);
	}
	
	public void consulta_datos(Personaje p){
		c.consulta_datos(p);
	}
	
	public boolean validar(Personaje p){
		return c.valida_datos(p);
	}

}

