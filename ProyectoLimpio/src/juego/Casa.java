package juego;

import java.awt.Color;

import entorno.Entorno;

public class Casa {
	private int x;
	private int y;
	private int ancho;
	private int alto;
	

	
	public Casa(int x ,int y ,int ancho ,int alto) {
		this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.alto=alto;
	}
	
	public void dibujar(Entorno c) {
		c.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0 ,Color.blue);;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}
	
	
	
	
	
	

}
