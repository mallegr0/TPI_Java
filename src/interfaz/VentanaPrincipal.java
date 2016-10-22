package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class VentanaPrincipal {

	private JFrame frmUtnFighter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frmUtnFighter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUtnFighter = new JFrame();
		frmUtnFighter.getContentPane().setBackground(new Color(0, 139, 139));
		frmUtnFighter.setTitle("UTN Fighter");
		frmUtnFighter.setBounds(100, 100, 450, 300);
		frmUtnFighter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUtnFighter.getContentPane().setLayout(null);
		frmUtnFighter.setResizable(false);
		
		JButton botonSalir = new JButton("");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		botonSalir.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		botonSalir.setBounds(400, 11, 34, 32);
		frmUtnFighter.getContentPane().add(botonSalir);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("src\\interfaz\\Ryu.jpg"));
		btnNewButton.setBounds(128, 38, 179, 161);
		frmUtnFighter.getContentPane().add(btnNewButton);
		
		JMenuBar menuBar = new JMenuBar();
		frmUtnFighter.setJMenuBar(menuBar);
		
		JMenu menuPersonajes = new JMenu("Personaje");
		menuBar.add(menuPersonajes);
		
		JMenuItem menuAltaPers = new JMenuItem("Agregar");
		menuAltaPers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaPersonaje abmPers = new AltaPersonaje();
				frmUtnFighter.setVisible(false);
				abmPers.setVisible(true);
				frmUtnFighter.setVisible(true);
			}
		});
		
		menuPersonajes.add(menuAltaPers);
		
		JMenuItem menuModifPers = new JMenuItem("Modificar");
		menuModifPers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificacionPersonaje modifPers = new ModificacionPersonaje();
				frmUtnFighter.setVisible(false);
				modifPers.setVisible(true);
				frmUtnFighter.setVisible(true);
			}
		});
		menuPersonajes.add(menuModifPers);
		
		JMenuItem menuElimPers = new JMenuItem("Eliminar");
		menuElimPers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BajaPersonaje elimPers = new BajaPersonaje();
				frmUtnFighter.setVisible(false);
				elimPers.setVisible(true);
				frmUtnFighter.setVisible(true);
			}
		});
		menuPersonajes.add(menuElimPers);
		
		JMenuItem menuListaPers = new JMenuItem("Listado completo");
		menuListaPers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoPersonajes listaPers = new ListadoPersonajes();
				frmUtnFighter.setVisible(false);
				listaPers.setVisible(true);
				frmUtnFighter.setVisible(true);
			}
		});
		menuPersonajes.add(menuListaPers);
		
		JMenu menuPartida = new JMenu("Partida");
		menuBar.add(menuPartida);
		
		JMenuItem menuPartidaNueva = new JMenuItem("Nueva partida");
		menuPartidaNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Partida partida = new Partida();
				frmUtnFighter.setVisible(false);
				partida.setVisible(true);
				frmUtnFighter.setVisible(true);
			}
		});
		menuPartida.add(menuPartidaNueva);
		
		JMenu menuAyuda = new JMenu("Ayuda");
		menuBar.add(menuAyuda);
		
		JMenuItem menuActualizaciones = new JMenuItem("Actualizaciones");
		menuAyuda.add(menuActualizaciones);
		
		JMenuItem menuAcercaDe = new JMenuItem("Acerca de UTN Fighter");
		menuAyuda.add(menuAcercaDe);
	}
}
