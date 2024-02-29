/**
 * Clase Mano
 * 
 * Gestiona las cartas o mano que tiene un jugador y la banca, contendría los métodos de añadir
 * una carta a la mano del jugador y de calcular la puntuación de la mano del jugador.
 * 
 * @author Alejandro Barrionuevo Rosado
 * @author Jose Molina Melendez
 */

public class Mano {

  //////// Atributos
  private Carta[] cartas = new Carta[15]; // Array de cartas con un maximo de 15
  // Suponiendo que siempre te salga una carta de 0,5 necesitarias 15 cartas para
  // llegar al 7,5 por lo que ese sera el numero maximo
  private double puntuacionMano; // Puntuacion de la mano
  private int contador; // Variable auxiliar

  //////// Constructor
  public Mano() { // Cartas carta
    this.contador = 0;
    this.puntuacionMano = 0;
  }

  //////// Metodos

  /**
   * Aumentar la variable auxiliar
   */
  public void setContador() {
    this.contador += 1;
  }

  /**
   * Obtener el atributo Carta
   * 
   * @return Cartas
   */
  public Carta[] getCartas() {
    return cartas;
  }

  /**
   * Obtener el atributo de la puntuacion
   * 
   * @return double
   */
  public double getPuntuacionMano() {
    return puntuacionMano;
  }

  /**
   * Añadir una nueva Carta a la mano
   * 
   * @param cartas Objeto Carta
   */
  public void setCartas(Carta cartas) {
    if (contador != 0) {
      setContador();
    }
    this.cartas[contador] = cartas;
  }

  /**
   * Aumentar la puntuacion de la mano
   */
  public void setPuntuacionMano() {
    this.puntuacionMano += cartas[contador].getPuntuacion();
  }

  /**
   * Mostrar la puntuacion
   */
  public void mostrarPuntuacion() {
    System.out.println("Puntuacion de la mano: " + puntuacionMano);
  }

  /**
   * Saber cuantas cartas tenemos en la mano.
   * 
   * @return int
   */
  public int getContador() {
    return contador;
  }

  /**
   * Resetear la mano
   */
  public void reset() {
    this.contador = 0;
    this.puntuacionMano = 0;
    for (int i = 0; i < cartas.length; i++) {
      this.cartas[i] = null;
    }
  }
}
