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

public class AltaPersonaje extends JDialog {

	private JTextField txtID;
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
		setModal(true);
		setResizable(false);
		
		//ACÁ CREO INSTANCIAS DEL CONTROLADOR Y EL DATA
		ControladorPersonaje ctrl = new ControladorPersonaje();
		DataPersonaje data = new DataPersonaje();
		
		setBounds(100, 100, 332, 302);
		getContentPane().setLayout(null);
		
		JLabel etiqID = new JLabel("ID");
		etiqID.setBounds(39, 16, 46, 14);
		getContentPane().add(etiqID);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(95, 13, 86, 20);
		txtID.setText(String.valueOf(data.devuelveID()));
		getContentPane().add(txtID);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(95, 38, 133, 20);
		getContentPane().add(txtNombre);
		
		JLabel etiqNombre = new JLabel("Nombre");
		etiqNombre.setBounds(39, 41, 46, 14);
		getContentPane().add(etiqNombre);
		
		JLabel etiqEnergia = new JLabel("Energ\u00EDa");
		etiqEnergia.setBounds(39, 66, 46, 14);
		getContentPane().add(etiqEnergia);
		
		txtEnergia = new JTextField();
		txtEnergia.setColumns(10);
		txtEnergia.setBounds(95, 63, 86, 20);
		getContentPane().add(txtEnergia);
		
		txtVida = new JTextField();
		txtVida.setColumns(10);
		txtVida.setBounds(95, 88, 86, 20);
		getContentPane().add(txtVida);
		
		JLabel EtiqVida = new JLabel("Vida");
		EtiqVida.setBounds(39, 91, 46, 14);
		getContentPane().add(EtiqVida);
		
		JLabel etiqEvasion = new JLabel("Evasi\u00F3n");
		etiqEvasion.setBounds(39, 116, 46, 14);
		getContentPane().add(etiqEvasion);
		
		txtEvasion = new JTextField();
		txtEvasion.setColumns(10);
		txtEvasion.setBounds(95, 113, 86, 20);
		getContentPane().add(txtEvasion);
		
		JLabel etiqDefensa = new JLabel("Defensa");
		etiqDefensa.setBounds(39, 141, 60, 14);
		getContentPane().add(etiqDefensa);
		
		txtDefensa = new JTextField();
		txtDefensa.setColumns(10);
		txtDefensa.setBounds(95, 138, 86, 20);
		getContentPane().add(txtDefensa);
		
		txtPuntos = new JTextField();
		txtPuntos.setToolTipText("");
		txtPuntos.setColumns(10);
		txtPuntos.setBounds(142, 183, 86, 20);
		getContentPane().add(txtPuntos);
		
		JLabel etiqPuntos = new JLabel("Puntos por asignar");
		etiqPuntos.setBounds(24, 186, 123, 14);
		getContentPane().add(etiqPuntos);
		
		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				Personaje p = new Personaje();
				if (datosValidos()){
					p = mapearDeFormulario();
					ctrl.altaPersonaje(p);
					JOptionPane.showMessageDialog(null, "Se guardo el personaje correctamente");
					limpiarFormulario();
				}
			}
		});
		botonAceptar.setBounds(66, 230, 89, 23);
		getContentPane().add(botonAceptar);
		
		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(166, 230, 89, 23);
		this.dispose();
		getContentPane().add(botonCancelar);
		
		JButton botonLimpiar = new JButton("");
		botonLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
			}
		});
		botonLimpiar.setIcon(new ImageIcon("C:\\Users\\Joel\\Pictures\\Limpiars.png"));
		botonLimpiar.setBounds(250, 13, 40, 40);
		getContentPane().add(botonLimpiar);

	}

	//METODO QUE TOMA LOS DATOS DEL FORMULARIO ABMC Y LOS MAPEA A UNA INSTANCIA DE LA CLASE PERSONAJE
	public Personaje mapearDeFormulario(){
		Personaje p = new Personaje();
		p.setId(Integer.parseInt(txtID.getText()));
		p.setNombre(txtNombre.getText());
		p.setEnergia(Integer.parseInt(txtEnergia.getText()));
		p.setVida(Integer.parseInt(txtVida.getText()));
		p.setEvasion(Integer.parseInt(txtEvasion.getText()));
		p.setDefensa(Integer.parseInt(txtDefensa.getText()));
		p.setPtosTotales(Integer.parseInt(txtPuntos.getText()));
		
		return p;
	}
	
	//METODO PARA LIMPIAR EL FORMULARIO DE ABMC DE PERSONAJES
	public void limpiarFormulario(){
		txtID.setText("");
		txtNombre.setText("");
		txtEnergia.setText("");
		txtVida.setText("");
		txtEvasion.setText("");
		txtDefensa.setText("");
		txtPuntos.setText("");
	}
	
	//ESTE METODO HACE VALIDACIONES VARIAS SOBRE LOS DATOS INGRESADOS EN EL ABMC
	public boolean datosValidos(){
		boolean valido = true;
		if(txtID.getText().trim().length() == 0 || txtNombre.getText().trim().length()==0
			|| txtEnergia.getText().trim().length()==0 || txtDefensa.getText().trim().length()==0
			|| txtVida.getText().trim().length()==0 || txtEvasion.getText().trim().length()==0){
			valido = false;
			notificarUsuario("Por favor, complete todos los campos.");
		}

		if(valido && (!txtVida.getText().matches("[0-9]*") || !txtEnergia.getText().matches("[0-9]*")
			|| !txtEvasion.getText().matches("[0-9]*") || !txtDefensa.getText().matches("[0-9]*")
			|| !txtPuntos.getText().matches("[0-9]*") || !txtID.getText().matches("[0-9]*"))){
			valido = false;
			notificarUsuario("A excepción del nombre, el resto de los campos debe ser numérico exclusivamente.");
		}
		return valido;		
	}
	
	//METODO PARA VALIDAR LA DISTRIBUCION CORRECTA DE PUNTOS
	
	
	//METODO PARA COMPLETAR EL FORMULARIO DE ABMC DESDE UN OBJETO PERSONAJE
	public void mapearDePersonaje(Personaje p){
		txtID.setText(String.valueOf(p.getId()));
		txtNombre.setText(p.getNombre());
		txtEnergia.setText(String.valueOf(p.getEnergia()));
		txtVida.setText(String.valueOf(p.getVida()));
		txtEvasion.setText(String.valueOf(p.getEvasion()));
		txtDefensa.setText(String.valueOf(p.getDefensa()));
		txtPuntos.setText(String.valueOf(p.getPtosTotales()));
	};
	
	//METODO PARA NOTIFICAR ALGUN ERROR AL USUARIO
	private void notificarUsuario(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
}
