import java.util.Random;

public class Main {
    //tablero 10 x 10
    private static char tableroMapaJeoGrafico[][] = new char[10][10];
    private static int tableroPuntuaciones[][] = new int[10][12];
    private static char paises[] = new char[]{'E', 'F', 'G', 'I', 'O','L','P','U', 'A', 'W'};
    private static int puntuaciones[] = new int[]{9 ,8, 7, 6, 5, 4, 3, 2, 1, 0};
    private static int filaCordenada;
    private static int columnaCordenada;
    private static void inicializarMapaGeografico(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tableroMapaJeoGrafico[i][j] = '-';
            }
        }
    }

    private static void asignarPaisesMapa(){
        Random aleatorio = new Random();
        int filaAleatorio;
        int columnaAleatorio;
        for (int i = 0; i < 10; i++) {
            do {
                filaAleatorio = aleatorio.nextInt(10);
                columnaAleatorio = aleatorio.nextInt(10);
            }while(tableroMapaJeoGrafico[filaAleatorio][columnaAleatorio] != '-');
            tableroMapaJeoGrafico[filaAleatorio][columnaAleatorio] = paises[i];
            tableroPuntuaciones[i][0] = filaAleatorio;
            tableroPuntuaciones[i][1] = columnaAleatorio;
        }
    }


    private static void rellenarTableroPuntuaciones() {
        Random aleatorio = new Random();
        // Array de control para verificar las puntuaciones ya usadas en cada columna
        boolean[][] puntuacionesUsadasPorColumna = new boolean[12][10];

        for (int j = 2; j < 12; j++) {
            for (int i = 0; i < 10; i++) {
                int puntuacion;
                do {
                    puntuacion = aleatorio.nextInt(10);
                } while (puntuacionesUsadasPorColumna[j][puntuacion]); // Verificar si ya se ha usado esta puntuación en la columna

                // Asignar la puntuación a la celda
                tableroPuntuaciones[i][j] = puntuaciones[puntuacion];

                // Marcar como usada esta puntuación en la columna
                puntuacionesUsadasPorColumna[j][puntuacion] = true;
            }
        }
    }

    private static void ordenarTableroPuntuaciones(){
        for (int i = 0; i < 10; i++) {
            for (int j = 2; j < 12; j++) {
                for (int k = 2; k < 11; k++) { // Burbuja
                    if (tableroPuntuaciones[i][k] < tableroPuntuaciones[i][k + 1]) {
                        // Intercambiar si está en el orden incorrecto (de menor a mayor)
                        int temp = tableroPuntuaciones[i][k];
                        tableroPuntuaciones[i][k] = tableroPuntuaciones[i][k + 1];
                        tableroPuntuaciones[i][k + 1] = temp;
                    }
                }
            }
        }
    }


    private static void mostrarTableroPuntuaciones(){
        System.out.println();
        System.out.println("Tablero Puntuaciones");
        System.out.println("   X Y E F G I O L P U A W");
        for (int i = 0; i < 10; i++) {
            System.out.print(paises[i] + "| ");
            for (int j = 0; j < 12; j++) {

                System.out.print(tableroPuntuaciones[i][j] + " ");
            }

            System.out.println();
        }
    }

    private static int[] puntuacionTotal = new int[10];
    private static void sumarPuntuacionesYMostrarRanking(){

        // Sumar puntuaciones para cada país
        for (int i = 0; i < 10; i++) {
            int suma = 0;
            for (int j = 2; j < 12; j++) {
                suma += tableroPuntuaciones[i][j];
            }
            puntuacionTotal[i] = suma;  // Guardamos la suma de cada país
        }

        // Mostrar puntuaciones totales de cada país
        System.out.println("\nPuntuaciones Totales:");
        for (int i = 0; i < 10; i++) {
            System.out.println(paises[i] + ": " + puntuacionTotal[i]);
        }

        // Encontrar los tres primeros países
        int primero = -1, segundo = -1, tercero = -1;
        for (int i = 0; i < 10; i++) {
            if (primero == -1 || puntuacionTotal[i] > puntuacionTotal[primero]) {
                tercero = segundo;
                segundo = primero;
                primero = i;
            } else if (segundo == -1 || puntuacionTotal[i] > puntuacionTotal[segundo]) {
                tercero = segundo;
                segundo = i;
            } else if (tercero == -1 || puntuacionTotal[i] > puntuacionTotal[tercero]) {
                tercero = i;
            }
        }

        // Mostrar el ranking
        System.out.println("\nRanking de los 3 primeros países:");
        System.out.println("1. " + paises[primero] + " con " + puntuacionTotal[primero] + " puntos");
        System.out.println("2. " + paises[segundo] + " con " + puntuacionTotal[segundo] + " puntos");
        System.out.println("3. " + paises[tercero] + " con " + puntuacionTotal[tercero] + " puntos");
    }

    private static void puntuacionPublico(){
        //Generar puntuaciones publico
        int publico [] = new int[10];
        Random aleatorio = new Random();
        for (int i = 0; i < 10; i++) {
            publico[i] =  aleatorio.nextInt(200);
        }
        // Mostrar puntuaciones publico
        System.out.println("\nPuntuaciones Publico:");
        for (int i = 0; i < 10; i++) {
            System.out.println(paises[i] + ": " + publico[i]);
        }


        //SUMA TOTAL PUNTUACIONES
        double sumaPuntuaciones[] = new double[10];
        for (int i = 0; i < 10; i++) {
            sumaPuntuaciones[i] = (publico[i] * (0.3)) + (puntuacionTotal[i] * 0.7);
        }

        System.out.println("\nPuntuaciones TOTALES (Suma puntuaciones + puntuaciones publico):");
        for (int i = 0; i < 10; i++) {
            System.out.println(paises[i] + ": " + sumaPuntuaciones[i]);
        }

        // Encontrar los tres primeros países
        int primero = -1, segundo = -1, tercero = -1;
        for (int i = 0; i < 10; i++) {
            if (primero == -1 || sumaPuntuaciones[i] > sumaPuntuaciones[primero]) {
                tercero = segundo;
                segundo = primero;
                primero = i;
            } else if (segundo == -1 || sumaPuntuaciones[i] > sumaPuntuaciones[segundo]) {
                tercero = segundo;
                segundo = i;
            } else if (tercero == -1 || sumaPuntuaciones[i] > sumaPuntuaciones[tercero]) {
                tercero = i;
            }
        }

        // Mostrar el ranking
        System.out.println("\nRanking de los 3 primeros países:");
        System.out.println("1. " + paises[primero] + " con " + sumaPuntuaciones[primero] + " puntos");
        System.out.println("2. " + paises[segundo] + " con " + sumaPuntuaciones[segundo] + " puntos");
        System.out.println("3. " + paises[tercero] + " con " + sumaPuntuaciones[tercero] + " puntos");


    }

    private static void imprimirMapaGeografico(){
        System.out.println();
        System.out.println("Mapa Geografico: ");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(tableroMapaJeoGrafico[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        inicializarMapaGeografico();
        asignarPaisesMapa();
        rellenarTableroPuntuaciones();
        ordenarTableroPuntuaciones();
        imprimirMapaGeografico();
        mostrarTableroPuntuaciones();
        sumarPuntuacionesYMostrarRanking();
        puntuacionPublico();
    }
}