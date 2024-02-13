
/**
 * Metodo main JuegoSieteYMedia
 * 
 * Contendrá el método main, donde se hace la lógica
 * del turno primero del jugador hasta que se plante o pierda y luego el
 * turno de la banca.
 * 
 * @author Alejandro Barrionuevo Rosado
 * @author Jose Molina Melendez //Jose poner ventana emergente :)
 */

import java.util.InputMismatchException;

public class JuegoSieteYMedia {
  public static void main(String[] args) {
    try {
      Baraja barajaESP = new Baraja();
      boolean nuevaPartida = true; // Variable para el bucle general de la partida
      boolean ganar = false; // Variable que controla si se suma o se recta la apuesta

      System.out.println("\nBIENVENIDO AL JUEGO DE LA SIETE Y MEDIA\n");

      do {
        barajaESP.inicializaBaraja(); // Inicializamos baraja
        barajaESP.barajar(); // Barajamos

        // Nombre
        System.out.print("Jugador introduzca su nombre: ");
        String nombre = System.console().readLine();

        // Saldo
        System.out.print("Jugador introduzca su saldo: ");
        int saldo = Integer.parseInt(System.console().readLine());
        // int saldo = JOptionPane.showInputDialog("Introduzca su saldo"); ////Pedir con
        // ventana emergente

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

              System.out.println("\nOpcion 1. Pedir otra carta.  |  Opcion 2. Plantarse.");
              System.out.print("Opcion: ");
              int opcion1 = Integer.parseInt(System.console().readLine());
              System.out.println();

              if (opcion1 == 1) {
                salirBucle1 = false;
              } else if (opcion1 == 2) {
                salirBucle1 = true;
                System.out.print("Te has plantado con ");
                mano1.mostrarPuntuacion();

                // Juega la maquina
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
                } while (mano2.getPuntuacionMano() < 7.5 && mano2.getPuntuacionMano() <= mano1.getPuntuacionMano()); //Maquina saca carta hasta
                //que <7.5 o hasta que supere a la mano del jugador.

                if (mano2.getPuntuacionMano() > 7.5 || mano2.getPuntuacionMano() < mano1.getPuntuacionMano()) { //La maquina pierde si se pasa de 7.5 O si la mano de maquina es menor que la del jugador
                  ganar = true;
                  System.out.println("¡ENHORABUENA!La banca se ha pasado.");
                } else if (mano2.getPuntuacionMano() == 7.5 || mano1.getPuntuacionMano() < mano2.getPuntuacionMano()) { // La maquina gana si obtiene 7.5 O si la puntuacion del jugador es menor.
                  ganar = false;
                  System.out.println("\nLa banca gano.\n");
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

            System.out.print("\nQuiere apostar de nuevo (si o no): ");
            String salirPartida1 = System.console().readLine();
            if (salirPartida1.equalsIgnoreCase("no")) {
              nuevaApuesta = false;
            } else {
              System.out.println("Gracias por apostar de nuevo");
              System.out.println("Este es el dinero que dispone " + jugadorPro.getSaldo());
            }

          } else {
            nuevaApuesta = false;
            System.out.println("Gracias por jugar a este juego pero ya no le queda saldo");
          }

          // Restablece mano a cero todo
          mano1.reset();
          mano2.reset();

        } while (nuevaApuesta);

        // Querer jugar de nuevo o terminar el juego
        System.out.print("\nQuieres jugar otra partida (si o no): ");
        String salirPartida2 = System.console().readLine();

        if (salirPartida2.equalsIgnoreCase("no")) {
          nuevaPartida = false;
        } else {
          System.out.println("Jugararemos de nuevo");
          System.out.print("Cargando: ");
          for (int i = 0; i < 10; i++) {
            System.out.print("\u25A1");
            Thread.sleep(1000); // Esto es para aumentar el tiempo que tarda
          }
          System.out.println();
        }

      } while (nuevaPartida);

      System.out.println("\nGracias por jugar y por su dinero :)\n");

    } catch (InputMismatchException ime) {
      System.out.println("\nError: Escribiste letras en vez de numeros\n");
    } catch (Exception e) {
      System.out.println("\nMenjase de error: " + e.getMessage());
      System.out.println("La clase del error: " + e.getClass() + " \n");
    }

  }
}
