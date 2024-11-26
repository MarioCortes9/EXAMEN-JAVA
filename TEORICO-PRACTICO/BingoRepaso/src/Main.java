import java.util.Random;

public class Main {

    private static final int FILA = 3;
    private static final int COLUMNA = 9;
    private static int[][] tablero = new int[FILA][COLUMNA];
    private static final Random aleatorio = new Random();

    // Método para rellenar el tablero sin números repetidos
    private static void rellenarTablero() {
        // Recorrer cada columna
        for (int col = 0; col < COLUMNA; col++) {
            int min = 10 + col * 10; // Rango mínimo de números por columna (10-19, 20-29, etc.)
            int max = min + 9; // Rango máximo de números por columna (19, 29, etc.)

            // Recorrer cada fila de la columna
            for (int fila = 0; fila < FILA; fila++) {
                int numero;
                boolean repetido;

                // Asegurarse de que no se repitan números dentro de la columna
                do {
                    repetido = false;
                    numero = aleatorio.nextInt((max - min) + 1) + min; // Generar un número aleatorio
                    // Comprobar si el número ya existe en la columna
                    for (int i = 0; i < fila; i++) {
                        if (tablero[i][col] == numero) {
                            repetido = true; // Si se repite, buscar otro número
                            break;
                        }
                    }
                } while (repetido); // Si el número es repetido, volver a generar otro

                tablero[fila][col] = numero; // Asignar el número en el tablero
            }

            // Después de llenar la columna, ordenarla de menor a mayor
            ordenarColumna(col);
        }
    }

    // Método para ordenar una columna de menor a mayor
    private static void ordenarColumna(int col) {
        // Usamos el algoritmo de ordenación de burbuja
        for (int i = 0; i < FILA - 1; i++) {
            for (int j = 0; j < FILA - 1 - i; j++) {
                if (tablero[j][col] > tablero[j + 1][col]) {
                    // Intercambiar los valores si no están en orden
                    int temp = tablero[j][col];
                    tablero[j][col] = tablero[j + 1][col];
                    tablero[j + 1][col] = temp;
                }
            }
        }
    }

    // Método para imprimir el tablero en consola
    private static void imprimirTablero() {
        for (int i = 0; i < FILA; i++) {
            for (int j = 0; j < COLUMNA; j++) {
                System.out.print(tablero[i][j] + "\t"); // Imprime el número con un tabulador para separar
            }
            System.out.println(); // Nueva línea después de cada fila
        }
    }

    public static void main(String[] args) {
        // Llamamos a los métodos para llenar e imprimir el tablero
        rellenarTablero();
        imprimirTablero();
    }
}
