package interfaz;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import controlador.ControladorPersonaje;
import entidades.Personaje;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class BajaPersonaje extends JDialog {
	private JTextField txtID;
	private ControladorPersonaje ctrl;
	private JTextField txtNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BajaPersonaje dialog = new BajaPersonaje();
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
	public BajaPersonaje() {
		setModal(true);
		setTitle("Eliminaci\u00F3n de Personajes");
		setResizable(false);
		setBounds(100, 100, 332, 182);
		getContentPane().setLayout(null);
		
		JLabel etiqID = new JLabel("ID");
		etiqID.setHorizontalAlignment(SwingConstants.RIGHT);
		etiqID.setVerticalAlignment(SwingConstants.BOTTOM);
		etiqID.setBounds(50, 27, 34, 14);
		getContentPane().add(etiqID);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Personaje p = new Personaje();
				p = mapearDeFormulario();
				if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el personaje?") == 1){
					ctrl.eliminaPersonaje(p);
					txtID.setText("");
					txtNombre.setText("");	
				}
			}
		});
		btnEliminar.setBounds(71, 107, 89, 23);
		getContentPane().add(btnEliminar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			}
		});
		btnCancelar.setBounds(165, 107, 89, 23);
		getContentPane().add(btnCancelar);
		
		txtID = new JTextField();
		txtID.setBounds(94, 24, 45, 20);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(149, 23, 89, 23);
		getContentPane().add(btnBuscar);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(94, 56, 144, 20);
		getContentPane().add(txtNombre);
		
		JLabel etiqNombre = new JLabel("Nombre");
		etiqNombre.setVerticalAlignment(SwingConstants.BOTTOM);
		etiqNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		etiqNombre.setBounds(23, 59, 61, 14);
		getContentPane().add(etiqNombre);

	}
	
	public Personaje mapearDeFormulario(){
		Personaje p = new Personaje();
		p.setId(Integer.parseInt(txtID.getText()));
		return p;
	}
}
