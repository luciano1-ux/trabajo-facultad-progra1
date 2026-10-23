package juego;

public class Pedido {
    // Casa que hace el pedido y negocio donde se retira
    private Casa casa;
    private Negocio negocio;
    // Estados del pedido: 0 realizado, 1 esperando, 2 en camino, 3 entregado, 4 perdido
    private int estado;
    private int inicio;
    private int limite;

    public Pedido(Casa casa, Negocio negocio, int inicio, int limite) {
        this.casa = casa;
        this.negocio = negocio;
        this.inicio = inicio;
        this.limite = limite;
        this.estado = 0;
    }

    public Casa getCasa() { return casa; }
    public Negocio getNegocio() { return negocio; }
    public int getEstado() { return estado; }

    public void empezarEspera() {
        if (estado == 0) { estado = 1; }
    }

    // Cuando retiramos el pedido pasa a estar en camino
    public void recoger() {
        if (estado == 1) { estado = 2; }
    }

    // Marcamos el pedido como entregado
    public void entregar() {
        if (estado == 2) { estado = 3; }
    }

    public void perder() {
        if (estado == 0 || estado == 1 || estado == 2) { estado = 4; }
    }

    public boolean termino() { return estado == 3 || estado == 4; }

    // Calculamos cuanto tiempo queda para hacer la entrega
    public int segundosRestantes(int tiempoActual) {
        int restante = limite - (tiempoActual - inicio) / 1000;
        if (restante < 0) { restante = 0; }
        return restante;
    }

    public String nombreEstado() {
        if (estado == 0) { return "Realizado"; }
        if (estado == 1) { return "Esperando"; }
        if (estado == 2) { return "En camino"; }
        if (estado == 3) { return "Entregado"; }
        return "Perdido";
    }
}
