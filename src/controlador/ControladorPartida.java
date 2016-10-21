package controlador;

import data.DataPersonaje;
import entidades.Personaje;

public class ControladorPartida {
	
	Personaje pers1 = new Personaje();
	Personaje pers2 = new Personaje();
	DataPersonaje data = new DataPersonaje();
	
	public ControladorPartida(){
	}


	public boolean calcularEvasion(Personaje p, int energia){
		if( (Math.random()*100) < p.getEvasion()){
			return true;
		} else {
			p.setVida(p.getVida()- energia);
			data.modificaPersonaje(p);
			return false;
		}
	}


}
