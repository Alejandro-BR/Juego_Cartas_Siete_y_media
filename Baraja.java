/**
 * Clase Baraja
 * 
 * Contiene un conjunto (array) de cartas, incluyendo todos los
 * palos y valores posibles. Debe contener los métodos de barajar las
 * cartas y repartir una carta.
 * 
 * @author Alejandro Barrionuevo Rosado
 * @author Jose Molina Melendez
 */

// Palos
// valores o valores
// valores de cartas en total seran 40 cartas
// Una array de la clase carta
// Un array de 40 cartas
// Inicializar el numero de cartas
// Inicializar la baraja (crear la baraja)
// Extraer la carta

public class Baraja {

  //////// ATRIBUTOS
  private String[] palos = { "Oros", "Copas", "Espadas", "Bastos" }; // Oros, Copas, Espadas y Bastos.
  private String[] valores = { "1", "2", "3", "4", "5", "6", "7", "Sota", "Caballo", "Rey" }; // 1, 2, 3, 4, 5, 6, 7, Sota(8), Caballo(9) y Rey(10).
  private Carta[] cartas;
  private int numCartas;

  //////// CONSTRUCTORES
  public Baraja() { // La baraja contiene 40 cartas multiplicando el palo por valor.
    Carta[] cartas = new Carta[palos.length * valores.length];
    numCartas = palos.length * valores.length;
    // inicializarCartas();
  }

  //////// METODOS
  public void inicializarCartas() {
    int index = 0;
    for (int i = 0; i < cartas.length; i++) {
      for (int j = 0; j < cartas.length; j++) {
        cartas[index] = new Carta(palos[i], valores[j], 0);
        cartas[index].darPuntuacion(); // Le damos valor con la funcion .darPuntuacion()
        index++;
      }
    }
  }
  /**
  * BARAJAR
  */
  public void barajar() {
    for (int i = 0; i < cartas.length; i++) {
      int aleatorio = (int) (Math.random()*cartas.length); //Sumamos 1 para que el total sea 41.
      Carta aux = cartas[i];
      cartas[i] = cartas[aleatorio];
      cartas[aleatorio] = aux;
    }
  }

  /**
   * EXTRAER CARTA
   * @return cartaExtraida
   */
  public Carta extraerCarta() {
    Carta cartaExtraida = null;
    if (numCartas == 0) {
      System.out.println("La baraja esta vacia.");
    } else {
      numCartas--;
      cartaExtraida = cartas[numCartas];    //Cojemos ultima posicion de la baraja
      cartas[numCartas] = null;             //Limpiamos la carta de la baraja
      System.out.println("Carta extraida: " + cartaExtraida.toString());
    }
    return cartaExtraida; 
  }

  /**
   * GET BARAJA
   */
  public void getBaraja() {
    for (int i = 0; i < cartas.length; i++) {
      System.out.printf("%-15s Puntuación: %-3.1f\n", cartas[i], cartas[i].getPuntuacion());
    }
  }

  /**
   * 
   * @return palos
   */
  public String[] getPalos() {
    return palos;
  }

  /**
   * 
   * @return valores
   */
  public String[] getValores() {
    return valores;
  }

  /**
   * 
   * @return cartas
   */
  public Carta[] getCartas() {
    return cartas;
  }

  public static void main(String[] args) {
    Baraja barajita = new Baraja();
    Carta carta = new Carta();
    
    barajita.inicializarCartas();
    barajita.barajar();
    carta = barajita.extraerCarta();
    barajita.getBaraja();
  }
}
