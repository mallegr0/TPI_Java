package interfaz;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.ControladorPersonaje;
import entidades.Personaje;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificacionPersonaje extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtEnergia;
	private JTextField txtVida;
	private JTextField txtEvasion;
	private JTextField txtDefensa;
	private JTextField txtPuntosPorAsignar;
	private JTextField txtID;
	private ControladorPersonaje ctrlPers;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModificacionPersonaje dialog = new ModificacionPersonaje();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModificacionPersonaje() {
		setModal(true);
		setTitle("Modificaci\u00F3n de Personajes");
		setResizable(false);
		setBounds(100, 100, 332, 320);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel etiqID = new JLabel("ID");
		etiqID.setHorizontalAlignment(SwingConstants.LEFT);
		etiqID.setVerticalAlignment(SwingConstants.BOTTOM);
		etiqID.setBounds(66, 32, 60, 14);
		contentPanel.add(etiqID);
		
		JLabel etiqNombre = new JLabel("Nombre");
		etiqNombre.setHorizontalAlignment(SwingConstants.LEFT);
		etiqNombre.setBounds(66, 57, 60, 14);
		contentPanel.add(etiqNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(122, 54, 133, 20);
		contentPanel.add(txtNombre);
		
		JLabel etiqEnergia = new JLabel("Energ\u00EDa");
		etiqEnergia.setHorizontalAlignment(SwingConstants.LEFT);
		etiqEnergia.setBounds(66, 82, 60, 14);
		contentPanel.add(etiqEnergia);
		
		txtEnergia = new JTextField();
		txtEnergia.setColumns(10);
		txtEnergia.setBounds(122, 79, 86, 20);
		contentPanel.add(txtEnergia);
		
		JLabel etiqVida = new JLabel("Vida");
		etiqVida.setHorizontalAlignment(SwingConstants.LEFT);
		etiqVida.setBounds(66, 107, 60, 14);
		contentPanel.add(etiqVida);
		
		txtVida = new JTextField();
		txtVida.setColumns(10);
		txtVida.setBounds(122, 104, 86, 20);
		contentPanel.add(txtVida);
		
		JLabel etiqEvasion = new JLabel("Evasi\u00F3n");
		etiqEvasion.setHorizontalAlignment(SwingConstants.LEFT);
		etiqEvasion.setBounds(66, 132, 60, 14);
		contentPanel.add(etiqEvasion);
		
		txtEvasion = new JTextField();
		txtEvasion.setColumns(10);
		txtEvasion.setBounds(122, 129, 86, 20);
		contentPanel.add(txtEvasion);
		
		JLabel etiqDefensa = new JLabel("Defensa");
		etiqDefensa.setHorizontalAlignment(SwingConstants.LEFT);
		etiqDefensa.setBounds(66, 157, 60, 14);
		contentPanel.add(etiqDefensa);
		
		txtDefensa = new JTextField();
		txtDefensa.setColumns(10);
		txtDefensa.setBounds(122, 154, 86, 20);
		contentPanel.add(txtDefensa);
		
		txtPuntosPorAsignar = new JTextField();
		txtPuntosPorAsignar.setToolTipText("");
		txtPuntosPorAsignar.setEditable(false);
		txtPuntosPorAsignar.setColumns(10);
		txtPuntosPorAsignar.setBounds(169, 199, 86, 20);
		contentPanel.add(txtPuntosPorAsignar);
		
		JLabel etiqPuntosXAsignar = new JLabel("Puntos por asignar");
		etiqPuntosXAsignar.setBounds(51, 202, 123, 14);
		contentPanel.add(etiqPuntosXAsignar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(85, 239, 89, 23);
		contentPanel.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(179, 239, 89, 23);
		contentPanel.add(btnCancelar);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(122, 29, 52, 20);
		contentPanel.add(txtID);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personaje p = new Personaje();
				Personaje p2 = new Personaje();
				p = mapearDeFormulario();
				//JOptionPane.showMessageDialog(null, p.getId());
				p2 = ctrlPers.consultaPersonaje(p);
				if(p2!=null){
					mapearDePersonaje(p2);	
				}
			}
		});
		btnBuscar.setBounds(179, 28, 89, 23);
		contentPanel.add(btnBuscar);
	}
	
	//METODO PARA COMPLETAR EL FORMULARIO DE ABMC DESDE UN OBJETO PERSONAJE
		public void mapearDePersonaje(Personaje p){
			txtNombre.setText(p.getNombre());
			txtEnergia.setText(String.valueOf(p.getEnergia()));
			txtVida.setText(String.valueOf(p.getVida()));
			txtEvasion.setText(String.valueOf(p.getEvasion()));
			txtDefensa.setText(String.valueOf(p.getDefensa()));
			txtPuntosPorAsignar.setText(String.valueOf(p.getPtosTotales()));
		}
		
		public Personaje mapearDeFormulario(){
			Personaje p = new Personaje();
			p.setId(Integer.parseInt(txtID.getText()));
			return p;
		}
}
