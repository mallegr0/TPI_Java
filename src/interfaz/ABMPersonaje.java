package interfaz;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.ControladorPersonaje;
import data.DataPersonaje;
import entidades.Personaje;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ABMPersonaje extends JDialog {

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
					ABMPersonaje dialog = new ABMPersonaje();
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
	public ABMPersonaje() {
		
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
		getContentPane().add(txtID);
		
		JButton botonBuscar = new JButton("Buscar");
		botonBuscar.setBounds(191, 11, 86, 23);
		getContentPane().add(botonBuscar);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(95, 38, 86, 20);
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
		
		JButton botonAgregar = new JButton("Agregar");
		botonAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if (datosValidos()){
					mapearDeFormulario();
					limpiarFormulario();
					JOptionPane.showMessageDialog(null, "Se guardo el personaje correctamente");
					}
				//else JOptionPane.showMessageDialog(null, "Se guardo el personaje");
				
				
				
				
			}
		});
		botonAgregar.setBounds(10, 223, 89, 23);
		getContentPane().add(botonAgregar);
		
		JButton botonModificar = new JButton("Modificar");
		botonModificar.setBounds(109, 223, 89, 23);
		getContentPane().add(botonModificar);
		
		JButton botonEliminar = new JButton("Eliminar");
		botonEliminar.setBounds(208, 223, 89, 23);
		getContentPane().add(botonEliminar);

	}

	public Personaje mapearDeFormulario(){
		Personaje p = new Personaje();
		p.setId(Integer.parseInt(txtID.getText()));
		p.setNombre(txtNombre.getText());
		p.setEnergia(Integer.parseInt(txtEnergia.getText()));
		p.setVida(Integer.parseInt(txtVida.getText()));
		p.setEvasion(Integer.parseInt(txtEvasion.getText()));
		p.setDefensa(Integer.parseInt(txtDefensa.getText()));
		
		return p;
	}
	
	public void limpiarFormulario(){
		txtID.setText("");
		txtNombre.setText("");
		txtEnergia.setText("");
		txtVida.setText("");
		txtEvasion.setText("");
		txtDefensa.setText("");
		txtPuntos.setText("");
	}
	
	public boolean datosValidos(){
		
		boolean valido = true;
		if(txtID.getText().trim().length() == 0 || txtNombre.getText().trim().length()==0){
			valido = false;
			notificarUsuario("Por favor, complete todos los campos");
		}
		
		if(valido && !txtID.getText().matches("[0-9]*")){
			valido = false;
			notificarUsuario("El ID no es correcto");
		}
		
		if(valido && !txtID.getText().matches("[0-9]*")){
			valido = false;
			notificarUsuario("El ID no es correcto");
		}
			
		return valido;		
	}
	
	private void notificarUsuario(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	/*public Personaje mapearDePersonaje(){
		
	};*/
	
}
