package juego;
import entorno.Entorno;

public class Mapa_manzanas {
	private Manzana[] manzanas = new Manzana[16];
	
	
	public Mapa_manzanas() {
	    int indice = 0;

	    for (int vertical = 0; vertical < 4; vertical++) {
	        for (int horizontal = 0; horizontal < 4; horizontal++) {

	            int x = 100 + horizontal * 200;
	            int y = 100 + vertical * 140;

	            manzanas[indice] = new Manzana(x, y, 120, 90);

	            indice++;
	        }
	    }
	}
	
	public void dibujar(Entorno entorno) {
	    for (int i = 0; i < manzanas.length; i++) {
	        manzanas[i].dibujar(entorno);
	    }
	}

	//colicion con manzanas
	
	public boolean colicionaconManzanas(Jugador jugador) {

	    for (int i = 0; i < manzanas.length; i++) {

	        if (jugador.bordeIzquierdo() < manzanas[i].bordeDerechoM() && jugador.bordeDerecho() > manzanas[i].bordeIzquierdoM()  &&  jugador.bordeSuperior() < manzanas[i].bordeInferiorM() && jugador.bordeInferior() > manzanas[i].bordeSuperiorM()) {
	        	return true;
	        }
	    }

	    return false;
	}
}