package juego;

import entorno.Entorno;

public class Mapa_manzanas {
	private Manzana[] manzanas = new Manzana[16];
	
	
	public Mapa_manzanas() {
	    int indice = 0;

	    for (int fila = 0; fila < 4; fila++) {
	        for (int columna = 0; columna < 4; columna++) {

	            int x = 100 + columna * 200;
	            int y = 100 + fila * 140;

	            manzanas[indice] = new Manzana(x, y, 140, 100);

	            indice++;
	        }
	    }
	}
	
	public void dibujar(Entorno entorno) {
	    for (int i = 0; i < manzanas.length; i++) {
	        manzanas[i].dibujar(entorno);
	    }
	}
}
