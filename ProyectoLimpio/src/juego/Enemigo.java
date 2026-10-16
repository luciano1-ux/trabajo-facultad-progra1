package juego;

import java.awt.Color;

import entorno.Entorno;

public class Enemigo {
	private int x;
	private int y;
	private int ancho;
	private int alto;
	
	
	public Enemigo(int x, int y, int ancho, int alto) {
		this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.alto=alto;
		
	}
		
	public void dibujar(Entorno e) {
		e.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0 ,Color.red);;
	}
	
	//movimiento
	
	public void moverEnemigoDerecha() {
		this.x=this.x+6;
	}
	
	public void moverEnemigoIzquierda() {
		this.x=this.x-6;
	}
	
	public void moverEnemigoArriba() {
		this.y=this.y-6;
	}
	
	public void moverEnemigoAbajo() {
		this.y=this.y+6;
	}
	
	
	// colision con la pantalla
	
	public int bordeDerecho() {
	    return this.x + this.ancho / 2;
	    }

	public int bordeIzquierdo() {
	return this.x - this.ancho /2;
	}

	public int bordeSuperior() {
	return this.y - this.alto/2;
	}

	public int bordeInferior() {
	return this.y + this.alto/2;
	}
	

}
