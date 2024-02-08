/**
 * Metodo main JuegoSieteYMedia
 * 
 * Contendrá el método main, donde se hace la lógica
 * del turno primero del jugador hasta que se plante o pierda y luego el
 * turno de la banca.
 * 
 * @author Alejandro Barrionuevo Rosado
 * @author Jose Molina Melendez //Jose poner ventana emergente :)
 */

public class JuegoSieteYMedia {
  public static void main(String[] args) {
    Baraja barajaESP = new Baraja();
    Jugador jugadorPro = new Jugador(1000, "Alejandro");
    Mano mano1 = new Mano();
    String nombre;

    // System.out.println("Jugador introduzca su nombre:");
    // nombre = System.console().readLine();

    barajaESP.inicializaBaraja(); // Inicializamos baraja
    barajaESP.barajar(); // Barajamos

    boolean salirBucle1 = false;
    do {
      mano1.setCartas(barajaESP.extraerCarta());
      mano1.setPuntuacionMano();
      mano1.mostrarPuntuacion();
      if (mano1.getContador() == 0) {
        mano1.setContador(); // Solo la primera vez despues no
      }

      System.out.println("Opcion 1. Pedir otra carta.  |  Opcion 2. Plantarse.");
      int opcion1 = Integer.parseInt(System.console().readLine());
      if (opcion1 == 1) {
        salirBucle1 = false;
      } else if (opcion1 == 2) {
        salirBucle1 = true;
        System.out.print("Te has plantado con ");
        mano1.mostrarPuntuacion();
      } else {
        System.out.println("Introduzca un valor correcto.");
      }

      if (mano1.getPuntuacionMano > 7.5) {
        salirBucle1 = true;
        System.out.println("¡Te has pasado!");
      }
    } while (!salirBucle1);

  }
}
