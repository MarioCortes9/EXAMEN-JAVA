import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Random aleatorio = new Random();
    private static Scanner leer = new Scanner(System.in);

    private static int numParejas = 2;
    private static int cantidadNum = 8;

    private static final int FILA = 4;
    private static final int COLUMNA = 4;

    private static int[][] tablero = new int[FILA][COLUMNA];
    private static boolean[][] descubierto = new boolean[FILA][COLUMNA]; // Para controlar qué posiciones están descubiertas

    private static void rellenarTablero() {
        for (int i = 0; i < FILA; i++) {
            for (int j = 0; j < COLUMNA; j++) {
                tablero[i][j] = 0; // Inicializamos todas las posiciones a 0
                descubierto[i][j] = false; // Todas las posiciones están inicialmente tapadas
            }
        }
    }

    private static void imprimeTablero() {
        for (int i = 0; i < FILA; i++) {
            for (int j = 0; j < COLUMNA; j++) {
                if (descubierto[i][j]) {
                    System.out.print(tablero[i][j] + " "); // Muestra el número si está descubierto
                } else {
                    System.out.print("X "); // Muestra "X" si está tapado
                }
            }
            System.out.println();
        }
    }

    public static void asignarParejas() {
        int filaAleatoria = 0;
        int columnaAleatoria = 0;

        for (int i = 0; i < cantidadNum; i++) {
            for (int j = 0; j < numParejas; j++) {

                do {
                    filaAleatoria = aleatorio.nextInt(FILA);
                    columnaAleatoria = aleatorio.nextInt(COLUMNA);

                } while (tablero[filaAleatoria][columnaAleatoria] != 0); // Busca una posición vacía
                tablero[filaAleatoria][columnaAleatoria] = (i + 1); // Asigna el número de la pareja
            }
        }
    }

    public static void main(String[] args) {

        rellenarTablero(); // Inicializamos el tablero antes de asignar las parejas
        asignarParejas();
        imprimeTablero();

        System.out.println("Cuantos intentos quieres probar");
        int intentos = leer.nextInt();

        do {
            System.out.println("Dame las Coordenadas X del Primer Numero");
            int posicionUsuarioFila = leer.nextInt();
            System.out.println("Dame las Coordenadas Y del Primer Numero");
            int posicionUsuarioColumna = leer.nextInt();

            System.out.println("Dame las Coordenadas X del Segundo Numero");
            int posicionUsuarioFila2 = leer.nextInt();
            System.out.println("Dame las Coordenadas Y del Segundo Numero");
            int posicionUsuarioColumna2 = leer.nextInt();

            // Revela temporalmente las posiciones seleccionadas
            descubierto[posicionUsuarioFila][posicionUsuarioColumna] = true;
            descubierto[posicionUsuarioFila2][posicionUsuarioColumna2] = true;

            imprimeTablero(); // Muestra el tablero con los números descubiertos temporalmente

            if (tablero[posicionUsuarioFila][posicionUsuarioColumna] == tablero[posicionUsuarioFila2][posicionUsuarioColumna2]) {
                tablero[posicionUsuarioFila][posicionUsuarioColumna] = 0; // Elimina el par encontrado
                tablero[posicionUsuarioFila2][posicionUsuarioColumna2] = 0;
                System.out.println("¡Has acertado!");

            } else {
                System.out.println("Posiciones incorrectas");

                // Vuelve a tapar las posiciones si no coinciden
                descubierto[posicionUsuarioFila][posicionUsuarioColumna] = false;
                descubierto[posicionUsuarioFila2][posicionUsuarioColumna2] = false;
            }
            intentos--;
        } while (intentos > 0);

        System.out.println("¡Fin del juego!");
    }
}
