package interfaz;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class BajaPersonaje extends JDialog {

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
		setBounds(100, 100, 332, 181);
		getContentPane().setLayout(null);
		
		JLabel etiqPersonajes = new JLabel("Personajes");
		etiqPersonajes.setVerticalAlignment(SwingConstants.BOTTOM);
		etiqPersonajes.setBounds(50, 27, 73, 14);
		getContentPane().add(etiqPersonajes);
		
		JComboBox cbPersonajes = new JComboBox();
		cbPersonajes.setBounds(121, 24, 133, 20);
		getContentPane().add(cbPersonajes);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(70, 97, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(164, 97, 89, 23);
		getContentPane().add(btnCancelar);

	}
}
