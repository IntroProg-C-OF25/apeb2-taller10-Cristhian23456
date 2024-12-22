/***
 * jercicio 6
Crea un juego de tres en raya utilizando una matriz bidimensional de 3x3. 
* Permita a dos jugadores marcar sus movimientos alternativamente. El juego debe verificar 
* si alguno de los jugadores ha ganado o si hay un empate.
* 
* @author Cristhian Quizhpe
 */
import java.util.Scanner;

public class TresEnRaya {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[][] tablero = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}};
        char jugador = 'X'; 
        char laika = 'O'; 
        char ganador;
        boolean turnoJugador = true;
        boolean juegoActivo = true;
        boolean empate = false;
        int fila, columna;
        
        System.out.println("Bienvenido al Tres en Raya contra Laika!");
        System.out.println("\n   1   2   3");
        System.out.println("  -----------");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print((i + 1) + " | ");
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " | ");
            }
            System.out.println();
            System.out.println("  -----------");
        }

        while (juegoActivo) {
            if (turnoJugador) {
                System.out.print("Es tu turno. Ingresa tu posicion (fila y columna, separadas por un espacio):");
                while (true) {
                    fila = input.nextInt() - 1;
                    columna = input.nextInt() - 1;

                    if (fila >= 0 && fila < tablero.length && columna >= 0 && columna < tablero[fila].length && tablero[fila][columna] == ' ') {
                        break;
                    } else {
                        System.out.println("Movimiento invalido. Intenta nuevamente.");
                    }
                }

                tablero[fila][columna] = jugador;
            } else {
                System.out.println("Es el turno de Laika...");
                while (true) {
                    fila = (int) (Math.random() * 3);
                    columna = (int) (Math.random() * 3);

                    if (tablero[fila][columna] == ' ') {
                        tablero[fila][columna] = laika;
                        break;
                    }
                }
            }

            System.out.println("\n   1   2   3");
            System.out.println("  -----------");
            for (int i = 0; i < tablero.length; i++) {
                System.out.print((i + 1) + " | ");
                for (int j = 0; j < tablero[i].length; j++) {
                    System.out.print(tablero[i][j] + " | ");
                }
                System.out.println();
                System.out.println("  -----------");
            }

            ganador = ' ';
            for (int i = 0; i < tablero.length; i++) {
                if (tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2] && tablero[i][0] != ' ') {
                    ganador = tablero[i][0];
                    break;
                }
                if (tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i] && tablero[0][i] != ' ') {
                    ganador = tablero[0][i];
                    break;
                }
            }

            if (tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2] && tablero[0][0] != ' ') {
                ganador = tablero[0][0];
            }
            if (tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0] && tablero[0][2] != ' ') {
                ganador = tablero[0][2];
            }

            empate = true;
            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero[i].length; j++) {
                    if (tablero[i][j] == ' ') {
                        empate = false;
                        break;
                    }
                }
            }

            if (ganador == jugador) {
                System.out.println("Felicidades! Has ganado el juego.");
                juegoActivo = false;
            } else if (ganador == laika) {
                System.out.println("Laika ha ganado. ¡Mejor suerte la proxima vez!");
                juegoActivo = false;
            } else if (empate) {
                System.out.println("El juego ha terminado en empate.");
                juegoActivo = false;
            }
        turnoJugador = !turnoJugador;
        }
    }
}
/***
 * Bienvenido al Tres en Raya contra Laika!

   1   2   3
  -----------
1 |   |   |   | 
  -----------
2 |   |   |   | 
  -----------
3 |   |   |   | 
  -----------
Es tu turno. Ingresa tu posicion (fila y columna, separadas por un espacio):
3 3

   1   2   3
  -----------
1 |   |   |   | 
  -----------
2 |   |   |   | 
  -----------
3 |   |   | X | 
  -----------
Es el turno de Laika...

   1   2   3
  -----------
1 | O |   |   | 
  -----------
2 |   |   |   | 
  -----------
3 |   |   | X | 
  -----------
Es tu turno. Ingresa tu posicion (fila y columna, separadas por un espacio):3 1

   1   2   3
  -----------
1 | O |   |   | 
  -----------
2 |   |   |   | 
  -----------
3 | X |   | X | 
  -----------
Es el turno de Laika...

   1   2   3
  -----------
1 | O |   | O | 
  -----------
2 |   |   |   | 
  -----------
3 | X |   | X | 
  -----------
Es tu turno. Ingresa tu posicion (fila y columna, separadas por un espacio):1 2

   1   2   3
  -----------
1 | O | X | O | 
  -----------
2 |   |   |   | 
  -----------
3 | X |   | X | 
  -----------
Es el turno de Laika...

   1   2   3
  -----------
1 | O | X | O | 
  -----------
2 | O |   |   | 
  -----------
3 | X |   | X | 
  -----------
Es tu turno. Ingresa tu posicion (fila y columna, separadas por un espacio):2 3

   1   2   3
  -----------
1 | O | X | O | 
  -----------
2 | O |   | X | 
  -----------
3 | X |   | X | 
  -----------
Es el turno de Laika...

   1   2   3
  -----------
1 | O | X | O | 
  -----------
2 | O | O | X | 
  -----------
3 | X |   | X | 
  -----------
Es tu turno. Ingresa tu posicion (fila y columna, separadas por un espacio):3 2

   1   2   3
  -----------
1 | O | X | O | 
  -----------
2 | O | O | X | 
  -----------
3 | X | X | X | 
  -----------
Felicidades! Has ganado el juego.
BUILD SUCCESSFUL (total time: 1 minute 3 seconds)
 */