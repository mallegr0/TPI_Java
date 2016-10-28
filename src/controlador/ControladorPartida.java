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
		//ACA SE ME OCURRE QUE PODRIAMOS RETORNAR UN INT EN LUGAR DE UN BOOLEAN PARA HACER UN SWITCH EN
		//LA PARTIDA EN QUE SI DEVUELVE 1 SIGUE LA PARTIDA, 2 NO ATACÓ, 3 TERMINO PORQUE ALGUNO SE QUEDO
		//SIN VIDA Y 4 SI TERMINÓ PORQUE AMBOS SE QUEDARON SIN ENERGIA PARA USAR.
		try {
				controladorPersonaje.atacar(personajeActivo, energia);
				if(energia == 0){
					notificarUsuario("Sin puntos para atacar, cambia de turno sin efecto alguno");
				}
				else{
				if(controladorPersonaje.calcularEvasion(personajePasivo,energia)){
					notificarUsuario("El ataque fue evadido.");
				} else {
					notificarUsuario("El ataque NO fue evadido.");
				}
				}
				if((personajePasivo.getVidaActual() < 1) || (personajeActivo.getEnergiaActual() == 0 && personajePasivo.getEnergiaActual() == 0)){
					return true;
				}
		} catch (Exception e) {
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
		}
		else if(energiaARecuperar > defensor.getEnergia())
		{
			vida = vidaARecuperar;
			energia = defensor.getEnergia();
		}
		else if(vidaARecuperar > defensor.getVida())
		{
			vida = defensor.getVida();
			energia = energiaARecuperar;
		}
		else
		{
			vida = vidaARecuperar;
			energia = energiaARecuperar;
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
