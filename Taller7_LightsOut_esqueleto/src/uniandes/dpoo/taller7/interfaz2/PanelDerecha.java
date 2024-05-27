package uniandes.dpoo.taller7.interfaz2;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import uniandes.dpoo.taller7.interfaz1.VentanaPrincipal;

public class PanelDerecha extends JPanel implements ActionListener{
	
	private VentanaPrincipal ventana;
	private PanelSuperior superior;
	
	public PanelDerecha(VentanaPrincipal ventana) {
		this.ventana = ventana;
		JPanel panel = new JPanel();
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JButton nuevo = new JButton("NUEVO");
		JButton reiniciar = new JButton("REINICIAR");
		JButton top10 = new JButton("TOP 10");
		JButton cambiarJugador = new JButton("CAMBIAR JUGADOR");
		
		nuevo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ventana.nuevoJuego();
			}
		});
		
		reiniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ventana.reiniciar();
			}
		});
		
		cambiarJugador.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ventana.setJugador();
			}
		});
		
		top10.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		add(nuevo);
		add(reiniciar);
		add(top10);
		add(cambiarJugador);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
