/*      1º) Carga este ejercicio
        2º) Optimiza a través de funciones
        3º) Haz debug
        4º) Ordena los números aleatorios por columnas de menor a mayor
        5º) Y recuérdalo para el examen tipo Test en java…

 */

import java.util.Random;

public class MatrizAleatoria {

    private static int[][] matriz = new int[3][9];
    private static Random random = new Random();

    public static void main(String[] args) {

        llenarMatriz();
        imprimirTablero();
    }

    // Llenar la matriz de acuerdo al rango en cada columna
    private static void llenarMatriz() {
        for (int col = 0; col < matriz[0].length; col++) {
            int min = 10 + (col * 10); // valor mínimo para la columna actual
            int max = min + 9;        // valor máximo para la columna actual

            for (int row = 0; row < matriz.length; row++) {
                matriz[row][col] = random.nextInt(max - min + 1) + min;
            }
            //4º) Ordena los números aleatorios por columnas de menor a mayor
            for (int i = 0; i < matriz.length - 1; i++) {  // pos 9
                for (int j = 0; j < matriz.length - i - 1; j++) { // pos 8
                    if (matriz[j][col] > matriz[j + 1][col]) {


                        int aux = matriz[j][col];
                        matriz[j][col] = matriz[j + 1][col];
                        matriz[j + 1][col] = aux;
                    }
                }
            }
        }
    }

    // Imprimir la matriz
    private static void imprimirTablero() {
        for (int row = 0; row < matriz.length; row++) {
            for (int col = 0; col < matriz[0].length; col++) {
                System.out.print(matriz[row][col] + "\t");
            }
            System.out.println();
        }
    }
}




