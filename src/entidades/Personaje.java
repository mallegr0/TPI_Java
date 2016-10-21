package entidades;

import controlador.ControladorPersonaje;

public class Personaje {
	
	static int puntajeInicial = 200;
	static int maximoDeEvasion = 80;
	private String nombre;
	private int id, vida, energia, defensa, evasion, ptosTotales;
	private ControladorPersonaje ctrlPersonaje = new ControladorPersonaje(); 
	
	public Personaje(){
	}
	
	public Personaje(String nombre, int id, int vida, int energia, int defensa, int evasion, int ptosTotales){
		this.nombre = nombre;
		this.id = id;
		this.vida = vida;
		this.energia = energia;
		this.defensa = defensa;
		this.evasion = evasion;
		this.ptosTotales = puntajeInicial;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getId() {
		return id;
	}


	public void setId(int id_personaje) {
		this.id = id_personaje;
	}


	public int getVida() {
		return vida;
	}


	public void setVida(int vida) {
		this.vida = vida;
	}


	public int getEnergia() {
		return energia;
	}


	public void setEnergia(int energia) {
		this.energia = energia;
	}


	public int getDefensa() {
		return defensa;
	}


	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}


	public int getEvasion() {
		return evasion;
	}


	public void setEvasion(int evasion) {
		this.evasion = evasion;
	}


	public int getPtosTotales() {
		return ptosTotales;
	}


	public void setPtosTotales(int ptosTotales) {
		this.ptosTotales = ptosTotales;
	}

	//CONTROLA LOS PUNTAJES QUE PUEDE TENER ASIGNADO EL PERSONAJE PARA CADA CARACTERISTICA
	public boolean validaPuntaje(){
		boolean respuesta;
		
		if(((defensa + vida + energia + evasion) <= ptosTotales) && (evasion <= maximoDeEvasion)){
			 respuesta=true;
		}else{
			respuesta=false;
		}
		return respuesta;
	}
	
	//ACCION DE ATACAR DEL PERSONAJE
	public boolean atacar(Personaje p1, int energia) throws Exception{
		int aux = p1.getEnergia() - energia;
		if(aux >= 0){
			p1.setEnergia(aux);
			ctrlPersonaje.modificaPersonaje(p1);
			return true;
		}else{
			return false;
		}
	}
	
}
