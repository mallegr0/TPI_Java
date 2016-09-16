package capa_datos;

public class Personaje {
	
	private String nombre_personaje;
	private int id_personaje, vida, energia, defensa, evasion, ptos_totales;
	
	
	public Personaje(String nombre_personaje, int id_personaje, int vida, int energia, int defensa, int evasion, int ptos_totales) {
		this.nombre_personaje = nombre_personaje;
		this.id_personaje = id_personaje;
		this.vida = vida;
		this.energia = energia;
		this.defensa = defensa;
		this.evasion = evasion;
		this.ptos_totales = ptos_totales;
	}


	public String getNombre_personaje() {
		return nombre_personaje;
	}


	public void setNombre_personaje(String nombre_personaje) {
		this.nombre_personaje = nombre_personaje;
	}


	public int getId_personaje() {
		return id_personaje;
	}


	public void setId_personaje(int id_personaje) {
		this.id_personaje = id_personaje;
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


	public int getPtos_totales() {
		return ptos_totales;
	}


	public void setPtos_totales(int ptos_totales) {
		this.ptos_totales = ptos_totales;
	}
	

}
