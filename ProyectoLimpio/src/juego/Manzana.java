package juego;

import java.awt.Color;

import entorno.Entorno;

public class Manzana {
	private int x;
	private int y;
	private int ancho;
	private int alto;
	
	
	public Manzana(int x, int y, int ancho , int alto) {
		this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.alto=alto;
	}
	
	
	public void dibujar(Entorno entorno) {
	    entorno.dibujarRectangulo(
	        this.x, this.y, this.ancho, this.alto, 0, Color.green
	    );
	}
	
	
	//borde de manzanas

	public int bordeDerechoM() {
		return this.x + this.ancho / 2;
		}

		public int bordeIzquierdoM() {
		return this.x - this.ancho / 2;
		}

		public int bordeSuperiorM() {
		return this.y - this.alto / 2;
		}

		public int bordeInferiorM() {
		return this.y + this.alto / 2;
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
