/**
 * JuegoSieteYMedia
 * 
 * Contendrá el main, donde se hace la lógica
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
    try { //Es obligatorio para porder meter el retardo
      for (int i = 0; i < 10; i++) {
        System.out.print("🂠");
        Thread.sleep(500); // Retardo
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
      boolean nuevaApuesta = true; //Variable que se utiliza para ir realizando apuestas

      portada();
      //Partida
      do {
        barajaESP.inicializaBaraja(); // Inicializamos la baraja
        barajaESP.barajar(); // Barajamos las cartas

        // Nombre
        System.out.print("Jugador introduzca su nombre: ");
        String nombre = System.console().readLine();

        // Saldo
        System.out.print("Jugador introduzca su saldo: ");
        int saldo = Integer.parseInt(System.console().readLine());

        // Creamos al jugado y su mano con los datos pedidos
        Jugador jugador = new Jugador(saldo, nombre);
        Mano manoJugador = new Mano();

        // Creamos la mano de la banca
        Mano manoBanca = new Mano();

        // Apuesta
        do {
          // Realizar apuesta
          System.out.print("Introduce tu apuesta: ");
          int apuesta = Integer.parseInt(System.console().readLine());

          jugador.setApuesta(apuesta);
          // Si la apuesta es mayor al saldo repetira lo de pedir apuesta dentro del metodo

          System.out.println("Apostaste " + jugador.getApuesta() + " € \n"); //Muestra lo apostado

          // Codigo donde juega el jugador
          boolean salirJuego = false;
          do {
            manoJugador.setCartas(barajaESP.extraerCarta()); //Se saca una carta y se pone en la mano
            manoJugador.setPuntuacionMano(); //Se modifica la puntuacion de la mano
            manoJugador.mostrarPuntuacion(); //Se muestra la puntuacion de la mano
            if (manoJugador.getContador() == 0) { //Esto es para arreglar un fallo 
              manoJugador.setContador(); // Solo la primera vez despues no
            }

            //Comprobar si ganas o pierdes
            if (manoJugador.getPuntuacionMano() > 7.5) {
              salirJuego = true;
              System.out.println("¡Te has pasado!");
              ganar = false; // pierdes
            } else if (manoJugador.getPuntuacionMano() == 7.5) {
              System.out.println("Ganaste");
              salirJuego = true;
              ganar = true; // ganas
            } else {

              //Pintamos el menu y se elige una opcion
              System.out.println("\n" + menu());
              int opcion;
              //Controlando que el numero introducido sea 1 o 2
              do {
                System.out.print("Opcion: ");
                opcion = Integer.parseInt(System.console().readLine());
                System.out.println();
                if (opcion < 1 || opcion > 2) {
                  System.out.println("Por favor, introduzca una opcion correcta.\n");
                }
              } while (opcion < 1 || opcion > 2);

              if (opcion == 1) {
                salirJuego = false; //Pides otra carta
              } else if (opcion == 2) {
                salirJuego = true; //Te plantas
                System.out.print("Te has plantado con ");
                manoJugador.mostrarPuntuacion();

                // Juega la banca
                System.out.println("\nTurno de la banca:\n");
                do {
                  manoJugador.getPuntuacionMano(); //Muestras la puntuacion de la mano del jugador
                  manoBanca.setCartas(barajaESP.extraerCarta()); // Extrae una carta
                  manoBanca.setPuntuacionMano(); // Cambia la puntuacion de la mano
                  manoBanca.mostrarPuntuacion(); // Muestra la puntuacion
                  if (manoBanca.getContador() == 0) { //Esto es para arreglar un fallo
                    manoBanca.setContador(); // Solo la primera vez despues no
                  }

                  System.out.println();
                  Thread.sleep(1000); // Retardo
                } while (manoBanca.getPuntuacionMano() < 7.5 && manoBanca.getPuntuacionMano() <= manoJugador.getPuntuacionMano());
                // La banca saca cartas mientras que <7.5 o hasta que supere a la mano del jugador.

                if (manoBanca.getPuntuacionMano() > 7.5 || manoBanca.getPuntuacionMano() < manoJugador.getPuntuacionMano()) {
                  // La banca pierde si se pasa de 7.5 O si la mano de maquina es menor que la del jugador
                  ganar = true; //Ganas
                  System.out.println("¡ENHORABUENA!La banca se ha pasado.");
                } else if (manoBanca.getPuntuacionMano() == 7.5 || manoJugador.getPuntuacionMano() < manoBanca.getPuntuacionMano()) {
                  // La maquina gana si obtiene 7.5 O si la puntuacion del jugador es menor.
                  ganar = false; //Pierdes
                  System.out.println("\nLa banca gana.\n");
                }

              } else {
                System.out.println("Introduzca un valor correcto.");
              }
            }
          } while (!salirJuego);

          //Conclusion de la ronda
          jugador.setSaldo(ganar); // Se resta o se suma la apuesta al saldo
          if (ganar) {
            System.out.println("Has sumado " + jugador.getApuesta() + " € a tu cartera.");
          } else {
            System.out.println("Has perdido " + jugador.getApuesta() + " € que han sido restados de tu cartera.");
          }

          // Nueva apuesta
          if (jugador.getSaldo() > 0) {
            String salirApuesta;
            do {
              System.out.print("\n¿Quiere hacer otra apuesta? (🃏 si / 🚫 no): ");
              salirApuesta = System.console().readLine();
              if (salirApuesta.equalsIgnoreCase("no")) {
                nuevaApuesta = false; //No haces mas apuestas
              } else if (salirApuesta.equalsIgnoreCase("si")) {
                System.out.println("Gracias por apostar de nuevo");
                System.out.println(jugador.getNombre() + ", este es el dinero que dispone " + jugador.getSaldo());
                barajando();
                limpiar();
              }
            } while (!salirApuesta.equalsIgnoreCase("no") && !salirApuesta.equalsIgnoreCase("si"));

          } else {
            nuevaApuesta = false;
            System.out.println("Gracias por jugar a este juego pero ya no le queda saldo.");
          }

          // Restablece la mano
          manoJugador.reset();
          manoBanca.reset();

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
          nuevaPartida = false; //Se sale del bucle y se termina el juego
        } else {
          System.out.println("\nNueva partida:");
          barajando();
        }

      } while (nuevaPartida);

      creditos(); //Mostrar los creditos del juego

    } catch (InputMismatchException ime) {
      System.out.println("\nError: Escribiste letras en vez de numeros\n");
    } catch (Exception e) {
      System.out.println("\nMenjase de error: " + e.getMessage());
      System.out.println("La clase del error: " + e.getClass() + " \n");
    }
  }
}