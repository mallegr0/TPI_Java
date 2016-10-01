package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		frmUtnFighter.setTitle("UTN Fighter");
		frmUtnFighter.setBounds(100, 100, 450, 300);
		frmUtnFighter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUtnFighter.getContentPane().setLayout(null);
		
		JButton botonSalir = new JButton("Salir del Juego");
		botonSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		botonSalir.setBounds(137, 81, 150, 61);
		frmUtnFighter.getContentPane().add(botonSalir);
		
		JMenuBar menuBar = new JMenuBar();
		frmUtnFighter.setJMenuBar(menuBar);
		
		JMenu menuPersonajes = new JMenu("Personaje");
		menuBar.add(menuPersonajes);
		
		JMenuItem menuABMPersonajes = new JMenuItem("ABMC Personajes");
		menuABMPersonajes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				ABMPersonaje abmPers = new ABMPersonaje();
				abmPers.setVisible(true);
			}
		});
		menuPersonajes.add(menuABMPersonajes);
		
		JMenu menuPartida = new JMenu("Partida");
		menuBar.add(menuPartida);
		
		JMenuItem menuPartidaNueva = new JMenuItem("Nueva Partida");
		menuPartida.add(menuPartidaNueva);
		
		JMenu menuAyuda = new JMenu("Ayuda");
		menuBar.add(menuAyuda);
		
		JMenuItem menuActualizaciones = new JMenuItem("Actualizaciones");
		menuAyuda.add(menuActualizaciones);
		
		JMenuItem menuAcercaDe = new JMenuItem("Acerca de UTN Fighter");
		menuAyuda.add(menuAcercaDe);
	}

}
