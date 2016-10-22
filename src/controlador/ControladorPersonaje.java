package controlador;

import javax.swing.JOptionPane;

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
		JOptionPane.showMessageDialog(null, energia);
		int aux = p1.getEnergiaActual() - energia;
		JOptionPane.showMessageDialog(null, p1.getEnergiaActual());
		JOptionPane.showMessageDialog(null, aux);
		if(aux >= 0){
			p1.setEnergiaActual(aux);
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
