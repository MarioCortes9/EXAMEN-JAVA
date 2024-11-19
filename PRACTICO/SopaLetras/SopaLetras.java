
/*EXAMEN VERSION 5
    VERSION7
    VERSION 10

    // NO VA A CONSIDERAR FUNCIONES Y PROCEDIMIENTOS , LE PARECE MEJOR

 */



import java.util.Random;

public class SopaLetras {

    static String palabras[] = {
            "helada", "mesa", "patata"
    };

    static char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    static char[][] sopaLetras = new char[10][10];
    static char[][] sopaLetrasCopia = new char[10][10]; //si la replico , mejor
    static Random aleatorio = new Random();


    static void rellenarMatriz() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int numAle = aleatorio.nextInt(26);
                sopaLetras[i][j] = letras[numAle];
            }
        }
    }

    static void rellenarMatrizCopia() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                sopaLetrasCopia[i][j] = '0';  // la relleno a 0 para detectar si esta ocupada o no
            }
        }
    }

    public static void imprimirMatriz() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(sopaLetras[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void imprimirMatrizCopia() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(sopaLetrasCopia[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        rellenarMatriz();
        rellenarMatrizCopia();
        imprimirMatriz();
        System.out.println();
        imprimirMatrizCopia();

        for (int i = 0; i < palabras.length; i++) {
            // CUANTAS PALABRAS HAY EN EL ARRAY?
            //1º BUSCAR POSICION LIBRE
            int filaAl = 0;
            int columnaAl = 0;
            //1º casilla inicial de la palabra libre
            do {
                filaAl = aleatorio.nextInt(10);
                columnaAl = aleatorio.nextInt(10);
            } while (sopaLetrasCopia[filaAl][columnaAl] != '0');

            //2º no superar limites
            // limite si escribo a la derecha , columna
            if (columnaAl + (palabras[i].length() - 1) > 10) { // 5+ 5
                i--;
            } else {
                boolean isLibre = true;
                int max = columnaAl + (palabras[i].length() - 1);    // 5 + 6-1    = 10
                for (int z = columnaAl; z <= max; z++) {//z={5,6,7,8,9,10}
                    if (sopaLetrasCopia[filaAl][z] != '0') {
                        isLibre = false;
                        break;
                    }
                }
                if (isLibre) {//puedo empezar a escribir!!!
                    int contador = 0;
                    for (int z = columnaAl; z <= max; z++) {//z={5,6,7,8,9,10}
                        sopaLetras[filaAl][z] = palabras[i].charAt(contador);
                        sopaLetrasCopia[filaAl][z] = palabras[i].charAt(contador);
                        contador++;
                    }
                }
            }
        }

    }


}
