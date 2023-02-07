import java.util.Scanner;

public class Criba {
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
