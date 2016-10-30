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
import javax.swing.ImageIcon;

public class BajaPersonaje extends JDialog {
	private JTextField txtID;
	private ControladorPersonaje ctrl;
	private JTextField txtNombre;
	private JTextField txtVida;
	private JTextField txtEnergia;
	private JTextField txtEvasion;
	private JTextField txtDefensa;
	private JButton btnLimpiar;

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
		ctrl = new ControladorPersonaje();
		
		setModal(true);
		setTitle("Eliminaci\u00F3n de Personajes");
		setResizable(false);
		setBounds(100, 100, 332, 288);
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
				ctrl = new ControladorPersonaje();
				p = mapearDeFormulario();
				ctrl.eliminaPersonaje(p);
				JOptionPane.showMessageDialog(null, "El personaje se eliminó correctamente");
				limpiarFormulario();
			}
		});
		btnEliminar.setBounds(62, 224, 89, 23);
		getContentPane().add(btnEliminar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			}
		});
		btnSalir.setBounds(156, 224, 89, 23);
		getContentPane().add(btnSalir);
		
		txtID = new JTextField();
		txtID.setBounds(94, 24, 45, 20);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personaje p = new Personaje();
				p = mapearDeFormulario();
				p = ctrl.consultaPersonaje(p);
				if(p!=null){
					mapearAFormulario(p);
					txtID.setEditable(false);
				}
				else{
					JOptionPane.showMessageDialog(null, "El personaje no existe");
				}
			}
		});
		btnBuscar.setBounds(149, 23, 89, 23);
		getContentPane().add(btnBuscar);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(94, 56, 144, 20);
		getContentPane().add(txtNombre);
		
		JLabel etiqNombre = new JLabel("Nombre");
		etiqNombre.setVerticalAlignment(SwingConstants.BOTTOM);
		etiqNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		etiqNombre.setBounds(23, 59, 61, 14);
		getContentPane().add(etiqNombre);
		
		txtVida = new JTextField();
		txtVida.setEditable(false);
		txtVida.setColumns(10);
		txtVida.setBounds(94, 87, 144, 20);
		getContentPane().add(txtVida);
		
		JLabel etiqVida = new JLabel("Vida");
		etiqVida.setVerticalAlignment(SwingConstants.BOTTOM);
		etiqVida.setHorizontalAlignment(SwingConstants.RIGHT);
		etiqVida.setBounds(23, 90, 61, 14);
		getContentPane().add(etiqVida);
		
		txtEnergia = new JTextField();
		txtEnergia.setEditable(false);
		txtEnergia.setColumns(10);
		txtEnergia.setBounds(94, 118, 144, 20);
		getContentPane().add(txtEnergia);
		
		JLabel etiqEnergia = new JLabel("Energ\u00EDa");
		etiqEnergia.setVerticalAlignment(SwingConstants.BOTTOM);
		etiqEnergia.setHorizontalAlignment(SwingConstants.RIGHT);
		etiqEnergia.setBounds(23, 121, 61, 14);
		getContentPane().add(etiqEnergia);
		
		txtEvasion = new JTextField();
		txtEvasion.setEditable(false);
		txtEvasion.setColumns(10);
		txtEvasion.setBounds(94, 180, 144, 20);
		getContentPane().add(txtEvasion);
		
		txtDefensa = new JTextField();
		txtDefensa.setEditable(false);
		txtDefensa.setColumns(10);
		txtDefensa.setBounds(94, 149, 144, 20);
		getContentPane().add(txtDefensa);
		
		JLabel etiqDefensa = new JLabel("Defensa");
		etiqDefensa.setVerticalAlignment(SwingConstants.BOTTOM);
		etiqDefensa.setHorizontalAlignment(SwingConstants.RIGHT);
		etiqDefensa.setBounds(23, 152, 61, 14);
		getContentPane().add(etiqDefensa);
		
		JLabel etiqEvasion = new JLabel("Evasi\u00F3n");
		etiqEvasion.setVerticalAlignment(SwingConstants.BOTTOM);
		etiqEvasion.setHorizontalAlignment(SwingConstants.RIGHT);
		etiqEvasion.setBounds(23, 183, 61, 14);
		getContentPane().add(etiqEvasion);
		
		btnLimpiar = new JButton("");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarFormulario();
			}
		});
		btnLimpiar.setIcon(new ImageIcon(BajaPersonaje.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		btnLimpiar.setBounds(261, 23, 40, 40);
		getContentPane().add(btnLimpiar);

	}
	
	public Personaje mapearDeFormulario(){
		Personaje p = new Personaje();
		p.setId(Integer.parseInt(txtID.getText()));
		return p;
	}
	
	public void limpiarFormulario(){
		btnLimpiar.setEnabled(true);
		txtID.setEditable(true);
		txtID.setText("");
		txtNombre.setText("");
		txtDefensa.setText("");
		txtVida.setText("");
		txtEnergia.setText("");
		txtEvasion.setText("");
	}
	
	public void mapearAFormulario(Personaje p){
		txtNombre.setText(p.getNombre());
		txtDefensa.setText(Integer.toString(p.getDefensa()));
		txtEnergia.setText(Integer.toString(p.getEnergia()));
		txtEvasion.setText(Integer.toString(p.getEvasion()));
		txtVida.setText(Integer.toString(p.getVida()));		
	}
}
