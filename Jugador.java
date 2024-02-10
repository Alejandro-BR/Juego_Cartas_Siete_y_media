/**
 * Clase Jugador
 * 
 * Gestiona las cartas o mano que tiene un jugador, el saldo y
 * la apuesta que realiza. Tendrás que implementar una serie de métodos
 * para obtener la puntuación de su mano, otro para recibir una carta de
 * la baraja, realizar apuesta...
 * 
 * La puntuacion de la mano y todo lo referente a la mano se creara en la clase
 * Mano.
 * 
 * @author Alejandro Barrionuevo Rosado
 * @author Jose Molina Melendez
 */

public class Jugador {

  //////// Atributos
  private int saldo; // Saldo que tiene el jugador
  private int apuesta; // Apuesta del jugador
  private String nombre; // Nombre del jugador

  //////// Constructores
  /**
   * Contructor de la clase Jugador
   * 
   * @param saldo   int
   * @param apuesta int
   * @param nombre  String
   */
  public Jugador(int saldo, String nombre) {
    this.saldo = saldo;
    this.nombre = nombre;
  }

  //////// Metodos

  /**
   * Get Saldo
   * 
   * @return int
   */
  public int getSaldo() {
    return saldo;
  }

  /**
   * Get apuesta
   * 
   * @return int
   */
  public int getApuesta() {
    return apuesta;
  }

  /**
   * Get Nombre
   * 
   * @return String
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Cambiar el valor del atributo apuesta
   * 
   * @param apuesta int
   */
  public void setApuesta(int apuesta) {
    if (apuesta > saldo) {
      System.out.println("\nNo dispones de ese saldo.");
      do {
        System.out.print("Introduce una nueva apuesta porfavor: ");
        apuesta = Integer.parseInt(System.console().readLine());
      } while (apuesta > saldo);
    }
    
    this.apuesta = apuesta;
  }

  /**
   * Cambiar el valor del atributo saldo
   * 
   * ganar --> suma
   * perder --> resta
   * 
   * @param ganarRonda boolean
   */
  public void setSaldo(boolean ganarRonda) {
    if (ganarRonda) {
      this.saldo += this.apuesta;
    } else {
      this.saldo -= this.apuesta;
    }
  }


}
