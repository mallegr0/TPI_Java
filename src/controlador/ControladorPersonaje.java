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
		
		Personaje per = new Personaje();
		per = data.consultaPersonaje(p);		
		return per;
	}

	public boolean atacar(Personaje p1, int energia) throws Exception{
		int aux = p1.getEnergia() - energia;
		if(aux >= 0){
			p1.setEnergia(aux);
			data.modificaPersonaje(p1);
			return true;
		}else{
			return false;
		}
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
