package interfaz;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.*;

import controlador.ControladorPartida;
import entidades.Personaje;


public class Partida extends JDialog {
	private ControladorPartida partida = new ControladorPartida();
	private JTextField txtTurno;
	private JTextField txtPuntosAUsar;
	private JLabel etiqDatoVidaPers1;
	private JLabel etiqDatoEnergiaPers1;
	private JLabel etiqDatoVidaPers2;
	private JLabel etiqDatoEnergiaPers2;
	public Personaje personaje1;
	public Personaje personaje2;
	public Personaje aux, aux2, atacante, defensor;
	private JTextField txtPersonaje1;
	private JTextField txtPersonaje2;
	private JButton btnPers1;
	private JButton btnPers2;
	private JButton btnIniciar;
	private JButton btnAtacar;
	private JButton botonDefender;
	private JLabel etiqEnJuego;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Partida dialog = new Partida();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Partida() {
				
		setTitle("Partida");
		setModal(true);
		setBounds(100, 100, 487, 385);
		getContentPane().setLayout(null);
		
		JLabel etiqVidaPers1 = new JLabel("Vida");
		etiqVidaPers1.setBounds(90, 106, 46, 14);
		getContentPane().add(etiqVidaPers1);
		
		etiqDatoVidaPers1 = new JLabel("-");
		etiqDatoVidaPers1.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiqDatoVidaPers1.setBounds(146, 106, 56, 14);
		getContentPane().add(etiqDatoVidaPers1);
		
		JLabel etiqEnergiaPers1 = new JLabel("Energia");
		etiqEnergiaPers1.setBounds(90, 136, 46, 14);
		getContentPane().add(etiqEnergiaPers1);
		
		etiqDatoEnergiaPers1 = new JLabel("-");
		etiqDatoEnergiaPers1.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiqDatoEnergiaPers1.setBounds(146, 136, 56, 14);
		getContentPane().add(etiqDatoEnergiaPers1);
		
		JLabel etiqVidaPers2 = new JLabel("Vida");
		etiqVidaPers2.setBounds(289, 106, 46, 14);
		getContentPane().add(etiqVidaPers2);
		
		etiqDatoVidaPers2 = new JLabel("-");
		etiqDatoVidaPers2.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiqDatoVidaPers2.setBounds(345, 106, 56, 14);
		getContentPane().add(etiqDatoVidaPers2);
		
		JLabel etiqEnergiaPers2 = new JLabel("Energ\u00EDa");
		etiqEnergiaPers2.setBounds(289, 136, 46, 14);
		getContentPane().add(etiqEnergiaPers2);
		
		etiqDatoEnergiaPers2 = new JLabel("-");
		etiqDatoEnergiaPers2.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiqDatoEnergiaPers2.setBounds(345, 136, 56, 14);
		getContentPane().add(etiqDatoEnergiaPers2);
		
		JLabel etiqTurno = new JLabel("Es el turno de");
		etiqTurno.setBounds(90, 189, 104, 14);
		getContentPane().add(etiqTurno);
		
		txtTurno = new JTextField();
		txtTurno.setEditable(false);
		txtTurno.setBounds(204, 186, 86, 20);
		getContentPane().add(txtTurno);
		txtTurno.setColumns(10);
		
		JLabel etiqPuntos = new JLabel("Puntos a usar");
		etiqPuntos.setBounds(90, 220, 104, 14);
		getContentPane().add(etiqPuntos);
		
		txtPuntosAUsar = new JTextField();
		txtPuntosAUsar.setEditable(false);
		txtPuntosAUsar.setColumns(10);
		txtPuntosAUsar.setBounds(204, 217, 86, 20);
		getContentPane().add(txtPuntosAUsar);
		
		//BOTON ATACAR
		atacante = personaje1;
		defensor = personaje2;
		btnAtacar = new JButton("");
		btnAtacar.setEnabled(false);
		btnAtacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int energia = Integer.parseInt(txtPuntosAUsar.getText());
				//COMPARA QUIEN ES EL ATACANTE Y SETEA LOS DATOS
				if(personaje1.getNombre() == atacante.getNombre())
				{
					if (atacante.getEnergiaActual()>= energia){
						if (!partida.atacar(energia, atacante, defensor))
						{
							etiqDatoEnergiaPers1.setText(Integer.toString(atacante.getEnergiaActual()));
							etiqDatoVidaPers2.setText(Integer.toString(defensor.getVidaActual()));
							aux = partida.cambiarTurno();
							txtTurno.setText(aux.getNombre());
							txtPuntosAUsar.setText("");
							//ESTO LO MANDÉ ACÁ Y NO ESTOY SEGURO
							aux = defensor;
							defensor = atacante;
							atacante = aux;
						}
						else
						{
							notificarUsuario("Partida finalizada. Ganador: " + personaje1.getNombre());
							partida.ganador(personaje1);
							limpiarPantalla();
						}
					} else{
						notificarUsuario("Los puntos de energía del personaje no son suficientes para realizar el ataque");
					}
				}
				else
				{
					if (atacante.getEnergiaActual()>= energia){
						if (!partida.atacar(energia, atacante, defensor))
						{
							etiqDatoEnergiaPers2.setText(Integer.toString(atacante.getEnergiaActual()));
							etiqDatoVidaPers1.setText(Integer.toString(defensor.getVidaActual()));
							aux = partida.cambiarTurno();
							txtTurno.setText(aux.getNombre());
							txtPuntosAUsar.setText("");
							//ESTO LO MANDÉ ACÁ Y NO ESTOY SEGURO
							aux = defensor;
							defensor = atacante;
							atacante = aux;
						}
						else
						{
							notificarUsuario("Partida finalizada. Ganador: " + personaje2.getNombre());
							partida.ganador(personaje2);
							limpiarPantalla();
						}
					} else{
						notificarUsuario("Los puntos de energía del personaje no son suficientes para realizar el ataque");
					}
				}
			}
			
		});
		btnAtacar.setIcon(new ImageIcon("src\\interfaz\\Bomba.png"));
		btnAtacar.setBounds(201, 261, 89, 61);
		getContentPane().add(btnAtacar);
		
		//BOTON DEFENDER
		botonDefender = new JButton("");
		botonDefender.setEnabled(false);
		botonDefender.setIcon(new ImageIcon("src\\interfaz\\Escudo.png"));
		botonDefender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int defensa = Integer.parseInt(txtPuntosAUsar.getText());
				if(defensa <= 20)
				{
					//COMPARA QUIEN ES EL DEFENSOR Y SETEA LOS DATOS
					if(personaje1.getNombre().equals(atacante.getNombre()) || personaje1.getNombre().equals(defensor.getNombre()))
					{
						partida.defender(defensa, personaje1);
						aux = partida.cambiarTurno();
						etiqDatoEnergiaPers1.setText(Integer.toString(personaje1.getEnergiaActual()));
						etiqDatoVidaPers1.setText(Integer.toString(personaje1.getVidaActual()));
						txtTurno.setText(aux.getNombre());
					}
					else
					{
						partida.defender(defensa, personaje2);
						aux = partida.cambiarTurno();
						etiqDatoEnergiaPers2.setText(Integer.toString(personaje2.getEnergiaActual()));
						etiqDatoVidaPers2.setText(Integer.toString(personaje2.getVidaActual()));
						txtTurno.setText(aux.getNombre());
					}
					
				}
				else
				{
					notificarUsuario("Los puntos de defensa tienen que ser menor o igual a 20");
					txtPuntosAUsar.setText("");
				}
			}
		});
		botonDefender.setBounds(320, 261, 89, 61);
		getContentPane().add(botonDefender);
		
		JLabel etiqJugador1 = new JLabel("JUGADOR N\u00B0 1");
		etiqJugador1.setFont(new Font("Calibri", Font.BOLD, 14));
		etiqJugador1.setHorizontalAlignment(SwingConstants.CENTER);
		etiqJugador1.setBounds(107, 36, 95, 14);
		getContentPane().add(etiqJugador1);
		
		JLabel etiqJugador2 = new JLabel("JUGADOR N\u00B0 2");
		etiqJugador2.setFont(new Font("Calibri", Font.BOLD, 14));
		etiqJugador2.setHorizontalAlignment(SwingConstants.CENTER);
		etiqJugador2.setBounds(268, 36, 89, 14);
		getContentPane().add(etiqJugador2);
		
		txtPersonaje1 = new JTextField();
		txtPersonaje1.setBounds(78, 69, 147, 20);
		getContentPane().add(txtPersonaje1);
		txtPersonaje1.setColumns(10);
		
		txtPersonaje2 = new JTextField();
		txtPersonaje2.setColumns(10);
		txtPersonaje2.setBounds(242, 69, 147, 20);
		getContentPane().add(txtPersonaje2);
		
		btnPers1 = new JButton("");
		btnPers1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Personaje p1 = new Personaje();
				p1.setNombre(txtPersonaje1.getText());
				personaje1 = partida.buscaPersonaje(p1);
				etiqDatoEnergiaPers1.setText(Integer.toString(personaje1.getEnergia()));
				etiqDatoVidaPers1.setText(Integer.toString(personaje1.getVida()));
				txtPersonaje1.setEditable(false);
				if(!txtPersonaje2.isEditable()){
					btnIniciar.setEnabled(true);
				}
			}
		});
		btnPers1.setIcon(new ImageIcon(Partida.class.getResource("/com/sun/javafx/scene/control/skin/caspian/fxvk-capslock-button.png")));
		btnPers1.setBounds(25, 61, 43, 40);
		getContentPane().add(btnPers1);
		
		btnPers2 = new JButton("");
		btnPers2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Personaje p2 = new Personaje();
				p2.setNombre(txtPersonaje2.getText());
				personaje2 = partida.buscaPersonaje(p2);
				etiqDatoEnergiaPers2.setText(Integer.toString(personaje2.getEnergia()));
				etiqDatoVidaPers2.setText(Integer.toString(personaje2.getVida()));
				txtPersonaje2.setEditable(false);
				if(!txtPersonaje1.isEditable()){
					btnIniciar.setEnabled(true);
				}
			}
		});
		btnPers2.setIcon(new ImageIcon(Partida.class.getResource("/com/sun/javafx/scene/control/skin/caspian/fxvk-capslock-button.png")));
		btnPers2.setBounds(400, 61, 43, 40);
		getContentPane().add(btnPers2);
		
		btnIniciar = new JButton("Iniciar Partida");
		btnIniciar.setEnabled(false);
		btnIniciar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtPersonaje1.isEditable() && !txtPersonaje2.isEditable()){
					personaje1.setVidaActual(personaje1.getVida());
					personaje2.setVidaActual(personaje2.getVida());
					personaje1.setEnergiaActual(personaje1.getEnergia());
					personaje2.setEnergiaActual(personaje2.getEnergia());
					btnPers1.setEnabled(false);
					btnPers2.setEnabled(false);
					btnAtacar.setEnabled(true);
					botonDefender.setEnabled(true);
					txtPuntosAUsar.setEditable(true);
					partida.setearTurno(personaje1, personaje2);
					atacante = personaje1;
					defensor = personaje2;
					aux2 = partida.cambiarTurno();
					txtTurno.setText(aux2.getNombre());
					btnIniciar.setEnabled(false);
					etiqEnJuego.setText("EN JUEGO");
				}
			}
		});
		btnIniciar.setBounds(25, 261, 143, 61);
		getContentPane().add(btnIniciar);
		
		//ETIQUETA "EN JUEGO", SE HABILITA DESDE QUE INICIA LA PARTIDA HASTA QUE HAY UN GANADOR
		etiqEnJuego = new JLabel("");
		etiqEnJuego.setHorizontalAlignment(SwingConstants.CENTER);
		etiqEnJuego.setFont(new Font("Tahoma", Font.BOLD, 15));
		etiqEnJuego.setForeground(Color.RED);
		etiqEnJuego.setBounds(170, 0, 122, 31);
		getContentPane().add(etiqEnJuego);
	}
	
	
	public void mapearDePersonaje1(Personaje p){
		txtPersonaje1.setText(p.getNombre());
		etiqDatoEnergiaPers1.setText(String.valueOf(p.getEnergia()));
		etiqDatoVidaPers1.setText(String.valueOf(p.getVida()));
		}
	
	public void mapearDePersonaje2(Personaje p){
		txtPersonaje2.setText(p.getNombre());
		etiqDatoEnergiaPers2.setText(String.valueOf(p.getEnergia()));
		etiqDatoVidaPers2.setText(String.valueOf(p.getVida()));
		}
	
	public void limpiarPantalla(){
		etiqDatoEnergiaPers1.setText("-");
		etiqDatoEnergiaPers2.setText("-");
		etiqDatoVidaPers1.setText("-");
		etiqDatoVidaPers2.setText("-");
		txtPersonaje1.setText("");
		txtPersonaje2.setText("");
		txtPersonaje1.setEditable(true);
		txtPersonaje2.setEditable(true);
		btnPers1.setEnabled(true);
		btnPers2.setEnabled(true);
		txtPuntosAUsar.setText("");
		txtTurno.setText("");
		txtPuntosAUsar.setEditable(false);
		btnIniciar.setEnabled(false);
		btnAtacar.setEnabled(false);
		botonDefender.setEnabled(false);
		etiqEnJuego.setText("");
	}
	
	//METODO PARA NOTIFICAR ALGUN ERROR AL USUARIO
	private void notificarUsuario(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
			
}
