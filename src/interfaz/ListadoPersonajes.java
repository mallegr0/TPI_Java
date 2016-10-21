package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.Personaje;
import data.*;

import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.JList;

public class ListadoPersonajes extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoPersonajes dialog = new ListadoPersonajes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoPersonajes() {
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 630, 385);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		/*JList<Personaje> list = new JList<Personaje>(buscaPersonajes());
		list.setBounds(64, 51, 500, 252);
		contentPanel.add(list);*/
	}
}
