/*ARRAYS
        1º) Carga el código
        2º) Ejecuta
        3º) Separa cada uno de los trozos de código en funciones/procedimientos que lleven el nombre de la acción que corresponda:

        Rellenar el array en orden ascendente: Se llena el array con valores del 0 al 9. Esto permite practicar cómo llenar un array de manera secuencial.
        Mostrar el array en orden inverso: Imprime los elementos del array en orden inverso, comenzando desde el último hasta el primero.
        Rellenar con números pares: Llena el array con los primeros números pares (0, 2, 4, ..., 18), permitiendo ver cómo manipular los valores de manera matemática durante la asignación.
        Mostrar elementos de dos en dos: Imprime los valores en pares (por ejemplo, [0, 2], [4, 6]), lo que permite observar cómo acceder a varios elementos a la vez con un salto en el índice (i += 2).
        Rellenar con números impares: Llena el array con los primeros números impares (1, 3, 5, ..., 19), usando una fórmula que permite trabajar con operaciones aritméticas.
        Duplicar cada elemento: Recorre el array y multiplica cada elemento por 2, lo que muestra cómo modificar los valores dentro del array.
        Calcular la suma de los elementos: Suma todos los elementos del array usando un bucle for-each, permitiendo revisar cómo iterar y acumular valores.
        Encontrar el valor máximo y mínimo: Recorre el array y encuentra el valor máximo y el valor mínimo, permitiendo practicar la comparación de elementos dentro de un array.


        4º) Recuerda para el examen de tipo test Java…
*/

import java.util.Arrays;

public class PracticaArrays {

    private static final int[] array = new int[10];

    public static void main(String[] args) {
        rellenarAscendente();
        mostrarInverso();
        rellenarPares();
        mostrarPares();
        rellenarImpares();
        duplicarElementos();
        calcularSuma();
        buscarMaxMin();
    }

    // Rellenar el array en orden ascendente (0, 1, 2, ..., 9)
    private static void rellenarAscendente() {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        System.out.println("Array en orden ascendente: " + Arrays.toString(array));
    }

    // Mostrar el array en orden inverso
    private static void mostrarInverso() {
        System.out.print("Array en orden inverso: ");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Rellenar el array con números pares (0, 2, 4, ..., 18)
    private static void rellenarPares() {
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2;
        }
        System.out.println("Array con números pares: " + Arrays.toString(array));
    }

    // Mostrar elementos de dos en dos (primer y segundo, tercer y cuarto, etc.)
    private static void mostrarPares() {
        System.out.print("Elementos de dos en dos: ");
        for (int i = 0; i < array.length; i += 2) {
            System.out.print("[" + array[i] + ", " + (i + 1 < array.length ? array[i + 1] : " ") + "] ");
        }
        System.out.println();
    }

    // Rellenar el array con números impares (1, 3, 5, ..., 19)
    private static void rellenarImpares() {
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2 + 1;
        }
        System.out.println("Array con números impares: " + Arrays.toString(array));
    }

    // Duplicar cada elemento del array
    private static void duplicarElementos() {
        for (int i = 0; i < array.length; i++) {
            array[i] *= 2;
        }
        System.out.println("Array con cada elemento duplicado: " + Arrays.toString(array));
    }

    // Calcular la suma de todos los elementos
    private static void calcularSuma() {
        int suma = 0;
        for (int num : array) {
            suma += num;
        }
        System.out.println("Suma de todos los elementos: " + suma);
    }

    // Buscar el valor máximo y mínimo del array
    private static void buscarMaxMin() {
        int max = array[0];
        int min = array[0];
        for (int num : array) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        System.out.println("Valor máximo: " + max);
        System.out.println("Valor mínimo: " + min);
    }
}