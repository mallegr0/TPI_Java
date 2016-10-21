package interfaz;

import java.awt.*;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.ControladorPersonaje;
import data.DataPersonaje;
import java.util.*;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import entidades.Personaje;
import javafx.scene.control.ComboBox;
import controlador.*;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class Partida extends JDialog {
	private ControladorPartida partida = new ControladorPartida();
	private JTextField txtTurno;
	private JTextField txtPuntosAUsar;
	private DataPersonaje data;
	private JComboBox cbJugador2;
	private JComboBox cbJugador1;
	private JLabel etiqDatoVidaPers1;
	private JLabel etiqDatoEnergiaPers1;
	private JLabel etiqDatoVidaPers2;
	private JLabel etiqDatoEnergiaPers2;
	public Personaje personajeActivo;
	public Personaje personajePasivo;
	private JTextField txtPersonaje1;
	private JTextField txtPersonaje2;

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
					
					
					/*personajeActivo.setNombre("Ryu");
					personajeActivo.setEnergia(50);
					personajeActivo.setVida(50);
					personajeActivo.setDefensa(50);
					personajeActivo.setEvasion(50);
					personajeActivo.setId(7);
					personajeActivo.setPtosTotales(200);
					
					personajePasivo.setNombre("Rhonda");
					personajePasivo.setEnergia(50);
					personajePasivo.setVida(50);
					personajePasivo.setDefensa(50);
					personajePasivo.setEvasion(50);
					personajePasivo.setId(7);
					personajePasivo.setPtosTotales(200);
					*/
					
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
		
		etiqDatoVidaPers1 = new JLabel("200");
		etiqDatoVidaPers1.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiqDatoVidaPers1.setBounds(146, 106, 56, 14);
		getContentPane().add(etiqDatoVidaPers1);
		
		JLabel etiqEnergiaPers1 = new JLabel("Energia");
		etiqEnergiaPers1.setBounds(90, 136, 46, 14);
		getContentPane().add(etiqEnergiaPers1);
		
		etiqDatoEnergiaPers1 = new JLabel("200");
		etiqDatoEnergiaPers1.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiqDatoEnergiaPers1.setBounds(146, 136, 56, 14);
		getContentPane().add(etiqDatoEnergiaPers1);
		
		JLabel etiqVidaPers2 = new JLabel("Vida");
		etiqVidaPers2.setBounds(289, 106, 46, 14);
		getContentPane().add(etiqVidaPers2);
		
		etiqDatoVidaPers2 = new JLabel("200");
		etiqDatoVidaPers2.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiqDatoVidaPers2.setBounds(345, 106, 56, 14);
		getContentPane().add(etiqDatoVidaPers2);
		
		JLabel etiqEnergiaPers2 = new JLabel("Energ\u00EDa");
		etiqEnergiaPers2.setBounds(289, 136, 46, 14);
		getContentPane().add(etiqEnergiaPers2);
		
		etiqDatoEnergiaPers2 = new JLabel("200");
		etiqDatoEnergiaPers2.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiqDatoEnergiaPers2.setBounds(345, 136, 56, 14);
		getContentPane().add(etiqDatoEnergiaPers2);
		
		JLabel etiqTurno = new JLabel("Es el turno de");
		etiqTurno.setBounds(90, 189, 104, 14);
		getContentPane().add(etiqTurno);
		
		txtTurno = new JTextField();
		txtTurno.setEditable(false);
		//txtTurno.setText(personajeActivo.getNombre());
		txtTurno.setBounds(204, 186, 86, 20);
		getContentPane().add(txtTurno);
		txtTurno.setColumns(10);
		
		JLabel etiqPuntos = new JLabel("Puntos a usar");
		etiqPuntos.setBounds(90, 220, 104, 14);
		getContentPane().add(etiqPuntos);
		
		txtPuntosAUsar = new JTextField();
		txtPuntosAUsar.setColumns(10);
		txtPuntosAUsar.setBounds(204, 217, 86, 20);
		getContentPane().add(txtPuntosAUsar);
		
		JButton btnAtacar = new JButton("");
		btnAtacar.setIcon(new ImageIcon("D:\\Usuario\\Documents\\EDT_Eclipse\\TPI_Java\\src\\interfaz\\Bomba.png"));
		btnAtacar.setBounds(141, 261, 89, 61);
		//btnAtacar.setIcon(new ImageIcon(Partida.class.getResource("/interfaz/Bomba.png")));
		getContentPane().add(btnAtacar);
		
		JButton botonDefender = new JButton("");
		botonDefender.setIcon(new ImageIcon("D:\\Usuario\\Documents\\EDT_Eclipse\\TPI_Java\\src\\interfaz\\Escudo.png"));
		botonDefender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonDefender.setBounds(268, 261, 89, 61);
		getContentPane().add(botonDefender);
		
		cbJugador1 = new JComboBox();
		/*cbJugador1.setModel(new DefaultComboBoxModel(new String[] {}));
		try {
			llenarCB(cbJugador1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		cbJugador1.setBounds(78, 38, 147, 20);
		getContentPane().add(cbJugador1);
		
		cbJugador2 = new JComboBox();
		cbJugador2.setBounds(242, 38, 147, 20);
		getContentPane().add(cbJugador2);
		
		JLabel etiqJugador1 = new JLabel("JUGADOR N\u00B0 1");
		etiqJugador1.setFont(new Font("Calibri", Font.BOLD, 14));
		etiqJugador1.setHorizontalAlignment(SwingConstants.CENTER);
		etiqJugador1.setBounds(107, 13, 95, 14);
		getContentPane().add(etiqJugador1);
		
		JLabel etiqJugador2 = new JLabel("JUGADOR N\u00B0 2");
		etiqJugador2.setFont(new Font("Calibri", Font.BOLD, 14));
		etiqJugador2.setHorizontalAlignment(SwingConstants.CENTER);
		etiqJugador2.setBounds(268, 13, 89, 14);
		getContentPane().add(etiqJugador2);
		
		txtPersonaje1 = new JTextField();
		txtPersonaje1.setBounds(78, 69, 147, 20);
		getContentPane().add(txtPersonaje1);
		txtPersonaje1.setColumns(10);
		
		txtPersonaje2 = new JTextField();
		txtPersonaje2.setColumns(10);
		txtPersonaje2.setBounds(242, 69, 147, 20);
		getContentPane().add(txtPersonaje2);

		
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
	
}
