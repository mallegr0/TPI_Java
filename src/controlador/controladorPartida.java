package controlador;

import javax.swing.JOptionPane;

import data.DataPersonaje;
import entidades.Personaje;

public class controladorPartida {
	
	DataPersonaje data = new DataPersonaje();
	ControladorPersonaje controladorPersonaje = new ControladorPersonaje();
	Personaje personajeActivo = new Personaje();
	Personaje personajePasivo = new Personaje();
	
	public void atacar(int energia){
		
		try {
			if(controladorPersonaje.atacar(personajeActivo, energia)){
				if(controladorPersonaje.calcularEvasion(personajePasivo,energia)){
					JOptionPane.showMessageDialog(null,"El ataque fue evadido.", "El ataque fue evadido.", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,"El ataque NO fue evadido.", "El ataque NO fue evadido.", JOptionPane.INFORMATION_MESSAGE);
				}
				
				cambiarTurno(personajeActivo, personajePasivo);
			} else {
				JOptionPane.showMessageDialog(null,"El ataque NO pudo llevarse a cabo.", "Energía insuficiente.", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cambiarTurno(Personaje p1, Personaje p2){
		Personaje aux = new Personaje();
		aux = p1;
		p1 = p2;
		p2 = aux;
	}

}
