/**
 * Clase Carta
 * 
 * Gestiona el palo y número asignado y también un método que te
 * diga la puntuación de esa carta.
 * 
 * Se utiliza la baraja de cartas española de 4 palos y 10 cartas por cada palo.
 * 
 * Palos: Oros, Copas, Espadas y Bastos
 * 
 * Cada Palo tiene 10 cartas numeradas de la siguiente manera:
 * 1, 2, 3, 4, 5, 6, 7, Sota, Caballo y Rey
 * 
 * @author Alejandro Barrionuevo Rosado
 * @author Jose Molina Melendez
 */

public class Carta {

  //////// Atributos
  private String palos; // Oros, Copas, Espadas y Bastos.
  private String valores; // 1, 2, 3, 4, 5, 6, 7, Sota(8), Caballo(9) y Rey(10).
  private double puntuacion; // Los numeros tienen su numero como puntuacion y Sota, Caballo y rey medio punto.

  //////// Constructores
  /**
   * Contructor de la clase Carta
   * 
   * @param palos
   * @param valores
   * @param puntuacion
   */
  public Carta(String palos, String valores, double puntuacion) {
    this.palos = palos;
    this.valores = valores;
    // this.puntuacion = darpuntuacion(puntuacion);
    this.puntuacion = puntuacion;
  }

  //////// Mertodos

  public void darPuntuacion() {
    switch (this.valores) {
      case "1":
        this.puntuacion = 1.0;
        break;
      case "2":
        this.puntuacion = 2.0;
        break;
      case "3":
        this.puntuacion = 3.0;
        break;
      case "4":
        this.puntuacion = 4.0;
        break;
      case "5":
        this.puntuacion = 5.0;
        break;
      case "6":
        this.puntuacion = 6.0;
        break;
      case "7":
        this.puntuacion = 7.0;
        break;
      default: //Sota, Caballo y Rey
        this.puntuacion = 0.5;
        break;
    }
  }

  /**
   * 
   * @return palos
   */
  public String getPalos() {
    return palos;
  }

  /**
   * 
   * @return valores
   */
  public String getValores() {
    return valores;
  }

  /**
   * 
   * @return puntuacion
   */
  public double getPuntuacion() {
    return puntuacion;
  }

}
