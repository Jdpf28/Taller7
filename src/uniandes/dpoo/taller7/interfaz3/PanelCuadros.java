package uniandes.dpoo.taller7.interfaz3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.dpoo.taller7.interfaz1.VentanaPrincipal;
import uniandes.dpoo.taller7.interfaz2.PanelInferior;
import uniandes.dpoo.taller7.modelo.Tablero;

public class PanelCuadros extends JPanel implements MouseListener{

	private VentanaPrincipal ventana;
	private int tamano;
	private Tablero tablero;
	private int altoCuadros;
	private int anchoCuadros;
	private PanelInferior inferior;
	
	public PanelCuadros(Tablero tablero, VentanaPrincipal ventana, PanelInferior inferior) {
		this.tamano = tablero.darTablero().length;
		this.tablero = tablero;
		this.ventana = ventana;
		this.inferior = inferior;
		addMouseListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.setColor(Color.white);
		g2D.fillRect(0, 0, getWidth(), getHeight());
		
		int alto = getHeight();
		int largo = getWidth();
		
		largo = (largo/tamano) -5;
		alto = (alto/tamano) -5;
		
		this.altoCuadros = alto;
		this.anchoCuadros = largo;
		
		int x =0;
		int y= 0;
		
		BufferedImage luz = null;
		try {
			luz = ImageIO.read(new File("./data/luz.png"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		for(boolean[] i : tablero.darTablero()) {
			x=0;
			for(boolean ii : i) {
				if (!ii) {
					g2D.setColor(Color.yellow);
					g2D.fillRoundRect(x, y, largo, alto, 40, 40);
					g2D.drawImage(luz, x+7, y+7, x+largo-10, y+largo-10, 0, 0,luz.getWidth(), luz.getWidth(), ventana);
				}else {
					g2D.setColor(Color.gray);
					g2D.fillRoundRect(x, y, largo, alto, 40, 40);
					g2D.drawImage(luz, x+7, y+7, x+largo-10, y+largo-10, 0, 0,luz.getWidth(), luz.getWidth(), ventana);
				}
				x+=largo+5;
			}
			y+=alto+5;
		}
		
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		
		int[] casillas = convertirCoordenadasACasilla(x, y);
		ArrayList<String> casillas1 = convertir(x,y);
		
		tablero.jugar(casillas[0], casillas[1]);
		
		ventana.setJugadas(tablero.darJugadas());
		ventana.setCuadros(casillas1);
		
		if(!tablero.tableroIluminado()) {
			repaint();
		}else {
			JDialog dialogo = new JDialog(ventana, "completado",true);
			dialogo.add(new JLabel("Felicitaciones"));
			dialogo.setSize(500, 150);
	        dialogo.setLocationRelativeTo(ventana);
	        dialogo.setVisible(true);
	        
	        ventana.actualizarTop(tablero.calcularPuntaje());
		}
	}
	
	private int[] convertirCoordenadasACasilla(int x, int y) {
        int ladoTablero = tablero.darTablero().length;
        int altoPanelTablero = getHeight();
        int anchoPanelTablero = getWidth();
        int altoCasilla = altoPanelTablero / ladoTablero;
        int anchoCasilla = anchoPanelTablero / ladoTablero;
        int fila = y / altoCasilla;
        int columna = x / anchoCasilla;
        return new int[] { fila, columna };
    }

    private ArrayList<String> convertir(int x, int y) {
        int ladoTablero = tablero.darTablero().length;
        int altoPanelTablero = getHeight();
        int anchoPanelTablero = getWidth();
        int altoCasilla = altoPanelTablero / ladoTablero;
        int anchoCasilla = anchoPanelTablero / ladoTablero;
        int fila = y / altoCasilla;
        int columna = x / anchoCasilla;
        String fila1 = Integer.toString(fila);
        String columna1 = Integer.toString(columna);
        ArrayList<String> parametros = new ArrayList<>();
        parametros.add(columna1);
        parametros.add(fila1);
        return parametros;
    }
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
