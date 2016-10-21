package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
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
		
		JLabel etiqPersonajes = new JLabel("Personajes");
		etiqPersonajes.setVerticalAlignment(SwingConstants.BOTTOM);
		etiqPersonajes.setBounds(51, 32, 73, 14);
		contentPanel.add(etiqPersonajes);
		
		JLabel etiqNombre = new JLabel("Nombre");
		etiqNombre.setBounds(66, 57, 46, 14);
		contentPanel.add(etiqNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(122, 54, 133, 20);
		contentPanel.add(txtNombre);
		
		JLabel etiqEnergia = new JLabel("Energ\u00EDa");
		etiqEnergia.setBounds(66, 82, 46, 14);
		contentPanel.add(etiqEnergia);
		
		txtEnergia = new JTextField();
		txtEnergia.setColumns(10);
		txtEnergia.setBounds(122, 79, 86, 20);
		contentPanel.add(txtEnergia);
		
		JLabel etiqVida = new JLabel("Vida");
		etiqVida.setBounds(66, 107, 46, 14);
		contentPanel.add(etiqVida);
		
		txtVida = new JTextField();
		txtVida.setColumns(10);
		txtVida.setBounds(122, 104, 86, 20);
		contentPanel.add(txtVida);
		
		JLabel etiqEvasion = new JLabel("Evasi\u00F3n");
		etiqEvasion.setBounds(66, 132, 46, 14);
		contentPanel.add(etiqEvasion);
		
		txtEvasion = new JTextField();
		txtEvasion.setColumns(10);
		txtEvasion.setBounds(122, 129, 86, 20);
		contentPanel.add(txtEvasion);
		
		JLabel etiqDefensa = new JLabel("Defensa");
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
		
		JComboBox cbPersonajes = new JComboBox();
		cbPersonajes.setBounds(122, 29, 133, 20);
		contentPanel.add(cbPersonajes);
	}
}
