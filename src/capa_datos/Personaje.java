package capa_datos;

public class Personaje {
	
	private String nombre_personaje;
	private String id_personaje, vida, energia, defensa, evasion, ptos_totales;
	
	
	public Personaje(String nombre_personaje, String id_personaje, String vida, String energia, String defensa, String evasion, String ptos_totales) {
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


	public String getId_personaje() {
		return id_personaje;
	}


	public void setId_personaje(String id_personaje) {
		this.id_personaje = id_personaje;
	}


	public String getVida() {
		return vida;
	}


	public void setVida(String vida) {
		this.vida = vida;
	}


	public String getEnergia() {
		return energia;
	}


	public void setEnergia(String energia) {
		this.energia = energia;
	}


	public String getDefensa() {
		return defensa;
	}


	public void setDefensa(String defensa) {
		this.defensa = defensa;
	}


	public String getEvasion() {
		return evasion;
	}


	public void setEvasion(String evasion) {
		this.evasion = evasion;
	}


	public String getPtos_totales() {
		return ptos_totales;
	}


	public void setPtos_totales(String ptos_totales) {
		this.ptos_totales = ptos_totales;
	}
	
	
	
	
	

}
