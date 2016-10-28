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

	public boolean atacar(Personaje p, int energia) throws Exception{
		int aux = p.getEnergiaActual() - energia;
		if(aux >= 0){
			p.setEnergiaActual(aux);
			return true;
		}else{
			return false;
		}
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
