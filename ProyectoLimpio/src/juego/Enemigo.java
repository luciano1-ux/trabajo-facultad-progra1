package juego;

import java.awt.Color;

import entorno.Entorno;

public class Enemigo {
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private int direccion;
	
	
	public Enemigo(int x, int y, int ancho, int alto, int direccion) {
		this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.alto=alto;
		this.direccion=direccion;
		
	}
		
	public void dibujar(Entorno e) {
		e.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0 ,Color.red);;
	}
	
	//movimiento
	
	public void moverEnemigoDerecha() {
		this.x=this.x+5;
	}
	
	public void moverEnemigoIzquierda() {
		this.x=this.x-3;
	}
	
	public void moverEnemigoArriba() {
		this.y=this.y-7;
	}
	
	public void moverEnemigoAbajo() {
		this.y=this.y+5;
	}
	
	
	
	//rebote con pantalla
	
	public void rebotarEnBordes() {
        if (bordeDerecho() >= 800 && direccion == 0) {
            direccion = 1;
        }

        if (bordeIzquierdo() <= 0 && direccion == 1) {
            direccion = 0;
        }

        if (bordeInferior() >= 600 && direccion == 2) {
            direccion = 3;
        }

        if (bordeSuperior() <= 0 && direccion == 3) {
            direccion = 2;
        }
    }
	
	
	

public void mover() {
    rebotarEnBordes();

    if (direccion == 0) {
        moverEnemigoDerecha();
    } else if (direccion == 1) {
        moverEnemigoIzquierda();
    } else if (direccion == 2) {
        moverEnemigoAbajo();
    } else if (direccion == 3) {
        moverEnemigoArriba();
    }
}

	
	
	// hitbox
	
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
