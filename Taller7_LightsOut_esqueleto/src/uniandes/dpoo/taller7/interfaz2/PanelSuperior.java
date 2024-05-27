package uniandes.dpoo.taller7.interfaz2;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import uniandes.dpoo.taller7.interfaz1.VentanaPrincipal;



public class PanelSuperior extends JPanel implements ActionListener{
	
	private VentanaPrincipal ventana;
	private int dificultad;
	private int tamano;
	
	public PanelSuperior(VentanaPrincipal ventana) {
		this.ventana = ventana;
		this.tamano = 5;
		this.dificultad = 1;
		
		JPanel panel = new JPanel();
		
		JRadioButton facil = new JRadioButton("Facil");
		JRadioButton medio = new JRadioButton("Medio");
		JRadioButton dificil = new JRadioButton("Dificil");
		
		JComboBox<String> tamano = new JComboBox<String>();
		tamano.addItem("5x5");
		tamano.addItem("6x6");
		tamano.addItem("7x7");
		
		tamano.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int x = Integer.parseInt(((String) tamano.getSelectedItem()).substring(2));
				setTamano(x);
			}
		});
		
		add(new JLabel("Tamaño: "));
		
		add(tamano);
		
		add(new JLabel("Dificultad: "));
		add(facil);
		add(medio);
		add(dificil);
		
		facil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setDificultad(3);
			}
		});
		
		medio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setDificultad(8);
			}
		});
		
		dificil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				setDificultad(13);
			}
		});
		ButtonGroup dificultad = new ButtonGroup();
		dificultad.add(facil);
		dificultad.add(medio);
		dificultad.add(dificil);
		dificultad.setSelected(facil.getModel(), true);
		
 	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void setTamano(int tamano) {
		this.tamano=tamano;
	}

	public int getTamano() {
		return tamano;
	}

	public int getDificultad() {
		return dificultad;
	}
	
	public void setDificultad(int dif) {
		this.dificultad = dif;
	}
	
}
