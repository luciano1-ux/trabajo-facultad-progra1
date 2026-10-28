package juego;

import java.awt.Color;
import entorno.Entorno;

public class Proyectil {
    private int x;
    private int y;
    private int direccion;
    private int tamanio;

    public Proyectil(int x, int y, int direccion) {
        this.x = x;
        this.y = y;
        this.direccion = direccion;
        this.tamanio = 8;
    }

    // La bala conserva la direccion en la que fue disparada.
    public void mover() {
        if (direccion == 0) {
            x = x + 10;
        } else if (direccion == 1) {
            x = x - 10;
        } else if (direccion == 2) {
            y = y - 10;
        } else {
            y = y + 10;
        }
    }

    public void dibujar(Entorno entorno) {
        entorno.dibujarCirculo(x, y, tamanio, Color.YELLOW);
    }

    public boolean fueraDelMapa(int ancho, int alto) {
        return x < 0 || x > ancho || y < 0 || y > alto;
    }

    // Comprueba si la bala toca el rectangulo del enemigo.
    public boolean chocaCon(Enemigo enemigo) {
        return x + tamanio / 2 > enemigo.bordeIzquierdo() &&
               x - tamanio / 2 < enemigo.bordeDerecho() &&
               y + tamanio / 2 > enemigo.bordeSuperior() &&
               y - tamanio / 2 < enemigo.bordeInferior();
    }
}
