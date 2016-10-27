package interfaz;

import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.DefaultValueLoaderDecorator;

import controlador.ControladorPersonaje;
import data.DataPersonaje;
import entidades.Personaje;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class AltaPersonaje extends JDialog {
	private JTextField txtNombre;
	private JTextField txtEnergia;
	private JTextField txtVida;
	private JTextField txtEvasion;
	private JTextField txtDefensa;
	private JTextField txtPuntos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaPersonaje dialog = new AltaPersonaje();
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
	public AltaPersonaje() {
		setTitle("Alta de Personajes");
		setModal(true);
		setResizable(false);
		
		ControladorPersonaje ctrl = new ControladorPersonaje();
				
		setBounds(100, 100, 332, 274);
		getContentPane().setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(100, 22, 133, 20);
		getContentPane().add(txtNombre);
		
		JLabel etiqNombre = new JLabel("Nombre");
		etiqNombre.setBounds(44, 25, 46, 14);
		getContentPane().add(etiqNombre);
		
		JLabel etiqEnergia = new JLabel("Energ\u00EDa");
		etiqEnergia.setBounds(44, 50, 46, 14);
		getContentPane().add(etiqEnergia);
		
		txtEnergia = new JTextField();
		txtEnergia.setColumns(10);
		txtEnergia.setBounds(100, 47, 86, 20);
		getContentPane().add(txtEnergia);
		
		txtVida = new JTextField();
		txtVida.setColumns(10);
		txtVida.setBounds(100, 72, 86, 20);
		getContentPane().add(txtVida);
		
		JLabel EtiqVida = new JLabel("Vida");
		EtiqVida.setBounds(44, 75, 46, 14);
		getContentPane().add(EtiqVida);
		
		JLabel etiqEvasion = new JLabel("Evasi\u00F3n");
		etiqEvasion.setBounds(44, 100, 46, 14);
		getContentPane().add(etiqEvasion);
		
		txtEvasion = new JTextField();
		txtEvasion.setColumns(10);
		txtEvasion.setBounds(100, 97, 86, 20);
		getContentPane().add(txtEvasion);
		
		JLabel etiqDefensa = new JLabel("Defensa");
		etiqDefensa.setBounds(44, 125, 60, 14);
		getContentPane().add(etiqDefensa);
		
		txtDefensa = new JTextField();
		txtDefensa.setColumns(10);
		txtDefensa.setBounds(100, 122, 86, 20);
		getContentPane().add(txtDefensa);
		
		txtPuntos = new JTextField();
		txtPuntos.setEditable(false);
		txtPuntos.setHorizontalAlignment(SwingConstants.CENTER);
		txtPuntos.setToolTipText("");
		txtPuntos.setText("200");
		txtPuntos.setColumns(10);
		txtPuntos.setBounds(147, 167, 86, 20);
		getContentPane().add(txtPuntos);
		
		JLabel etiqPuntos = new JLabel("Puntos por asignar");
		etiqPuntos.setBounds(29, 170, 123, 14);
		getContentPane().add(etiqPuntos);
		
		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				Personaje p = new Personaje();
				if (datosValidos()){
					p = mapearDeFormulario();
					ctrl.altaPersonaje(p);
					notificarUsuario("Se guardo el personaje correctamente");
					limpiarFormulario();
				}
			}
		});
		botonAceptar.setBounds(67, 208, 89, 23);
		getContentPane().add(botonAceptar);
		
		JButton botonSalir = new JButton("Salir");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		botonSalir.setBounds(167, 208, 89, 23);
		getContentPane().add(botonSalir);
		
		JButton botonLimpiar = new JButton("");
		botonLimpiar.setIcon(new ImageIcon(AltaPersonaje.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		botonLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
			}
		});
		botonLimpiar.setBounds(256, 22, 40, 40);
		getContentPane().add(botonLimpiar);

	}

	//METODO QUE TOMA LOS DATOS DEL FORMULARIO ABMC Y LOS MAPEA A UNA INSTANCIA DE LA CLASE PERSONAJE
	public Personaje mapearDeFormulario(){
		Personaje p = new Personaje();
		int ptosUsados = (Integer.parseInt(txtEnergia.getText()) + Integer.parseInt(txtVida.getText()) +
						  Integer.parseInt(txtEvasion.getText()) + Integer.parseInt(txtDefensa.getText()));
		p.setNombre(txtNombre.getText());
		p.setEnergia(Integer.parseInt(txtEnergia.getText()));
		p.setVida(Integer.parseInt(txtVida.getText()));
		p.setEvasion(Integer.parseInt(txtEvasion.getText()));
		p.setDefensa(Integer.parseInt(txtDefensa.getText()));
		p.setPtosTotales(Integer.parseInt(txtPuntos.getText()) - ptosUsados);
		
		return p;
	}
	
	//METODO PARA LIMPIAR EL FORMULARIO DE ABMC DE PERSONAJES
	public void limpiarFormulario(){
		txtNombre.setText("");
		txtEnergia.setText("");
		txtVida.setText("");
		txtEvasion.setText("");
		txtDefensa.setText("");
	}
	
	//ESTE METODO HACE VALIDACIONES VARIAS SOBRE LOS DATOS INGRESADOS EN EL ABMC
	public boolean datosValidos(){
		boolean valido = true;
		if(txtNombre.getText().trim().length()==0
			|| txtEnergia.getText().trim().length()==0 || txtDefensa.getText().trim().length()==0
			|| txtVida.getText().trim().length()==0 || txtEvasion.getText().trim().length()==0){
			valido = false;
			notificarUsuario("Por favor, complete todos los campos.");
		}

		if(valido && (!txtVida.getText().matches("[0-9]*") || !txtEnergia.getText().matches("[0-9]*")
			|| !txtEvasion.getText().matches("[0-9]*") || !txtDefensa.getText().matches("[0-9]*")
			|| !txtPuntos.getText().matches("[0-9]*"))){
			valido = false;
			notificarUsuario("A excepción del nombre, el resto de los campos debe ser numérico exclusivamente.");
		}
		
		if(Integer.parseInt(txtDefensa.getText()) > 20 || Integer.parseInt(txtEvasion.getText()) > 80){
			valido = false;
			notificarUsuario("Valores máximos para Defensa 20 y Evasión 80");
		}
		
		if((Integer.parseInt(txtDefensa.getText()) + Integer.parseInt(txtEvasion.getText()) +
			Integer.parseInt(txtEnergia.getText()) + Integer.parseInt(txtVida.getText()) > 200)){
			valido = false;
			notificarUsuario("La suma total de puntos asignados no puede superar los 200 puntos.");
		}
		
		return valido;		
	}
	
	//METODO PARA NOTIFICAR ALGUN ERROR AL USUARIO
	private void notificarUsuario(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
}
