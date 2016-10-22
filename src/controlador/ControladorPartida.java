package controlador;

import javax.swing.JOptionPane;

import data.DataPersonaje;
import entidades.Personaje;

public class ControladorPartida {
	
	DataPersonaje data = new DataPersonaje();
	ControladorPersonaje controladorPersonaje = new ControladorPersonaje();
	Personaje personajeActivo, personajePasivo;
	
	
	public void atacar(int energia, Personaje personajeActivo, Personaje personajePasivo){
		
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
	
	public String cambiarTurno(Personaje personajeActivo, Personaje personajePasivo){
		Personaje aux = new Personaje();
		aux = personajeActivo;
		personajeActivo = personajePasivo;
		personajePasivo = aux;
		return personajeActivo.getNombre();
	}
	
	public Personaje buscaPersonaje(Personaje p){
		return data.buscaPersonaje(p);
	}
	
}
