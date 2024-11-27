//examen debug y funcion de saltar mas de una casilla de golpe
//saltar , haces un movimiento y se te randomiza todo el tablero



import java.util.Random;
import java.util.Scanner;


public class Main {
    static final int MAX_FILAS = 10;
    static final int MAX_COLUMNAS = 10;
    static String[][] matriz1 = new String[MAX_FILAS][MAX_COLUMNAS];
    static String[][] matriz2 = new String[MAX_FILAS][MAX_COLUMNAS];


    static int filaAl;
    static int columnaAl;


    static int filaYoda;
    static int columnaYoda;
    static int filaVader;
    static int columnaVader;


    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);


    static int vidas1 = 3;
    static int vidas2 = 3;

    public static void rellenarTablero(String matriz[][]) {
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                matriz[i][j] = ".";
            }
        }
        matriz[9][9] = "F";
    }

    public static void rellenarPersonajes(String matriz[][], String personaje, int numVeces) {
        for (int i = 0; i < numVeces; i++) {
            do {
                filaAl = random.nextInt(10);
                columnaAl = random.nextInt(10);
            } while (matriz[filaAl][columnaAl] != ".");
            matriz[filaAl][columnaAl] = personaje;
        }
        if (personaje.equals("Y") || personaje.equals("V"))
            if (personaje.equals("Y")) {
                filaYoda = filaAl;
                columnaYoda = columnaAl;
            } else if (personaje.equals("V")) {
                filaVader = filaAl;
                columnaVader = columnaAl;
            }
    }

    public static void printearTablero(String matriz[][]) {
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void movimiento(String matriz[][], String personaje, String enemigo, String muro) {
        int fila = 0, columna = 0;
        if (personaje.equals("Y")) {
            fila = filaYoda;
            columna = columnaYoda;
        } else if (personaje.equals("V")) {
            fila = filaVader;
            columna = columnaVader;
        }


        System.out.println("Introduce un movimiento de tu personaje (W,A,S,D)");
        String leerMovimiento = scanner.nextLine();
        switch (leerMovimiento) {
            case "W", "w":

                //INFINITO

                matriz[fila][columna] = ".";
                if (fila == 0) {
                    fila = MAX_FILAS - 1;
                } else {
                    fila--;
                }

                //ENEMIGO

                if (matriz[fila][columna].equals(enemigo)) {
                    if (personaje.equals("Y")) {
                        vidas1--;
                    } else {
                        vidas2--;
                    }

                    //MURO

                } else if (matriz[fila][columna].equals(muro)) {
                    System.out.println("No se puede pasar, hay un muro");
                    fila = (fila + 1) % MAX_FILAS; // Restaurar posición
                }

                //FINAL VOLVER
                else if (matriz[fila][columna].equals("F")) {
                    System.out.println(personaje + " ha llegado al final y volverá al inicio.");
                    fila = 0;
                    columna = 0;
                }

                //ACTUALIZAR POSICION

                matriz[fila][columna] = personaje;
                break;


            case "D", "d":
                matriz[fila][columna] = ".";
                if (columna == MAX_COLUMNAS - 1) {
                    columna = 0;
                } else {
                    columna++;
                }
                if (matriz[fila][columna].equals(enemigo)) {
                    if (personaje.equals("Y")) {
                        vidas1--;
                    } else {
                        vidas2--;
                    }
                } else if (matriz[fila][columna].equals(muro)) {
                    System.out.println("No se puede pasar, hay un muro");
                    columna = (columna - 1 + MAX_COLUMNAS) % MAX_COLUMNAS; // Restaurar posición
                }
                //FINAL VOLVER
                else if (matriz[fila][columna].equals("F")) {
                    System.out.println(personaje + " ha llegado al final y volverá al inicio.");
                    fila = 0;
                    columna = 0;
                }
                matriz[fila][columna] = personaje;
                break;
            case "S", "s":
                matriz[fila][columna] = ".";
                if (fila == MAX_FILAS - 1) {
                    fila = 0;
                } else {
                    fila++;
                }
                if (matriz[fila][columna].equals(enemigo)) {
                    if (personaje.equals("Y")) {
                        vidas1--;
                    } else {
                        vidas2--;
                    }
                } else if (matriz[fila][columna].equals(muro)) {
                    System.out.println("No se puede pasar, hay un muro");
                    fila = (fila - 1 + MAX_FILAS) % MAX_FILAS; // Restaurar posición
                }
                //FINAL VOLVER
                else if (matriz[fila][columna].equals("F")) {
                    System.out.println(personaje + " ha llegado al final y volverá al inicio.");
                    fila = 0;
                    columna = 0;
                }
                matriz[fila][columna] = personaje;
                break;
            case "A", "a":
                matriz[fila][columna] = ".";
                if (columna == 0) {
                    columna = MAX_COLUMNAS - 1;
                } else {
                    columna--;
                }
                if (matriz[fila][columna].equals(enemigo)) {
                    if (personaje.equals("Y")) {
                        vidas1--;
                    } else {
                        vidas2--;
                    }
                } else if (matriz[fila][columna].equals(muro)) {
                    System.out.println("No se puede pasar, hay un muro");
                    columna = (columna + 1) % MAX_COLUMNAS; // Restaurar posición
                }
                //FINAL VOLVER
                else if (matriz[fila][columna].equals("F")) {
                    System.out.println(personaje + " ha llegado al final y volverá al inicio.");
                    fila = 0;
                    columna = 0;
                }
                matriz[fila][columna] = personaje;
                break;
            case "Q", "q": // Diagonal arriba-izquierda
                matriz[fila][columna] = "."; // Limpia la posición actual
                fila = (fila - 1 + MAX_FILAS) % MAX_FILAS; // Mueve una fila arriba (con wrap-around)
                columna = (columna - 1 + MAX_COLUMNAS) % MAX_COLUMNAS; // Mueve una columna a la izquierda (con wrap-around)
                if (matriz[fila][columna].equals(enemigo)) { // Comprueba si hay un enemigo
                    if (personaje.equals("Y")) {
                        vidas1--;
                    } else {
                        vidas2--;
                    }
                } else if (matriz[fila][columna].equals(muro)) { // Comprueba si hay un muro
                    System.out.println("No se puede pasar, hay un muro");
                    fila = (fila + 1) % MAX_FILAS; // Restaurar posición
                    columna = (columna + 1) % MAX_COLUMNAS;
                }
                //FINAL VOLVER
                else if (matriz[fila][columna].equals("F")) {
                    System.out.println(personaje + " ha llegado al final y volverá al inicio.");
                    fila = 0;
                    columna = 0;
                }
                matriz[fila][columna] = personaje; // Actualiza la posición del personaje
                break;

            case "E", "e": // Diagonal arriba-derecha
                matriz[fila][columna] = ".";
                fila = (fila - 1 + MAX_FILAS) % MAX_FILAS;
                columna = (columna + 1) % MAX_COLUMNAS;
                if (matriz[fila][columna].equals(enemigo)) {
                    if (personaje.equals("Y")) {
                        vidas1--;
                    } else {
                        vidas2--;
                    }
                } else if (matriz[fila][columna].equals(muro)) {
                    System.out.println("No se puede pasar, hay un muro");
                    fila = (fila + 1) % MAX_FILAS;
                    columna = (columna - 1 + MAX_COLUMNAS) % MAX_COLUMNAS;
                }
                //FINAL VOLVER
                else if (matriz[fila][columna].equals("F")) {
                    System.out.println(personaje + " ha llegado al final y volverá al inicio.");
                    fila = 0;
                    columna = 0;
                }
                matriz[fila][columna] = personaje;
                break;

            case "Z", "z": // Diagonal abajo-izquierda
                matriz[fila][columna] = ".";
                fila = (fila + 1) % MAX_FILAS;
                columna = (columna - 1 + MAX_COLUMNAS) % MAX_COLUMNAS;
                if (matriz[fila][columna].equals(enemigo)) {
                    if (personaje.equals("Y")) {
                        vidas1--;
                    } else {
                        vidas2--;
                    }
                } else if (matriz[fila][columna].equals(muro)) {
                    System.out.println("No se puede pasar, hay un muro");
                    fila = (fila - 1 + MAX_FILAS) % MAX_FILAS;
                    columna = (columna + 1) % MAX_COLUMNAS;
                }
                //FINAL VOLVER
                else if (matriz[fila][columna].equals("F")) {
                    System.out.println(personaje + " ha llegado al final y volverá al inicio.");
                    fila = 0;
                    columna = 0;
                }
                matriz[fila][columna] = personaje;
                break;

            case "C", "c": // Diagonal abajo-derecha
                matriz[fila][columna] = ".";
                fila = (fila + 1) % MAX_FILAS;
                columna = (columna + 1) % MAX_COLUMNAS;
                if (matriz[fila][columna].equals(enemigo)) {
                    if (personaje.equals("Y")) {
                        vidas1--;
                    } else {
                        vidas2--;
                    }
                } else if (matriz[fila][columna].equals(muro)) {
                    System.out.println("No se puede pasar, hay un muro");
                    fila = (fila - 1 + MAX_FILAS) % MAX_FILAS;
                    columna = (columna - 1 + MAX_COLUMNAS) % MAX_COLUMNAS;
                }
                //FINAL VOLVER
                else if (matriz[fila][columna].equals("F")) {
                    System.out.println(personaje + " ha llegado al final y volverá al inicio.");
                    fila = 0;
                    columna = 0;
                }
                matriz[fila][columna] = personaje;
                break;


            case "J", "j": // Opción para salto controlado
                System.out.println("¡Saltar!");
                System.out.println("Elige dirección del salto (W,A,S,D para movimientos lineales, Q,E,Z,C para diagonales):");
                String direccion = scanner.nextLine();
                System.out.println("¿Cuántas casillas deseas saltar? (2 o 3):");
                int salto = scanner.nextInt();
                scanner.nextLine(); // Consumir salto de línea

                if (salto != 2 && salto != 3) {
                    System.out.println("Salto inválido. Solo puedes saltar 2 o 3 casillas.");
                    break;
                }

                matriz[fila][columna] = "."; // Borra la posición actual

                switch (direccion) {
                    case "W", "w": // Arriba
                        fila = (fila - salto + MAX_FILAS) % MAX_FILAS;
                        break;
                    case "A", "a": // Izquierda
                        columna = (columna - salto + MAX_COLUMNAS) % MAX_COLUMNAS;
                        break;
                    case "S", "s": // Abajo
                        fila = (fila + salto) % MAX_FILAS;
                        break;
                    case "D", "d": // Derecha
                        columna = (columna + salto) % MAX_COLUMNAS;
                        break;
                    case "Q", "q": // Diagonal arriba-izquierda
                        fila = (fila - salto + MAX_FILAS) % MAX_FILAS;
                        columna = (columna - salto + MAX_COLUMNAS) % MAX_COLUMNAS;
                        break;
                    case "E", "e": // Diagonal arriba-derecha
                        fila = (fila - salto + MAX_FILAS) % MAX_FILAS;
                        columna = (columna + salto) % MAX_COLUMNAS;
                        break;
                    case "Z", "z": // Diagonal abajo-izquierda
                        fila = (fila + salto) % MAX_FILAS;
                        columna = (columna - salto + MAX_COLUMNAS) % MAX_COLUMNAS;
                        break;
                    case "C", "c": // Diagonal abajo-derecha
                        fila = (fila + salto) % MAX_FILAS;
                        columna = (columna + salto) % MAX_COLUMNAS;
                        break;
                    default:
                        System.out.println("Dirección inválida. Salto cancelado.");
                        return;
                }

                // Comprobaciones de colisión
                if (matriz[fila][columna].equals(enemigo)) {
                    if (personaje.equals("Y")) {
                        vidas1--;
                    } else {
                        vidas2--;
                    }
                } else if (matriz[fila][columna].equals(muro)) {
                    System.out.println("No se puede pasar, hay un muro");
                    return;
                }

                else if (matriz[fila][columna].equals("F")) {
                    System.out.println(personaje + " ha llegado al final y volverá al inicio.");
                    fila = 0;
                    columna = 0;
                }

                matriz[fila][columna] = personaje; // Coloca el personaje en la nueva posición
                break;


            default:
                System.out.println("Movimiento no válido.");
                break;
        }


        // Actualizar las posiciones globales
        if (personaje.equals("Y")) {
            filaYoda = fila;
            columnaYoda = columna;
        } else if (personaje.equals("V")) {
            filaVader = fila;
            columnaVader = columna;
        }
    }


    public static void main(String[] args) {
        rellenarTablero(matriz1);
        rellenarTablero(matriz2);
        rellenarPersonajes(matriz1, "Y", 1);
        rellenarPersonajes(matriz2, "V", 1);
        rellenarPersonajes(matriz1, "D", 5);
        rellenarPersonajes(matriz2, "R", 5);
        rellenarPersonajes(matriz1, "M", 5);
        rellenarPersonajes(matriz2, "M", 5);
        printearTablero(matriz1);


        System.out.println();
        System.out.println();
        System.out.println();


        printearTablero(matriz2);
        do {
            movimiento(matriz1, "Y", "D", "M");
            printearTablero(matriz1);
            System.out.println();
            movimiento(matriz2, "V", "R", "M");
            System.out.println();
            printearTablero(matriz2);
        } while (vidas1 > 0 || vidas2 > 0);


        printearTablero(matriz1);
        System.out.println();
        printearTablero(matriz2);

        if (vidas1 == 0) {
            System.out.println("Yoda ha perdido todas sus vidas.");
        } else if (vidas2 == 0) {
            System.out.println("Vader ha perdido todas sus vidas.");
        }


    }
}
