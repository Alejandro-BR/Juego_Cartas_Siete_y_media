# Juego de cartas Siete y media

<br>

**Alejandro Barrionuevo Rosado**

**Jose Molina Melendez**

<br>

<hr>

**SIETE Y MEDIA es un juego de cartas donde el objetivo principal es**
**acercarse lo más posible a la puntuación de 7,5.**

Se utiliza la baraja de cartas española de 4 palos y 10 cartas por cada palo.

Palos: Oros, Copas, Espadas y Bastos

Cada Palo tiene 10 cartas numeradas de la siguiente manera:
1, 2, 3, 4, 5, 6, 7, Sota, Caballo y Rey

Cada vez que obtenemos una carta incrementamos la puntuación de nuestra
jugada de manera que las cartas del 1 al 7 tienen una puntuación
equivalente a su número y las cartas Sota, Caballo y Rey una puntuación de
medio punto cada una.

Por ejemplo para obtener 7 y media podríamos tener:
- 1 de Oros, 5 de Bastos, Sota de Bastos, Caballo de Espadas y Sota de Espadas.
- 7 de Copas, Rey de Copas
- 6 de Bastos, 1 de Espadas, Caballo de Copas.

El juego transcurre de la siguiente manera:
Existe un mazo que contiene las 40 cartas de la baraja.
Se inicia el juego con un mensaje de bienvenida y acto seguido se barajan
las cartas.
Se tiene que poder barajar el mazo de manera que contenga las 40 cartas
desordenadas.

A continuación se le pregunta al jugador cuánto dinero quiere apostar.
El jugador tiene un monedero con una cantidad inicial de dinero.
Cuando el jugador se queda sin dinero no puede seguir jugando.
El jugador no puede apostar más dinero del que tiene.
Una vez indique una cantidad de dinero de la apuesta, se le irán entregando
cartas del mazo hasta que se cumpla alguna de las siguientes situaciones:

1. Obtenga una puntuación de 7 y media, por lo que el jugador habrá
ganado su apuesta y deberá incrementar su dinero en la cantidad que
apostó.

2. Sobrepase la puntuación de 7 y media, por lo que el jugador habrá
perdido su apuesta y deberá decrementar dicho importe de su monedero.

3. Se plante quedándose con la puntuación actual de sus cartas.
Cada vez que se le entrega una carta al jugador se deben mostrar todas las
cartas que tiene actualmente y un menú indicando si quiere obtener otra
carta y quiere plantarse.

En el caso de que se haya plantado, le tocará a la banca obtener cartas
para intentar sacar una puntuación mayor de la obtenida por el jugador, se
podrán dar las siguientes situaciones:

1. La banca sobrepasa la puntuación de 7,5, por lo que el jugador habrá
ganado su apuesta y deberá incrementar su dinero en la cantidad que
apostó.

2. La banca obtiene una puntuación menor o igual de 7,5 y mayor que la
puntuación del jugador, por lo que el jugador habrá perdido su
apuesta y deberá decrementar dicho importe de su monedero.
Cuando termine el juego se le debe preguntar al jugador si quiere seguir
jugando con el dinero que le queda siempre y cuando tenga dinero disponible
para apostar.

Si decide seguir jugando se deberá volver a iniciar el juego, es decir se
vuelven a tener todas las cartas en el mazo, se barajan, se le pide la
cantidad de la apuesta al jugador y se comienza a entregar cartas.

<h2>Clases:</h2>

● Carta: gestiona el palo y número asignado y también un método que te
diga la puntuación de esa carta.

● Baraja: contiene un conjunto (array) de cartas, incluyendo todos los
palos y valores posibles. Debe contener los métodos de barajar las
cartas y repartir una carta.

● Jugador: gestiona las cartas o mano que tiene un jugador, el saldo y
la apuesta que realiza. Tendrás que implementar una serie de métodos
para obtener la puntuación de su mano, otro para recibir una carta de
la baraja, realizar apuesta...

● JuegoSieteYMedia: contendrá el método main, donde se hace la lógica
del turno primero del jugador hasta que se plante o pierda y luego el
turno de la banca.

Una variante podría ser dividir crear otra clase más, aligerando la clase Jugador:

● Mano: contendría los métodos de añadir una carta a la mano del
jugador y de calcular la puntuación de la mano del jugador.