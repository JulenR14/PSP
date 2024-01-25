# Proyecto de Juego en Java

Este es un juego simple basado en consola desarrollado en Java. El juego involucra a un jugador y varios enemigos moviéndose alrededor de una cuadrícula 2D. El objetivo del jugador es evitar a los enemigos el mayor tiempo posible.

## Estructura del Proyecto

El proyecto está estructurado en tres paquetes principales:

1. `org.example`: Este paquete contiene la clase `Main`, que es el punto de entrada de la aplicación, y la clase `Partida`, que representa una sesión de juego.

2. `org.example.models`: Este paquete contiene las clases `Jugador` y `Enemigo`, que representan las entidades del juego.

## Entidades del Juego

### Jugador

La clase `Jugador` representa al jugador en el juego. Tiene atributos para el nombre del jugador y la posición (coordenadas x e y). La posición inicial del jugador se genera aleatoriamente. El jugador puede moverse en cuatro direcciones: arriba, abajo, izquierda y derecha.

### Enemigo

La clase `Enemigo` representa a un enemigo en el juego. Tiene atributos para el nombre del enemigo y la posición (coordenadas x e y). La posición inicial del enemigo se genera aleatoriamente. El enemigo se mueve hacia la posición del jugador cada vez que el jugador se mueve.

## Sesión de Juego (Partida)

La clase `Partida` representa una sesión de juego. Contiene instancias de las clases `Jugador` y `Enemigo`. La sesión de juego rastrea los movimientos del jugador y actualiza las posiciones de los enemigos en consecuencia. El juego termina cuando un enemigo alcanza la posición del jugador.

## Cómo Ejecutar

Para ejecutar el juego, ejecute la clase `Main`. El juego comenzará y mostrará las posiciones iniciales del jugador y los enemigos. Puedes mover al jugador ingresando uno de los siguientes comandos:

- `a`: Mover a la izquierda
- `s`: Mover hacia abajo
- `d`: Mover a la derecha
- `w`: Mover hacia arriba

El juego actualizará y mostrará las posiciones del jugador y los enemigos después de cada movimiento. El juego termina cuando un enemigo alcanza la posición del jugador.

## Construido Con

- Java
- Maven
- Lombok

## Autor

JulenR14
