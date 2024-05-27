package uniandes.dpoo.taller7.interfaz2;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;

import uniandes.dpoo.taller7.interfaz1.VentanaPrincipal;
import uniandes.dpoo.taller7.modelo.Top10;

public class Paneltop extends JDialog {
	
	private VentanaPrincipal ventana;
	private Top10 top;
	
	public Paneltop(VentanaPrincipal ventana, Top10 top) {
		// TODO Auto-generated constructor stub
		this.ventana = ventana;
		
		setLayout(new BorderLayout());
		setTitle("Top 10");
		
		//aqui falta poner la gente que esta en el top, pero no me alcanzó el tiempo :(
		
		add(new JLabel("#	nombre"), BorderLayout.NORTH);
		
		setModal(true);
		setSize(250, 300);
		setLocationRelativeTo(this.ventana);
		setVisible(true);
	}
	
	
}
