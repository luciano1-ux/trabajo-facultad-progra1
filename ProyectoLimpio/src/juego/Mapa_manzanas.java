package juego;
import entorno.Entorno;

public class Mapa_manzanas {
    private Manzana[] manzanas = new Manzana[16];
    private Casa[] casas = new Casa[48];
    private Negocio[] negocios = new Negocio[16];

    public Mapa_manzanas() {
        int indice = 0;
        for (int vertical = 0; vertical < 4; vertical++) {
            for (int horizontal = 0; horizontal < 4; horizontal++) {
                int x = 100 + horizontal * 200;
                int y = 100 + vertical * 140;
                manzanas[indice] = new Manzana(x, y, 120, 90);
                negocios[indice] = new Negocio(x - 35, y - 18, 24, 24);
                casas[indice * 3] = new Casa(x + 35, y - 18, 22, 22);
                casas[indice * 3 + 1] = new Casa(x - 35, y + 20, 22, 22);
                casas[indice * 3 + 2] = new Casa(x + 35, y + 20, 22, 22);
                indice = indice + 1;
            }
        }
    }

    public void dibujar(Entorno entorno) {
        for (int i = 0; i < manzanas.length; i++) {
            manzanas[i].dibujar(entorno);
        }
        for (int i = 0; i < casas.length; i++) {
            casas[i].dibujar(entorno);
        }
        for (int i = 0; i < negocios.length; i++) {
            negocios[i].dibujar(entorno);
        }
    }

    public Casa[] getCasas() { return casas; }
    public Negocio[] getNegocios() { return negocios; }

    public boolean colicionaconManzanas(Jugador jugador) {
        for (int i = 0; i < manzanas.length; i++) {
            if (jugador.bordeIzquierdo() < manzanas[i].bordeDerechoM() &&
                jugador.bordeDerecho() > manzanas[i].bordeIzquierdoM() &&
                jugador.bordeSuperior() < manzanas[i].bordeInferiorM() &&
                jugador.bordeInferior() > manzanas[i].bordeSuperiorM()) {
                return true;
            }
        }
        return false;
    }
}
