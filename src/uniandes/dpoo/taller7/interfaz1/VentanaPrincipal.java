package uniandes.dpoo.taller7.interfaz1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uniandes.dpoo.taller7.interfaz2.PanelDerecha;
import uniandes.dpoo.taller7.interfaz2.PanelInferior;
import uniandes.dpoo.taller7.interfaz2.PanelSuperior;
import uniandes.dpoo.taller7.interfaz2.Paneltop;
import uniandes.dpoo.taller7.interfaz3.PanelCuadros;
import uniandes.dpoo.taller7.modelo.Tablero;
import uniandes.dpoo.taller7.modelo.Top10;

public class VentanaPrincipal extends JFrame {
	
	private Tablero tablero;
	private JFrame ventana;
	private PanelSuperior superior;
	private PanelCuadros juego;
	private PanelDerecha derecha;
	private Top10 top;
	private PanelInferior inferior;
	
	public VentanaPrincipal() {
		JFrame ventana = new JFrame();
		this.top = new Top10();
		top.cargarRecords(new File("./data/top10.csv"));
		
		ventana.setLayout(new BorderLayout());
		PanelDerecha botones = new PanelDerecha(this);
		PanelInferior inferior = new PanelInferior(this);
		PanelSuperior superior = new PanelSuperior(this);
		JPanel panel = new JPanel(new GridLayout());
		
		this.tablero = new  Tablero(superior.getTamano());
		tablero.desordenar(superior.getDificultad());
		
		
		PanelCuadros juego = new PanelCuadros(tablero, this, inferior);
		
		panel.add(botones);
		
		this.ventana = ventana;
		this.superior = superior;
		this.juego = juego;
		this.inferior = inferior;
		
		this.juego.setPreferredSize(new Dimension(800,800));
		
		this.ventana.add(panel,BorderLayout.EAST);
		this.ventana.add(inferior,BorderLayout.SOUTH);
		this.ventana.add(superior,BorderLayout.NORTH);
		this.ventana.add(juego,BorderLayout.CENTER);
		
		this.ventana.setTitle("Juego de LightsOut");
		this.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.ventana.setSize(775,700);
		
		
		
		this.ventana.setVisible(true);
		
		
		this.ventana.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				try {
					top.salvarRecords(new File("./data/top10.csv"));
				} catch (FileNotFoundException | UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	}
	
	public void nuevoJuego() {
		remove(juego);
		revalidate();
		repaint();
		tablero = new Tablero(superior.getTamano());
		tablero.desordenar(superior.getDificultad());
		juego = new PanelCuadros(tablero,this,inferior);
		add(juego, BorderLayout.CENTER);
		revalidate();
		repaint();
		setJugadas(0);
		
	}
	
	
	public void reiniciar() {
		ventana.remove(juego);
		ventana.revalidate();
		ventana.repaint();
		tablero.reiniciar();
		juego = new PanelCuadros(tablero, this, inferior);
		add(juego,BorderLayout.CENTER);
		ventana.revalidate();
		ventana.repaint();
		setJugadas(0);
	}
	
	public void setJugadas(int i) {
		// TODO Auto-generated method stub
		remove(inferior);
		revalidate();
		repaint();
		inferior.setJugadas(i);
		add(inferior,BorderLayout.SOUTH);
		revalidate();
		repaint();
	}

	public void setJugador() {
		inferior.setJugador();
	}
	
	public static void main(String[] args) {
		new VentanaPrincipal();
	}
	
	public void setCuadros(ArrayList<String> parametros) {
		remove(inferior);
		revalidate();
		repaint();
		add(inferior,BorderLayout.SOUTH);
		revalidate();
		repaint();
		
	}
	public void actualizarTop(int puntaje) {
		if(top.esTop10(puntaje)) {
			top.agregarRegistro(inferior.getJugador(), puntaje);
		}
	}
	public void mostrarTop() {
		new Paneltop(this, this.top);
	}
}
