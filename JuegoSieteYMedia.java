/**
 * Metodo main JuegoSieteYMedia
 * 
 * Contendrá el método main, donde se hace la lógica
 * del turno primero del jugador hasta que se plante o pierda y luego el
 * turno de la banca.
 * 
 * @author Alejandro Barrionuevo Rosado
 * @author Jose Molina Melendez  //Jose poner ventana emergente :)
 */

public class JuegoSieteYMedia {
  public static void main(String[] args) {
    Baraja barajaESP = new Baraja();
    Jugador jugadorPro = new Jugador(1000, "Alejandro");
    Mano mano1 = new Mano();

    barajaESP.inicializaBaraja();
    // barajaESP.getBaraja();
    barajaESP.barajar();
    // barajaESP.getBaraja();

    mano1.setCartas(barajaESP.extraerCarta());
    mano1.setPuntuacionMano();
    mano1.mostrarPuntuacion();
    if (mano1.getContador() == 0) {
      mano1.setContador();  //Solo la primera vez despues no
    }

    System.out.println();
    mano1.setCartas(barajaESP.extraerCarta());
    mano1.setPuntuacionMano();
    mano1.mostrarPuntuacion();

  }
}
