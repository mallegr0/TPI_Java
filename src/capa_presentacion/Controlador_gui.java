package capa_presentacion;

import capa_logica.Controlador_logico;
import capa_datos.Personaje;

public class Controlador_gui {
	
	public void turno(){
		//maneja el turno
	}
	
	Controlador_logico c = new Controlador_logico();
	
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
