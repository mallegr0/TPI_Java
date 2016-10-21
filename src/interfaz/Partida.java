package interfaz;

import java.awt.*;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.ControladorPartida;
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


import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class Partida extends JDialog {
	private ControladorPartida juego = new ControladorPartida();
	private JLabel etiqVidaPers1;
	private JTextField txtTurno;
	private JTextField txtPuntosAUsar;
	private DataPersonaje data;
	private JComboBox cbJugador2;
	private JComboBox cbJugador1;
	private JLabel etiqDatoVidaPers1;
	private JLabel etiqDatoEnergiaPers1;
	private JLabel etiqDatoVidaPers2;
	private JLabel etiqDatoEnergiaPers2;

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
		
		etiqVidaPers1 = new JLabel("Vida");
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
		cbJugador1.setBounds(83, 60, 147, 20);
		getContentPane().add(cbJugador1);
		
		cbJugador2 = new JComboBox();
		cbJugador2.setBounds(247, 60, 147, 20);
		getContentPane().add(cbJugador2);
		
		JLabel etiqJugador1 = new JLabel("JUGADOR N\u00B0 1");
		etiqJugador1.setFont(new Font("Calibri", Font.BOLD, 14));
		etiqJugador1.setHorizontalAlignment(SwingConstants.CENTER);
		etiqJugador1.setBounds(107, 33, 95, 14);
		getContentPane().add(etiqJugador1);
		
		JLabel etiqJugador2 = new JLabel("JUGADOR N\u00B0 2");
		etiqJugador2.setFont(new Font("Calibri", Font.BOLD, 14));
		etiqJugador2.setHorizontalAlignment(SwingConstants.CENTER);
		etiqJugador2.setBounds(268, 33, 89, 14);
		getContentPane().add(etiqJugador2);

		
	}
	
	/*public void llenarCB(JComboBox combo) throws SQLException{
		DefaultComboBoxModel mldCombo = new DefaultComboBoxModel();
		combo.setModel(mldCombo);
		combo.removeAllItems();
		
		ArrayList<String> resultado = data.listarPersonajes();	 
	    for(int i=0; i<resultado.size();i++){
	    	String nombre = (String)resultado.get(i);
	        combo.addItem(resultado.get(i));
	    }
		
	}*/
}
