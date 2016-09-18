package data;

import entity.Personaje;

public class Controlador {
	
	public boolean alta_datos(Personaje p){
		//Sentencia SQL para dar de alta al personaje
		//Devuelve true di se guardo OK
		boolean rta = true;
		return rta;
	}
	public boolean modifica_datos(Personaje p){
		// sentencia SQL para actualizar los datos del personaje.
		// devuelve true si se guardo OK
		boolean rta = true;
		return rta;
	}
	public boolean baja_datos(Personaje p){
		// sentencia SQL para eliminar los datos del personaje.
		// devuelve true si se elimino OK
		boolean rta = true;
		return rta;
	}
	public void consulta_datos(Personaje p){
		//consulta de datos, hay que ver que se hace
	}

}