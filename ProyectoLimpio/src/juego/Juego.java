package juego;


import java.awt.Color;

import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	// ESTO ES UN PRUEBA
	// Variables y métodos propios de cada grupo
	// ...
	Jugador jugador;
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Proyecto para TP", 800, 600);
		
		jugador = new Jugador(400, 500, 30, 30);

		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		// Procesamiento de un instante de tiempo
		// ...
		jugador.dibujar(entorno);
		
		if(entorno.estaPresionada('w') && jugador.bordeSuperior()> 0) {
			jugador.moverArriba();
		}
		
		if(entorno.estaPresionada('a') && jugador.bordeIzquierdo() > 0) {
			jugador.moverIzquierda();
		}
		
		if(entorno.estaPresionada('d') && jugador.bordeDerecho() < entorno.ancho()) {
			jugador.moverDerecha();
		}
		
		if(entorno.estaPresionada('s') && jugador.bordeInferior() < entorno.alto()) {
			jugador.moverAbajo();
		}
	}
	

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
