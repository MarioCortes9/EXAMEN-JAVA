
/* bingo 3*9
tablero 10-19, 20-29 asi constantemente
aleatorios
ordenar por columna tipo la ulktima mas grande y tal
 */

import java.util.Random;

public class Main {

    private static final int FILA = 3;
    private static final int COLUMNA = 9;
    private static int[][] tablero = new int[FILA][COLUMNA];
    private static final Random aleatorio = new Random();

    // rellenamos tablero
    private static void rellenarTablero() {
        for (int col = 0; col < COLUMNA; col++) {
            int min = 10 + col  * 10;
            int max = min + 9;
            for (int fila = 0; fila < FILA; fila++) {
                tablero[fila][col] = aleatorio.nextInt((max - min) + 1) + min;
            }
            ordenarTablero(col);
        }
    }

    //ordenar por columna
    private static void ordenarTableroPorColumnas() {
        for (int col = 0; col < MAX_DIMENSION; col++) { // Iteramos por cada columna
            for (int i = 0; i < MAX_DIMENSION - 1; i++) { // Recorrer los elementos de la columna
                for (int j = 0; j < MAX_DIMENSION - 1 - i; j++) { // Recorrer los elementos de la columna
                    if (tablero[j][col] > tablero[j + 1][col]) { // Si el elemento es mayor que el siguiente
                        // Intercambiar elementos de la columna
                        char auxiliar = tablero[j][col];
                        tablero[j][col] = tablero[j + 1][col];
                        tablero[j + 1][col] = auxiliar;
                    }
                }
            }
        }
    }
/*
    private static void ordenarTableroPorFilas() {
        for (int i = 0; i < MAX_DIMENSION; i++) { // Iteramos por cada fila
            for (int j = 0; j < MAX_DIMENSION - 1; j++) { // Recorrer los elementos de la fila
                for (int k = 0; k < MAX_DIMENSION - 1 - j; k++) { // Recorrer los elementos de la fila
                    if (tablero[i][k] > tablero[i][k + 1]) { // Si el elemento es mayor que el siguiente
                        // Intercambiar elementos de la fila
                        char auxiliar = tablero[i][k];
                        tablero[i][k] = tablero[i][k + 1];
                        tablero[i][k + 1] = auxiliar;
                    }
                }
            }
        }
    }

 */


    //imprimir tablero
    private static void imprimirTablero() {
        for (int i = 0; i < FILA; i++) {
            for (int j = 0; j < COLUMNA; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        tablero = new int[FILA][COLUMNA];
        rellenarTablero();
        imprimirTablero();


    }
}