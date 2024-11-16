/*CONVERSIONES
        1º) Carga código
        2º) Debug
        3º) Recuerda para el examen de tipo test Java…

        Lectura del número: Pedimos al usuario que introduzca un número entero. Este número será la base de nuestras conversiones.
        Convertir número a cadena: Usamos Integer.toString(numero) para convertir el número a una cadena. Esto nos permite tratar el número como texto, donde cada dígito es un carácter separado.
        Convertir cadena a un array de caracteres: Usamos cadena.toCharArray() para convertir la cadena en un array de caracteres. Esto facilita la manipulación y lectura de cada dígito de forma independiente.
        Recorrer cada carácter: Usamos un bucle for para leer cada carácter en el array caracteres e imprimimos cada uno.
        Convertir cada carácter a un número: Usamos Character.getNumericValue(c) para convertir cada carácter a su valor numérico. Esto nos permite pasar de un carácter como '5' al número 5.

*/

import java.util.Scanner;

public class ConversionesCadenasCaracteres {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Paso 1: Leer un número entero del usuario
        System.out.print("Introduce un número entero: ");
        int numero = scanner.nextInt();

        // Paso 2: Convertir el número a una cadena
        String cadena = Integer.toString(numero);
        System.out.println("Número convertido a cadena: " + cadena);

        // Paso 3: Convertir la cadena a un array de caracteres
        char[] caracteres = cadena.toCharArray();
        System.out.println("Cadena convertida a caracteres:");

        // Paso 4: Leer cada carácter de la cadena y mostrarlo
        for (char c : caracteres) {
            System.out.println("Carácter: " + c);
        }

        // Paso 5: Convertir cada carácter a su valor numérico original
        System.out.println("Conversión de cada carácter a número:");
        for (char c : caracteres) {
            int digito = Character.getNumericValue(c); // Convierte el carácter en un número
            System.out.println("Carácter '" + c + "' convertido a número: " + digito);
        }

        scanner.close();
    }
}

