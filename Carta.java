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
  private String numeros; // 1, 2, 3, 4, 5, 6, 7, Sota(8), Caballo(9) y Rey(10).
  private double valor; // Los numeros tienen su numero como valor y Sota, Caballo y rey medio punto.

  //////// Constructores
  public Carta(String palos, String numeros, double valor) {
    this.palos = palos;
    this.numeros = numeros;
    // this.valor = darValor(valor);
    this.valor = valor;
  }

  //////// Mertodos
  public void darValor() {
    switch (this.numeros) {
      case "1":
        this.valor = 1.0;
        break;
      case "2":
        this.valor = 2.0;
        break;
      case "3":
        this.valor = 3.0;
        break;
      case "4":
        this.valor = 4.0;
        break;
      case "5":
        this.valor = 5.0;
        break;
      case "6":
        this.valor = 6.0;
        break;
      case "7":
        this.valor = 7.0;
        break;
      default:
        this.valor = 0.5;
        break;
    }
  }
}
