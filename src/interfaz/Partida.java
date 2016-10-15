package interfaz;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.ControladorPartida;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Partida extends JDialog {
	private ControladorPartida juego = new ControladorPartida();
	private JLabel lblVida;
	private JTextField textField;
	private JTextField textField_1;

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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblPersonaje1 = new JLabel("Personaje 1");
		lblPersonaje1.setBounds(72, 27, 77, 14);
		getContentPane().add(lblPersonaje1);
		
		JLabel lblPersonaje2 = new JLabel("Personaje 2");
		lblPersonaje2.setBounds(260, 27, 77, 14);
		getContentPane().add(lblPersonaje2);
		
		lblVida = new JLabel("New label");
		lblVida.setBounds(37, 56, 46, 14);
		getContentPane().add(lblVida);
		
		JLabel label = new JLabel("200");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(93, 56, 56, 14);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(37, 86, 46, 14);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("200");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(93, 86, 56, 14);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("New label");
		label_3.setBounds(236, 56, 46, 14);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("200");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(292, 56, 56, 14);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("New label");
		label_5.setBounds(236, 86, 46, 14);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("200");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_6.setBounds(292, 86, 56, 14);
		getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("New label");
		label_7.setBounds(37, 139, 46, 14);
		getContentPane().add(label_7);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(93, 136, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_8 = new JLabel("New label");
		label_8.setBounds(37, 170, 46, 14);
		getContentPane().add(label_8);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(93, 167, 86, 20);
		getContentPane().add(textField_1);
		
		JButton btnAtacar = new JButton("Atacar");
		btnAtacar.setBounds(72, 210, 89, 23);
		getContentPane().add(btnAtacar);
		
		JButton button = new JButton("Defender");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(246, 210, 89, 23);
		getContentPane().add(button);

	}
}
