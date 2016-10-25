package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import data.DataPersonaje;
import entidades.Personaje;

public class ControladorPartida {
	
	DataPersonaje data = new DataPersonaje();
	ControladorPersonaje controladorPersonaje = new ControladorPersonaje();
	Personaje personajeActivo, personajePasivo;
	ArrayList<Personaje> turnos = new ArrayList<Personaje>();
	int turno = 0;
	
	public boolean atacar(int energia, Personaje personajeActivo, Personaje personajePasivo){
		
		try {
			if(controladorPersonaje.atacar(personajeActivo, energia)){
				if(controladorPersonaje.calcularEvasion(personajePasivo,energia)){
					JOptionPane.showMessageDialog(null,"El ataque fue evadido.", "El ataque fue evadido.", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,"El ataque NO fue evadido.", "El ataque NO fue evadido.", JOptionPane.INFORMATION_MESSAGE);
				}
				if(personajePasivo.getVidaActual() < 1){
					return true;
				}
				
			} else {
				JOptionPane.showMessageDialog(null,"El ataque NO pudo llevarse a cabo.", "Energía insuficiente.", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public Personaje cambiarTurno(){
		Personaje aux = new Personaje();
		//Al turno lo uso para cambiar entre personaje 1 y 2
		turno++;
		
		if((turno - 1) % 2 == 0){
				aux = turnos.get(0);
			}
			else{
				aux = turnos.get(1);
			}
		return aux;
	}
	
	public void setearTurno(Personaje personajeActivo, Personaje personajePasivo){
		turnos.add(0, personajeActivo);
		turnos.add(1, personajePasivo);
		
	}
	public Personaje buscaPersonaje(Personaje p){
		return data.buscaPersonaje(p);
	}
	
}
