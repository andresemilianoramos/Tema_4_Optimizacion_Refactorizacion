import java.util.Scanner;

/**
 * La clase `Criba` contiene un método estático para generar un vector de
 * números primos hasta un máximo especificado, utilizando el algoritmo de
 * la criba de Eratóstenes.
 *
 * @author Andres Ramos G.
 *
 * @version 3.0 final
 */
public class Criba {
    /**
     * Genera un vector de números primos hasta el máximo especificado.
     *
     * @param max El máximo número a considerar.
     * @return Un vector de números primos hasta `max`.
     */
    public static int[] generarPrimos(int max) {
        if (max < 2) {
            return new int[0];
        }

        boolean[] esPrimo = new boolean[max + 1];
        for (int i = 0; i < esPrimo.length; i++) {
            esPrimo[i] = true;
        }
        esPrimo[0] = esPrimo[1] = false;

        for (int i = 2; i <= Math.sqrt(max); i++) {
            if (esPrimo[i]) {
                for (int j = 2 * i; j <= max; j += i) {
                    esPrimo[j] = false;
                }
            }
        }

        int cuenta = 0;
        for (int i = 0; i < esPrimo.length; i++) {
            if (esPrimo[i]) {
                cuenta++;
            }
        }

        int[] primos = new int[cuenta];
        for (int i = 0, j = 0; i < esPrimo.length; i++) {
            if (esPrimo[i]) {
                primos[j++] = i;
            }
        }

        return primos;
    }

    /**
     * Punto de entrada de la aplicación. Pide al usuario que introduzca un
     * número y muestra un vector de números primos hasta ese número.
     *
     * @param args Los argumentos de la línea de comandos. No se utilizan.
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato = teclado.nextInt();
        int[] vector = generarPrimos(dato);
        System.out.println("\nVector de primos hasta " + dato + ":");
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(vector[i] + "\t");
        }
    }
}
