package juego;

import java.awt.Color;

import entorno.Entorno;

public class Jugador {
	
	private int x;
	private int y;
	private int ancho;
	private int alto;
	
	
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
	
	//MOVIMIENTO
	public void moverDerecha() {
		this.x=this.x+6;
	}
	
	public void moverIzquierda() {
		this.x=this.x-6;
	}
	
	public void moverArriba() {
		this.y=this.y-6;
	}
	
	public void moverAbajo() {
		this.y=this.y+6;
	}

	
	
	//BORDES DE PANTALLA
	
	
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//getters setters
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
