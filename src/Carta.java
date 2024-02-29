/**
 * Clase Carta
 * 
 * Gestiona el palo y valor asignado, ademas de la puntuatuacion.
 * 
 * @author Alejandro Barrionuevo Rosado
 * @author Jose Molina Melendez
 */

public class Carta {

  //////// Atributos
  private String palos; // Oros, Copas, Espadas y Bastos.
  private String valores; // 1, 2, 3, 4, 5, 6, 7, Sota, Caballo y Rey.
  private double puntuacion; // Los numeros tienen su numero como puntuacion y Sota, Caballo y rey medio punto.

  //////// Constructores
  /**
   * Contructor de la clase Carta
   * 
   * @param palos String
   * @param valores String
   */
  public Carta(String palos, String valores) {
    this.palos = palos;
    this.valores = valores;
  }

  //////// Metodos

  /**
   * Asignar la puntuacion de la carta segun su valor.
   */
  public void setPuntuacion() {
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
   * Obtener la puntuacion
   * 
   * @return double puntuacion
   */
  public double getPuntuacion() {
    return puntuacion;
  }

  /**
   * Simbolo de los palos
   * 
   * @return String simbolo
   */
  private String simbolo(){
    switch (this.palos) {
      case "Oros":
        return "\uD83E\uDD47";
      case "Copas":
        return "🏆";
      case "Espadas":
        return "⚔️";
      case "Bastos":
        return "🌳";
      default:
        return palos;
    }
  }

  /**
   * toString
   */
  @Override
  public String toString() {
    return String.format("%s de %s", this.valores, simbolo());
  }
}
