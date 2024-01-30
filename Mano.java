/**
 * Clase Mano
 * 
 * Contendría los métodos de añadir una carta a la mano del
 * jugador y de calcular la puntuación de la mano del jugador.
 * 
 * @author Alejandro Barrionuevo Rosado
 * @author Jose Molina Melendez
 */

public class Mano {

  //////// Atributos
  private Carta[] cartas; // Array de cartas
  private double puntuacionMano; // Puntuacion de la mano
  private int contador; // Variable auxiliar

  //////// Constructores
  /**
   * Contructor de la clase Mano
   * 
   * @param cartas Objeto Carta
   */
  public Mano(Carta cartas) {
    this.contador = 0;
    this.cartas[contador] = cartas;
    setContador();
    this.puntuacionMano = 0;
  }

  //////// Mertodos

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


  public void setPuntuacionMano() {
    for (int i = 0; i < cartas.length; i++) {
      puntuacionMano += cartas[i].setPuntuacion();
    }
  }

  /**
   * Añadir una nueva Carta a la mano
   * 
   * @param cartas Objeto Carta
   */
  public void setCartas(Carta cartas) {
    this.cartas[contador] = cartas;
    setContador();
  }

  

}
