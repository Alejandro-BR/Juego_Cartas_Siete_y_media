/**
 * Metodo main JuegoSieteYMedia
 * 
 * Contendrá el método main, donde se hace la lógica
 * del turno primero del jugador hasta que se plante o pierda y luego el
 * turno de la banca.
 * 
 * @author Alejandro Barrionuevo Rosado
 * @author Jose Molina Melendez 
 */

import java.util.InputMismatchException;

public class JuegoSieteYMedia {

  /**
   * Animacion de barajar
   */
  private static void barajando() {
    System.out.print("\nBarajando: ");
    try {
      for (int i = 0; i < 10; i++) {
        System.out.print("🂠");
        Thread.sleep(500); // Esto es para aumentar el tiempo que tarda
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("\n");
  }

  /**
   * Borrar la pantalla del terminal
   */
  private static void limpiar() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  /**
   * Mostrar si pedir otra carta o plantarse
   * 
   * @return String
   */
  private static String menu() {
    return "╔══════════════════════════════════════════╗\n" +
        "║  Opción 1: Pedir otra carta.             ║\n" +
        "║  Opción 2: Plantarse.                    ║\n" +
        "╚══════════════════════════════════════════╝\n";
  }

  /**
   * Mostrar una portada
   */
  private static void portada() {
    limpiar();
    // Pintamos la portada
    System.out.println("\n╔══════════════════════════════════════════════════╗");
    System.out.println("║\033[34m              BIENVENIDO AL JUEGO DE              \033[0m║");
    System.out.println("║\033[34m                 LA SIETE Y MEDIA                 \033[0m║");
    System.out.println("╚══════════════════════════════════════════════════╝\n");
    System.out.println("                             _____");
    System.out.println(" _____                _____ |6    |");
    System.out.println("|2    | _____        |5    || o o | ");
    System.out.println("|  o  ||3    | _____ | o o || o o | _____");
    System.out.println("|     || o o ||4    ||  o  || o o ||7    |");
    System.out.println("|  o  ||     || o o || o o ||____9|| o o | _____");
    System.out.println("|____Z||  o  ||     ||____S|       |o o o||8    | _____");
    System.out.println("       |____E|| o o |              | o o ||o o o||9    |");
    System.out.println("              |____h|              |____L|| o o ||o o o|");
    System.out.println("                                          |o o o||o o o|");
    System.out.println("                                          |____8||o o o|");
    System.out.println("                                                 |____6|\n");

    try {
      Thread.sleep(500); // Retardo
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   * Mostrar los creditos
   */
  private static void creditos() {
    limpiar();
    // Pintamos los creditos
    System.out.println("\n  ╔══════════════════════════════════════════════════╗");
    System.out.println("  ║\033[31m               GRACIAS POR SU DINERO              \033[0m║");
    System.out.println("  ║\033[31m                   ¡HASTA PRONTO!                 \033[0m║");
    System.out.println("  ╚══════════════════════════════════════════════════╝\n");
    System.out.println("                      (");
    System.out.println("                        )     (");
    System.out.println("                 ___...(-------)-....___");
    System.out.println("             .-\"\"       )    (          \"-.");
    System.out.println("       .-'``'|-._             )         _.-|");
    System.out.println("      /  .--.|   `\"\"---...........---\"\"`   |");
    System.out.println("     /  /    |                             |");
    System.out.println("     |  |    |                             |");
    System.out.println("      \\  \\   |   \033[32m Alejandro Barrionuevo  \033[0m  |");
    System.out.println("       `\\ `\\ |  \033[32m            y        \033[0m      |");
    System.out.println("         `\\ `|   \033[32m      José Molina       \033[0m  |");
    System.out.println("         _/ /\\                             /");
    System.out.println("        (__/  \\                           /");
    System.out.println("     _..---\"\"` \\                         /`\"\"---.._");
    System.out.println("  .-'           \\                       /          '-.");
    System.out.println(":               `\"-.__             __.-\"`              :");
    System.out.println(":                  ) \"\"---...---\"\" (                 :");
    System.out.println(" '._               `\"--...___...--\"`              _.'");
    System.out.println("       ..--\"\"                                \"\"--..");
    System.out.println("               \"\"\"----.....______.....----\"\"\"   \n");
  }

  public static void main(String[] args) {
    try {
      Baraja barajaESP = new Baraja();
      boolean nuevaPartida = true; // Variable para el bucle general de la partida
      boolean ganar = false; // Variable que controla si se suma o se recta la apuesta

      portada();

      do {
        barajaESP.inicializaBaraja(); // Inicializamos baraja
        barajaESP.barajar(); // Barajamos

        // Nombre
        System.out.print("Jugador introduzca su nombre: ");
        String nombre = System.console().readLine();

        // Saldo
        System.out.print("Jugador introduzca su saldo: ");
        int saldo = Integer.parseInt(System.console().readLine());

        // Creamos al jugado y su mano
        Jugador jugadorPro = new Jugador(saldo, nombre);
        Mano mano1 = new Mano();

        // Creamos la maquina y su mano
        // Jugador maquina = new Jugador(10, "Banca");
        Mano mano2 = new Mano();

        // Apuesta
        boolean nuevaApuesta = true;
        do {

          // Realizar apuesta
          System.out.print("Introduce tu apuesta: ");
          int apuesta = Integer.parseInt(System.console().readLine());

          jugadorPro.setApuesta(apuesta);
          // Si la apuesta es mayor al saldo repetira lo de pedir apuesta dentro del
          // setApuesta

          System.out.println("Apostaste " + jugadorPro.getApuesta() + " € \n");

          // Codigo del juego
          boolean salirBucle1 = false;
          do {
            mano1.setCartas(barajaESP.extraerCarta());
            mano1.setPuntuacionMano();
            mano1.mostrarPuntuacion();
            if (mano1.getContador() == 0) {
              mano1.setContador(); // Solo la primera vez despues no
            }

            if (mano1.getPuntuacionMano() > 7.5) {
              salirBucle1 = true;
              System.out.println("¡Te has pasado!");
              ganar = false; // pierdes
            } else if (mano1.getPuntuacionMano() == 7.5) {
              System.out.println("Ganaste");
              salirBucle1 = true;
              ganar = true; // ganas
            } else {

              System.out.println("\n" + menu());
              int opcion;
              do {
                System.out.print("Opcion: ");
                opcion = Integer.parseInt(System.console().readLine());
                System.out.println();
                if (opcion < 1 || opcion > 2) {
                  System.out.println("Por favor, introduzca una opcion correcta.\n");
                }
              } while (opcion < 1 || opcion > 2);

              if (opcion == 1) {
                salirBucle1 = false;
              } else if (opcion == 2) {
                salirBucle1 = true;
                System.out.print("Te has plantado con ");
                mano1.mostrarPuntuacion();

                // Juega la maquina
                System.out.println("\nTurno de la banca:\n");
                do {
                  mano1.getPuntuacionMano();
                  mano2.setCartas(barajaESP.extraerCarta()); // Extrae una carta
                  mano2.setPuntuacionMano(); // Cambia la puntuacion de la mano
                  mano2.mostrarPuntuacion(); // Muestra la puntuacion
                  if (mano2.getContador() == 0) {
                    mano2.setContador(); // Solo la primera vez despues no
                  }

                  System.out.println();
                  Thread.sleep(1000); // Esto es para aumentar el tiempo que tarda
                } while (mano2.getPuntuacionMano() < 7.5 && mano2.getPuntuacionMano() <= mano1.getPuntuacionMano());
                // La banca saca cartas mientras que <7.5 o hasta que supere a la mano del
                // jugador.

                if (mano2.getPuntuacionMano() > 7.5 || mano2.getPuntuacionMano() < mano1.getPuntuacionMano()) {
                  // La banca pierde si se pasa de 7.5 O si la mano de maquina es menor que la del
                  // jugador
                  ganar = true;
                  System.out.println("¡ENHORABUENA!La banca se ha pasado.");
                } else if (mano2.getPuntuacionMano() == 7.5 || mano1.getPuntuacionMano() < mano2.getPuntuacionMano()) {
                  // La maquina gana si obtiene 7.5 O si la puntuacion del jugador es menor.
                  ganar = false;
                  System.out.println("\nLa banca gana.\n");
                }

              } else {
                System.out.println("Introduzca un valor correcto.");
              }
            }
          } while (!salirBucle1);

          jugadorPro.setSaldo(ganar); // Se resta o se suma la apuesta al saldo
          if (ganar) {
            System.out.println("Has sumado " + jugadorPro.getApuesta() + " € a tu cartera.");
          } else {
            System.out.println("Has perdido " + jugadorPro.getApuesta() + " € que han sido restados de tu cartera.");
          }

          // Nueva apuesta
          if (jugadorPro.getSaldo() > 0) {
            String salirApuesta;
            do {
              System.out.print("\n¿Quiere hacer otra apuesta? (🃏 si / 🚫 no): ");
              salirApuesta = System.console().readLine();
              if (salirApuesta.equalsIgnoreCase("no")) {
                nuevaApuesta = false;
              } else if (salirApuesta.equalsIgnoreCase("si")) {
                System.out.println("Gracias por apostar de nuevo");
                System.out.println("Este es el dinero que dispone " + jugadorPro.getSaldo());
                barajando();
                limpiar();
              }
            } while (!salirApuesta.equalsIgnoreCase("no") && !salirApuesta.equalsIgnoreCase("si"));

          } else {
            nuevaApuesta = false;
            System.out.println("Gracias por jugar a este juego pero ya no le queda saldo");
          }

          // Restablece mano a cero todo
          mano1.reset();
          mano2.reset();

          barajaESP.inicializaBaraja(); // Inicializamos baraja
          barajaESP.barajar(); // Barajamos

        } while (nuevaApuesta);

        // Querer jugar de nuevo o terminar el juego
        String salirPartida;
        do {
          System.out.print("\nQuieres jugar otra partida (si o no): ");
          salirPartida = System.console().readLine();
        } while (!salirPartida.equalsIgnoreCase("no") && !salirPartida.equalsIgnoreCase("si"));

        if (salirPartida.equalsIgnoreCase("no")) {
          nuevaPartida = false;
        } else {
          System.out.println("Jugararemos de nuevo");
          barajando();
        }

      } while (nuevaPartida);

      // System.out.println("\nGracias por jugar y por su dinero :)\n");
      creditos();

    } catch (InputMismatchException ime) {
      System.out.println("\nError: Escribiste letras en vez de numeros\n");
    } catch (Exception e) {
      System.out.println("\nMenjase de error: " + e.getMessage());
      System.out.println("La clase del error: " + e.getClass() + " \n");
    }

  }
}
