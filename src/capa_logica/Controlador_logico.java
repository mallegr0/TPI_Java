package capa_logica;

import capa_datos.Personaje;
import capa_datos.Controlador;

public class Controlador_logico {

	Controlador c = new Controlador();
	
	public boolean alta_datos(Personaje p){
	
		return c.alta_datos(p);
	}
	public boolean modifica_datos(Personaje p){
		
		return c.modifica_datos(p);
	}
	public boolean baja_datos(Personaje p){
		
		return c.baja_datos(p);
	}
	public void consulta_datos(Personaje p){
	
		c.consulta_datos(p);
}

	
	public void turno(){
		//maneja el turno
	}
	
	
}
