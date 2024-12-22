/***
 * Ejercicio 2
 * Dadas dos matrices (cuadradas y/o rectangulares) de valores enteros aleatorios, desarrollar su procesamiento para calcular y presentar:
 * - La suma de las dos matrices (considerar las restricciones matemáticas para ello).
 * - La multiplicación de las dos matrices (considerar las reglas matemáticas para ello).
 * @author Cristhian Quizhpe
 */
import java.util.Scanner;

public class SumaMultiplicacion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int m,n,p;
        System.out.println("Ingrese las dimensiones de la primera matriz (m x n):");
        System.out.print("Filas (m): ");
        m = input.nextInt();
        System.out.print("Columnas (n): ");
        n = input.nextInt();

        System.out.println("Ingrese las dimensiones de la segunda matriz (n x p):");
        System.out.print("Filas (n): " + n + " (debe coincidir con las columnas de la primera matriz).\n");
        System.out.print("Columnas (p): ");
        p = input.nextInt();
       
        int[][] matriz1 = new int[m][n];
        int[][] matriz2 = new int[n][p];
        int[][] suma = new int[m][n]; 
        int[][] multiplicacion = new int[m][p];

        System.out.println("\nPrimera Matriz:");
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[0].length; j++) {
                matriz1[i][j] = (int) (Math.random() * 10); 
                System.out.print(matriz1[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\nSegunda Matriz:");
        for (int i = 0; i < matriz2.length; i++) {
            for (int j = 0; j < matriz2[0].length; j++) {
                matriz2[i][j] = (int) (Math.random() * 10); 
                System.out.print(matriz2[i][j] + "\t");
            }
            System.out.println();
        }

        if (matriz1.length == matriz2.length && matriz1[0].length == matriz2[0].length) {
            System.out.println("\nSuma de las matrices:");
            for (int i = 0; i < matriz1.length; i++) {
                for (int j = 0; j < matriz2[0].length; j++) {
                    suma[i][j] = matriz1[i][j] + matriz2[i][j];
                    System.out.print(suma[i][j] + "\t");
                }
                System.out.println();
            }
        } else {
            System.out.println("\nNo se pueden sumar las matrices (dimensiones incompatibles).");
        }

        System.out.println("\nMultiplicacion de las matrices:");
        for (int i = 0; i < matriz1.length; i++) { 
            for (int j = 0; j < matriz2[0].length ; j++) { 
                for (int k = 0; k < matriz1[0].length ; k++) { 
                    multiplicacion[i][j] += matriz1[i][k] * matriz2[k][j];
                }
                System.out.print(multiplicacion[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
/***
 * Ingrese las dimensiones de la primera matriz (m x n):
Filas (m): 3
Columnas (n): 2
Ingrese las dimensiones de la segunda matriz (n x p):
Filas (n): 2 (debe coincidir con las columnas de la primera matriz).
Columnas (p): 3

Primera Matriz:
5	8	
5	3	
8	5	

Segunda Matriz:
9	9	6	
4	1	0	

No se pueden sumar las matrices (dimensiones incompatibles).

Multiplicacion de las matrices:
77	53	30	
57	48	30	
92	77	48	
BUILD SUCCESSFUL (total time: 8 seconds)
 */