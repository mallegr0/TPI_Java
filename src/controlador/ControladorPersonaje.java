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
	
	public void consultaPersonaje(Personaje p){
		c.consultaPersonaje(p);
	}

	public boolean valida_datos(Personaje p){
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
