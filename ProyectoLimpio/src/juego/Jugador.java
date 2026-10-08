package juego;

import java.awt.Color;

import entorno.Entorno;

public class Jugador {
	
	int x;
	int y;
	int ancho;
	int alto;
	
	
	public Jugador(int x, int y, int ancho, int alto) {
		super();
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
	}
	
	public void dibujar(Entorno p) {
		p.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0 ,Color.blue);;
	}
	
	
	public void moverDerecha() {
		this.x=this.x-6;
	}
	
	public void moverIzquierda() {
		this.x=this.x+6;
	}
	
	public void moverArriba() {
		this.y=this.y-6;
	}
	
	public void moverAbajo() {
		this.y=this.y+6;
	}
	
	

}
