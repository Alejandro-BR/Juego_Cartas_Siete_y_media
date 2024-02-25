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

<br>

El juego transcurre de la siguiente manera:

Existe un mazo que contiene las 40 cartas de la baraja, las cuales seran barajadas aleatoriamente.
A continuacion se le pregunta al jugador su nombre, cuanto dinero tiene en el monedero y cuanto desea apostar en esta ronda.

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

Cada vez que se le entrega una carta al jugador se mostrara todas la puntuacion que tiene y un menú indicando si quiere obtener otra
carta o quiere plantarse.

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

Si decide seguir jugando se vuelve a iniciar el juego, es decir se
vuelven a tener todas las cartas en el mazo, se barajan, se le pide la
cantidad de la apuesta al jugador y se comienza a entregar cartas.

<br>

<h2>Clases:</h2>

● **Carta:** gestiona el palo y número asignado ademas también un método que te diga la puntuación de esa carta.

● **Baraja:** contiene un conjunto (array) de cartas, incluyendo todos los palos y valores posibles. Contiene los métodos de barajar las cartas y repartir una carta entre otros.

● **Jugador:** gestiona el saldo y la apuesta que realiza ademas de sus datos personales.

● **Mano:** gestiona las cartas o mano que tiene un jugador y la banca, contendría los métodos de añadir una carta a la mano del jugador y de calcular la puntuación de la mano del jugador.

● **JuegoSieteYMedia:** contendrá el método main, donde se hace la lógica.

<br>

<h2>Ejecutable:</h2>

Para la ejecucion de este programa se utiliza un archivo **.bat** llamado **SieteYMedia** el cual ejecutara el programa desde la terminal del dispositivo, este fichero esta pensado para los sistemas Windows 10 y Windows 11.

Funcionara siempre y cuando el directorio este posicionado en la carpeta Documents del sistema, en caso de que se cambia la ubicacion de este directorio se debera alterar la linea de codigo siguiente dentro del fichero.

```c

cd C:\Users\Usuario\Documents\Juego_Cartas_Siete_y_media/src

```

Indicando despues del cd la direccion del directorio y a acontinuacion esta linea.

```c

\Juego_Cartas_Siete_y_media/src

```

El directorio cuenta con un acceso directo hacia el ejecutable ya creado, el cual dispone del icono del programa, este fichero puede ser movido al escritorio o cualquier punto que el usuario prefiera para su comodidad a la hora de su utilizacion.
