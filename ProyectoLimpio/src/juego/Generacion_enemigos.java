package juego;
import java.util.Random;

import entorno.Entorno;

import java.awt.Point;

public class Generacion_enemigos {
	private Enemigo[] enemigo = new Enemigo[4];
	
	private Point[] puntosSpawn = {
	        new Point(20, 30),
	        new Point(210, 30),
	        new Point(410, 30),
	        new Point(600, 30),
	        new Point(785, 30),
	        new Point(785, 165),
	        new Point(785, 310),
	        new Point(785, 450),
	        new Point(785, 580),
	        new Point(600, 580),
	        new Point(410, 580),
	        new Point(210, 580),
	        new Point(20, 580),
	        new Point(20, 450),
	        new Point(20, 310),
	        new Point(20, 165)
	    };
	
	private Random random = new Random();
	boolean[]posicionesusadas = new boolean[puntosSpawn.length];
	
	public Generacion_enemigos() {

	    for (int i = 0; i < enemigo.length; i++) {

	        int indiceAleatorio = random.nextInt(puntosSpawn.length);

	        while (posicionesusadas[indiceAleatorio]) {
	            indiceAleatorio = random.nextInt(puntosSpawn.length);
	        }

	        posicionesusadas[indiceAleatorio] = true;

	        int direccion = random.nextInt(4);

	        Point punto = puntosSpawn[indiceAleatorio];

	        enemigo[i] = new Enemigo(
	            punto.x, punto.y, 20, 20, direccion
	        );
	    }
	}
	    
	public void dibujar(Entorno entorno) {
	    for (int i = 0; i < enemigo.length; i++) {
	        if (enemigo[i] != null) {
	            enemigo[i].dibujar(entorno);
	        }
	    }
	}
	        

public void moverenemigos() {
    for (int i = 0; i < enemigo.length; i++) {
        if (enemigo[i] != null) {
            enemigo[i].mover();
        }
    }
}

	    
	    //comprueba colisiones

public void comprobarColisiones(Jugador jugador) {
    for (int i = 0; i < enemigo.length; i++) {

        if (enemigo[i] != null) {
            if (jugador.perdervida(enemigo[i])) {

                // Generar un enemigo nuevo
                int indiceAleatorio = random.nextInt(puntosSpawn.length);
                int direccion = random.nextInt(4);

                Point punto = puntosSpawn[indiceAleatorio];

                enemigo[i] = new Enemigo(
                    punto.x, punto.y, 20, 20, direccion
                );
            }
        }
    }
}


}

	


