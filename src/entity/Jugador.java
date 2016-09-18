package entity;

public class Jugador {

	private String usr;
	private Personaje[] personajes = new Personaje[1]; 	//Tengo dudas de como hacer el tema del array.. y si debe de ir un array o no
	
	public Jugador(String usr, Personaje pers) {
		
		this.usr = usr;
		this.personajes[1] = pers;
		
	} // Ver si el constructor esta bien hecho

	public String getUsr() {
		return usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}	
	
	
}
