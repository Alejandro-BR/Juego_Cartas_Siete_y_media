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

public class Baraja {

  //////// ATRIBUTOS
  private String[] palos = { "Oros", "Copas", "Espadas", "Bastos" }; // Oros, Copas, Espadas y Bastos.
  private String[] valores = { "1", "2", "3", "4", "5", "6", "7", "Sota", "Caballo", "Rey" }; // 1, 2, 3, 4, 5, 6, 7, Sota, Caballo y Rey.
  private Carta[] cartas;
  private int numCartas;

  //////// CONSTRUCTORES
  public Baraja() { // La baraja contiene 40 cartas multiplicando el palo por valor.
    numCartas = palos.length * valores.length;
    cartas = new Carta[numCartas];
  }

  //////// METODOS
  /**
   * inicializaBaraja
   * 
   * Inicializar la baraja
   */
  public void inicializaBaraja() {
    int index = 0;
    for (int i = 0; i < palos.length; i++) {
      for (int j = 0; j < valores.length; j++) {
        cartas[index] = new Carta(palos[i], valores[j]);
        cartas[index].setPuntuacion(); // Le damos valor con la funcion .darPuntuacion()
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
   * 40 * carta.toString()
   */
  public void getBaraja() {
    for (int i = 0; i < cartas.length; i++) {
      System.out.printf("%-20s PUNTUACION: %1.2f\n",cartas[i].toString(), cartas[i].getPuntuacion());
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

}
