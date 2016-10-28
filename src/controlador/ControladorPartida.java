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
					notificarUsuario("El ataque fue evadido.");
				} else {
					notificarUsuario("El ataque NO fue evadido.");
				}
				if(personajePasivo.getVidaActual() < 1){
					return true;
				}
			} else {
				notificarUsuario("El ataque no pudo llevarse a cabo por falta de energía.");
				//ACÁ HABRÍA QUE VER PORQUE SE DEVUELVE FALSE Y EN LA INTERFAZ ESO SIGNIFICA
				//QUE HAY QUE CAMBIAR DE TURNO, LO QUE NO ES CORRECTO PARA LA LOGICA DEL JUEGO.
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public void defender(int defensa, Personaje defensor){
		int energiaARecuperar, vidaARecuperar, vida, energia = 0;
		energiaARecuperar = defensor.getEnergiaActual() + (defensor.getEnergia()*defensa)/100;
		vidaARecuperar = defensor.getVidaActual() + (defensor.getVida()*defensa)/250;
		
		//Evita que la energia y la vida se pasen de los valores originales
		if(energiaARecuperar > defensor.getEnergia() && vidaARecuperar > defensor.getVida())
		{
			vida = defensor.getVida();
			energia = defensor.getEnergia();
			JOptionPane.showMessageDialog(null, vida);
			JOptionPane.showMessageDialog(null, energia);
		}
		else if(energiaARecuperar > defensor.getEnergia())
		{
			vida = vidaARecuperar;
			energia = defensor.getEnergia();
			JOptionPane.showMessageDialog(null, vida);
			JOptionPane.showMessageDialog(null, energia);
		}
		else if(vidaARecuperar > defensor.getVida())
		{
			vida = defensor.getVida();
			energia = energiaARecuperar;
			JOptionPane.showMessageDialog(null, vida);
			JOptionPane.showMessageDialog(null, energia);
		}
		else
		{
			vida = vidaARecuperar;
			energia = energiaARecuperar;
			JOptionPane.showMessageDialog(null, vida);
			JOptionPane.showMessageDialog(null, energia);
		}
		
		defensor.setEnergiaActual(energia);
		defensor.setVidaActual(vida);
		
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
	
	public void ganador(Personaje jugador){
		int ptos;
		ptos = jugador.getPtosTotales();
		ptos += 10;
		jugador.setPtosTotales(ptos);
		data.modificaPersonaje(jugador);
	}
	
	//METODO PARA NOTIFICAR ALGUN ERROR AL USUARIO
		private void notificarUsuario(String mensaje) {
			JOptionPane.showMessageDialog(null, mensaje);
		}
	
}
