package controlador;

import data.DataPersonaje;
import entidades.Personaje;

public class ControladorPersonaje {
	
	public static final int maxEvasion = 80;
	DataPersonaje c = new DataPersonaje();
	
	public void altaPersonaje(Personaje p){
		c.altaPersonaje(p);
	}
	
	public void modificaPersonaje(Personaje p){
		c.modificaPersonaje(p);
	}
	
	public void eliminaPersonaje(Personaje p){
		c.eliminaPersonaje(p);
	}
	
	public Personaje consultaPersonaje(Personaje p){
		
		Personaje per = new Personaje();
		per = c.consultaPersonaje(p);		
		return per;
	}

	public boolean validaDatos(Personaje p){
		boolean rta = true;
		
		if(p.getDefensa() >= maxEvasion){
			rta = false;
		}
		else if(p.getEnergia() >= maxEvasion){
			rta = false;
		}
		else if(p.getEvasion() >= maxEvasion){
			rta = false;
		}
		else if(p.getVida() >= maxEvasion){
			rta = false;
		}
		return rta;
	}
}
