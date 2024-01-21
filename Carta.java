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
  private String palo; // Oros, Copas, Espadas y Bastos.
  private String numero; // 1, 2, 3, 4, 5, 6, 7, Sota(8), Caballo(9) y Rey(10).
  private double valor; // Los numeros tienen su numero como valor y Sota, Caballo y rey medio punto.

  //////// Constructores
  public void Carta() {
    String[] palos = {"Oros", "Copas", "Espadas", "Bastos"};
    String[] numeros = {"1", "2", "3", "4","5", "6", "7", "Sota", "Caballo", "Rey"};
    double[] valor = {0.5,1,2,3,4,5,6,7};

    
  }

  //////// Mertodos

}
