package capa_logica;

import capa_datos.Personaje;
import capa_datos.Controlador;

public class Controlador_logico {
	
	public static final int max = 80;
	
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
