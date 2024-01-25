public class JuegoSieteYMedia {
  public static void main(String[] args) {
    Baraja barajita = new Baraja();
    Carta carta = new Carta("oro", "1");
    barajita.inicializarCartas();
    barajita.barajar();
    carta = barajita.extraerCarta();
    barajita.getBaraja();
  }
}
