/***
 * Ejercicio 1
Dada una matriz cuadrada (m X m) de valores enteros aleatorios, desarrollar su procesamiento para presentar los elementos:

De la diagonal principal.
De la diagonal segundaria.
Ubicados bajo la diagonal principal.
Ubicados sobre la diagonal principal.
Ubicados bajo la diagonal secundaria.
Ubicados sobre la diagonal secundaria.
* @author Cristhian Quizhpe
 */

import java.util.Scanner;
public class MatrizMxM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tam_m = 0;
        
        System.out.print("Ingrese el tamaño de la matriz cuadrada: ");
        tam_m=input.nextInt();
        
        int [][]mat=new int[tam_m][tam_m];
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                mat[i][j]=(int)(Math.random()*10);
                System.out.print(mat[i][j]+"\t");
            }
            System.out.println(" ");
        }
        
        System.out.println("\nDiagonal Principal");
        for (int i = 0; i < mat.length; i++) {
            System.out.print(mat[i][i]+"\t");
        }
        
        System.out.println("\nDiagonal Secundaria");
        for (int i = 0; i < mat.length; i++) {
            System.out.print(mat[i][mat.length-i-1]+"\t");
        }
        
        System.out.println("\nUbicados bajo la diagonal principal");
        for (int i = 1; i < mat.length; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(mat[i][j]+"\t");
            }
        }
        // Elementos sobre la diagonal principal
        System.out.println("\n\nSobre diagonal principal:");
        for (int i = 0; i < mat.length; i++) {
            for (int j = i + 1; j < mat.length; j++) {
                System.out.print(mat[i][j] + " ");
            }
        }

        // Elementos bajo la diagonal secundaria
        System.out.println("\n\nBajo diagonal secundaria:");
        for (int i = 0; i < mat.length; i++) {
            for (int j = mat.length - i; j < mat.length; j++) {
                System.out.print(mat[i][j] + " ");
            }
        }

        // Elementos sobre la diagonal secundaria
        System.out.println("\n\nSobre diagonal secundaria:");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length - i - 1; j++) {
                System.out.print(mat[i][j] + " ");
            }
        }
        
        
        
    }

   
}
/***
 * run:
Ingrese el tama�o de la matriz cuadrada: 5
2	0	0	8	1	 
9	7	0	1	7	 
1	5	9	0	6	 
7	4	7	2	0	 
5	0	6	7	8	 

Diagonal Principal
2	7	9	2	8	
Diagonal Secundaria
1	1	9	4	5	
Ubicados bajo la diagonal principal
9	1	5	7	4	7	5	0	6	7	

Sobre diagonal principal:
0 0 8 1 0 1 7 0 6 0 

Bajo diagonal secundaria:
7 0 6 7 2 0 0 6 7 8 

Sobre diagonal secundaria:
2 0 0 8 9 7 0 1 5 7 BUILD SUCCESSFUL (total time: 13 seconds)
 */
