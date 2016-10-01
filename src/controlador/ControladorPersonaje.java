package controlador;

import data.DataPersonaje;
import entidades.Personaje;

public class ControladorPersonaje {
	
	public static final int max = 80;
	
	DataPersonaje c = new DataPersonaje();
	
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

	public boolean valida_datos(Personaje p){
		boolean rta = true;
		
		if(p.getDefensa() >= max){
			rta = false;
		}
		else if(p.getEnergia() >= max){
			rta = false;
		}
		else if(p.getEvasion() >= max){
			rta = false;
		}
		else if(p.getVida() >= max){
			rta = false;
		}
		return rta;
	}
}
