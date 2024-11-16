import java.util.Scanner;

public class PatataCalienteAlberto {
    public static void main(String[] args) {
        // Declaración de variables
        String pregunta;
        int respuestaReal, respuestaUsuario, intentos;

        // Inicialización
        pregunta = "¿En qué año comenzó la 2ª Guerra Mundial?";
        respuestaReal = 1939;
        intentos = 10;
        respuestaUsuario = 0;

        // Crear un escáner para leer entradas del usuario
        Scanner scanner = new Scanner(System.in);

        // Ejecución del juego
        System.out.println("¡Comienza el juego!");

        for (int contador = 1; contador <= intentos; contador++) {
            System.out.println(pregunta);
            System.out.println("Dime una respuesta numérica:");
            respuestaUsuario = scanner.nextInt();

            if (respuestaUsuario > respuestaReal) {
                System.out.println("Error");
                System.out.println("La respuesta correcta es menor.");
            } else if (respuestaUsuario < respuestaReal) {
                System.out.println("Error");
                System.out.println("La respuesta correcta es mayor.");
            } else {
                System.out.println("¡Correcto!");
                System.out.println("¡Has acertado!");
                System.out.println("¡Eres el mejor!");
                break; // Termina el bucle si se acierta
            }
        }

        // Cerrar el escáner
        scanner.close();
    }
}
