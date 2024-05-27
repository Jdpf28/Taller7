package uniandes.dpoo.taller7.interfaz2;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uniandes.dpoo.taller7.interfaz1.VentanaPrincipal;

public class PanelInferior extends JPanel{
	
	private VentanaPrincipal ventana;
	private JLabel jugadas;
	private JTextField jugador;
	private String nombre;
	
	public PanelInferior(VentanaPrincipal ventana) {
		this.ventana = ventana;
		this.jugador = new JTextField("Invitado");
		this.nombre = "Invitado";
		
		JPanel panel = new JPanel();
		this.jugadas = new JLabel("0");
		
		add(new JLabel("Jugadas: "));
		add(jugadas);
		
		add(new JLabel("Jugador"));
		add(jugador);
	}
	
	public void setJugadas(int jugadas) {
		remove(this.jugadas);
		ventana.revalidate();
		ventana.repaint();
		this.jugadas = new JLabel(Integer.toString(jugadas));
		add(this.jugadas,1);
		ventana.revalidate();
		ventana.repaint();
	}

	public void setJugador() {
		// TODO Auto-generated method stub
		this.nombre = jugador.getText();
	}

	public void setCuadros(ArrayList<String> parametros) {
		
		ventana.revalidate();
		ventana.repaint();
		
		
	}

	public String getJugador() {
		// TODO Auto-generated method stub
		return this.nombre;
	}
	
}
