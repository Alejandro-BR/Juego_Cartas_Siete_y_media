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
    barajaESP.inicializaBaraja();
    barajaESP.getBaraja();
  }
}
