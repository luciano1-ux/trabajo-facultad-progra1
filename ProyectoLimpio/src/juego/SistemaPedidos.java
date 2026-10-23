package juego;

import java.awt.Color;
import java.util.Random;
import entorno.Entorno;

public class SistemaPedidos {
    // Guardamos las casas y los negocios que pueden participar en los pedidos
    private Casa[] casas;
    private Negocio[] negocios;
    private Random azar;
    // Pedido que se esta realizando en este momento
    private Pedido pedido;
    private int entregados;
    private int perdidos;
    private int ultimoFinalizado;
    private int tiempoLimite;

    public SistemaPedidos(Casa[] casas, Negocio[] negocios, int tiempoLimite) {
        this.casas = casas;
        this.negocios = negocios;
        this.tiempoLimite = tiempoLimite;
        this.azar = new Random();
        this.pedido = null;
        this.entregados = 0;
        this.perdidos = 0;
        this.ultimoFinalizado = 0;
    }

    // Elegimos una casa y un negocio al azar para crear un pedido
    private void crearPedido(int tiempoActual) {
        int indiceCasa = azar.nextInt(casas.length);
        int indiceNegocio = azar.nextInt(negocios.length);
        pedido = new Pedido(casas[indiceCasa], negocios[indiceNegocio], tiempoActual, tiempoLimite);
    }

    // Revisamos el estado del pedido y los clics del jugador
    public void actualizar(Entorno entorno, Jugador jugador) {
        int ahora = entorno.tiempo();
        if (pedido == null) {
            crearPedido(ahora);
            return;
        }
        if (pedido.termino()) {
            if (ahora - ultimoFinalizado >= 1000) {
                crearPedido(ahora);
            }
            return;
        }
        if (pedido.getEstado() == 0) {
            pedido.empezarEspera();
        }
        // Si se termina el tiempo, el pedido se pierde
        if (pedido.segundosRestantes(ahora) == 0) {
            perderPedido(ahora);
            return;
        }
        if (entorno.sePresionoBoton(entorno.BOTON_DERECHO)) {
            // Si el pedido esta esperando, comprobamos si lo podemos retirar
            if (pedido.getEstado() == 1) {
                Negocio negocio = pedido.getNegocio();
                int flechaX = posicionFlechaX(negocio.getX());
                if (jugadorCerca(jugador, flechaX, negocio.getY()) &&
                    clicEnEdificio(entorno, negocio.getX(), negocio.getY(), negocio.getAncho(), negocio.getAlto())) {
                    pedido.recoger();
                }
            // Si ya lo retiramos, comprobamos si llegamos a la casa
            } else if (pedido.getEstado() == 2) {
                Casa casa = pedido.getCasa();
                int flechaX = posicionFlechaX(casa.getX());
                if (jugadorCerca(jugador, flechaX, casa.getY()) &&
                    clicEnEdificio(entorno, casa.getX(), casa.getY(), casa.getAncho(), casa.getAlto())) {
                    pedido.entregar();
                    entregados = entregados + 1;
                    ultimoFinalizado = ahora;
                }
            }
        }
    }

    // Ubicamos la flecha en la calle, al lado del edificio
    private int posicionFlechaX(int edificioX) {
        int columna = edificioX / 200;
        int centroManzana = 100 + columna * 200;
        if (edificioX < centroManzana) {
            return centroManzana - 75;
        }
        return centroManzana + 75;
    }

    // Comprobamos que el jugador este cerca de la flecha
    private boolean jugadorCerca(Jugador jugador, int x, int y) {
        int diferenciaX = jugador.getX() - x;
        int diferenciaY = jugador.getY() - y;
        return diferenciaX * diferenciaX + diferenciaY * diferenciaY <= 25 * 25;
    }

    // Comprobamos que el clic haya sido sobre el edificio
    private boolean clicEnEdificio(Entorno entorno, int x, int y, int ancho, int alto) {
        return entorno.mouseX() >= x - ancho / 2 &&
               entorno.mouseX() <= x + ancho / 2 &&
               entorno.mouseY() >= y - alto / 2 &&
               entorno.mouseY() <= y + alto / 2;
    }

    private void perderPedido(int ahora) {
        if (pedido != null && !pedido.termino()) {
            pedido.perder();
            perdidos = perdidos + 1;
            ultimoFinalizado = ahora;
        }
    }

    public void perderPorChoque(int ahora) {
        perderPedido(ahora);
    }

    // Mostramos la flecha amarilla para retirar o roja para entregar
    public void dibujar(Entorno entorno) {
        if (pedido == null) { return; }
        if (pedido.getEstado() == 1) {
            Negocio negocio = pedido.getNegocio();
            dibujarFlecha(entorno, posicionFlechaX(negocio.getX()), negocio.getY(), Color.YELLOW);
        } else if (pedido.getEstado() == 2) {
            Casa casa = pedido.getCasa();
            dibujarFlecha(entorno, posicionFlechaX(casa.getX()), casa.getY(), Color.RED);
        }
    }

    private void dibujarFlecha(Entorno entorno, int x, int y, Color color) {
        entorno.dibujarRectangulo(x, y - 7, 6, 14, 0, color);
        entorno.dibujarTriangulo(x, y + 5, 18, 18, 0, color);
    }

    public void dibujarHUD(Entorno entorno) {
        if (pedido != null) {
            entorno.escribirTexto("Pedido: " + pedido.nombreEstado(), 160, 17);
            entorno.escribirTexto("Tiempo pedido: " + pedido.segundosRestantes(entorno.tiempo()) + "s", 340, 17);
        }
        entorno.escribirTexto("Entregados: " + entregados + "  Perdidos: " + perdidos, 520, 17);
    }

    public int getEntregados() { return entregados; }
    public int getPerdidos() { return perdidos; }
}
