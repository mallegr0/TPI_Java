package controlador;

import data.DataPersonaje;
import entidades.Personaje;

public class ControladorPersonaje {
	
	DataPersonaje data = new DataPersonaje();
	
	public void altaPersonaje(Personaje p){
		data.altaPersonaje(p);
	}
	
	public void modificaPersonaje(Personaje p){
		data.modificaPersonaje(p);
	}
	
	public void eliminaPersonaje(Personaje p){
		data.eliminaPersonaje(p);
	}
	
	public Personaje consultaPersonaje(Personaje p){
		return data.consultaPersonaje(p);
	}

	public void atacar(Personaje p, int energia) throws Exception{
		p.setEnergiaActual(p.getEnergiaActual() - energia);
	}
	
	public boolean calcularEvasion(Personaje p, int energia){
		if( (Math.random()*100) < p.getEvasion()){
			return true;
		} else {
			p.setVidaActual(p.getVidaActual()- energia);
			return false;
		}
	}
	
}
