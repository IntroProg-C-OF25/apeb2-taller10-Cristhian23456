/**
 * Ejercicio 5
Crea un programa que gestione el inventario de una tienda, así como la emisión de facturas.
* Utiliza una matriz bidimensional para almacenar los productos disponibles en la tienda, 
* con información como nombre, precio y cantidad. El programa debe permitir facturar un producto dado su código, 
* y unidades deseadas. Adicional se debe agregar a la factura al 15% del IVA, y si la compra superar los $100,
* se debe aplicar un descuento.

Nota: Considere la alternativa de inexistencias en Stop, para el caso, muestre la alerta respectiva.
 * @author Cristhian Quizhpe
 */
import java.util.Scanner;

public class GestionInventarioFacturas {

    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        String[][] inventario = {
            {"001", "Manzanas", "0.50", "100"},
            {"002", "Naranjas", "0.40", "80"},
            {"003", "Oritos", "0.30", "120"},
            {"004", "Uvas", "1.20", "50"},
            {"005", "Naranjilla", "1.00", "50"},
            {"006", "Peras", "0.75", "50"},
            {"007", "Pitahaya", "1.50", "50"},
            {"008", "Reina Claudia", "0.85", "50"}
        };
        double totalFactura = 0;
        boolean encontrado = false;
        int cantidad, stockActual;
        double precioUnitario, subtotal, iva;
        String codigo;

        System.out.println("\n=== FACTURACION ===");
        System.out.print("Ingrese el codigo del producto: ");
        codigo = input.nextLine();

        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i][0].equals(codigo)) {
                encontrado = true;
                System.out.println("Producto: " + inventario[i][1]);
                System.out.println("Precio unitario: $" + inventario[i][2]);
                System.out.print("Ingrese la cantidad deseada: ");
                cantidad = input.nextInt();

                stockActual = Integer.parseInt(inventario[i][3]);
                if (cantidad > stockActual) {
                    System.out.println("Error: No hay suficientes existencias.");
                } else {
                    precioUnitario = Double.parseDouble(inventario[i][2]);
                    subtotal = precioUnitario * cantidad;
                    iva = subtotal * 0.15;
                    totalFactura = subtotal + iva;

                    if (totalFactura > 100) {
                        totalFactura -= totalFactura * 0.1; 
                        System.out.println("Se aplicó un descuento del 10%.");
                    }

                    inventario[i][3] = String.valueOf(stockActual - cantidad);

                    System.out.println("\n--- FACTURA ---");
                    System.out.printf("Producto: %s\n", inventario[i][1]);
                    System.out.printf("Cantidad: %d\n", cantidad);
                    System.out.printf("Subtotal: $%.2f\n", subtotal);
                    System.out.printf("IVA (15%%): $%.2f\n", iva);
                    System.out.printf("Total a pagar: $%.2f\n", totalFactura);
                }
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }

    }
}
/***
 * run:

=== FACTURACION ===
Ingrese el codigo del producto: 006
Producto: Peras
Precio unitario: $0.75
Ingrese la cantidad deseada: 8

--- FACTURA ---
Producto: Peras
Cantidad: 8
Subtotal: $6,00
IVA (15%): $0,90
Total a pagar: $6,90
BUILD SUCCESSFUL (total time: 28 seconds)
 */

