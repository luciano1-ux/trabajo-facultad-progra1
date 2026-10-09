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
	
}
