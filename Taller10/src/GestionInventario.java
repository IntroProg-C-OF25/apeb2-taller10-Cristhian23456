/***
 * Ejercicio 4
 * Crea un programa que gestione el inventario de una tienda. Utiliza una matriz bidimensional para almacenar 
 * los productos disponibles en la tienda, con información como nombre, precio y cantidad. El programa debe 
 * permitir agregar nuevos productos, actualizar existencias, buscar productos y eliminarlos.
 * @author Cristhian Quizhpe
 */
import java.util.Scanner;

public class GestionInventario {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String[][] inventario = new String[101][3]; 
        int totalProductos = 0;
        String nombre, precio, cantidad;
        boolean encontrado;

        int opcion;
        do {
            System.out.println("\n=== MENU DE GESTION DE INVENTARIO ===");
            System.out.println("1. Agregar producto");
            System.out.println("2. Actualizar existencias");
            System.out.println("3. Buscar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Mostrar inventario");
            System.out.println("6. Salir");
            System.out.print("Elige una opcion: ");
            opcion = input.nextInt();
            input.nextLine();

            if (opcion == 1) {
            
                if (totalProductos < inventario.length) {
                    System.out.println("\n--- Agregar Producto ---");
                    System.out.print("Nombre del producto: ");
                    nombre = input.nextLine();
                    System.out.print("Precio del producto: ");
                    precio = input.nextLine();
                    System.out.print("Cantidad disponible: ");
                    cantidad = input.nextLine();

                    inventario[totalProductos][0] = nombre;
                    inventario[totalProductos][1] = precio;
                    inventario[totalProductos][2] = cantidad;
                    totalProductos++;

                    System.out.println("Producto agregado exitosamente.");
                } else {
                    System.out.println("El inventario está lleno. No se pueden agregar más productos.");
                }
            } else if (opcion == 2) {
               
                System.out.println("\n--- Actualizar Existencias ---");
                System.out.print("Nombre del producto: ");
                nombre = input.nextLine();
                encontrado = false;

                for (int i = 0; i < totalProductos; i++) {
                    if (inventario[i][0].equalsIgnoreCase(nombre)) {
                        System.out.print("Nueva cantidad: ");
                        inventario[i][2] = input.nextLine();
                        System.out.println("Existencias actualizadas correctamente.");
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    System.out.println("Producto no encontrado en el inventario.");
                }
            } else if (opcion == 3) {
               
                System.out.println("\n--- Buscar Producto ---");
                System.out.print("Nombre del producto: ");
                nombre = input.nextLine();
                encontrado = false;

                for (int i = 0; i < totalProductos; i++) {
                    if (inventario[i][0].equalsIgnoreCase(nombre)) {
                        System.out.println("--Producto encontrado--");
                        System.out.println("Nombre: " + inventario[i][0]);
                        System.out.println("Precio: $" + inventario[i][1]);
                        System.out.println("Cantidad: " + inventario[i][2]);
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    System.out.println("Producto no encontrado en el inventario.");
                }
            } else if (opcion == 4) {
 
                System.out.println("\n--- Eliminar Producto ---");
                System.out.print("Nombre del producto: ");
                nombre = input.nextLine();
                encontrado = false;

                for (int i = 0; i < totalProductos; i++) {
                    if (inventario[i][0].equalsIgnoreCase(nombre)) {
                        for (int j = i; j < totalProductos - 1; j++) {
                            inventario[j][0] = inventario[j + 1][0];
                            inventario[j][1] = inventario[j + 1][1];
                            inventario[j][2] = inventario[j + 1][2];
                        }
                        totalProductos--;
                        System.out.println("Producto eliminado exitosamente.");
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    System.out.println("Producto no encontrado en el inventario.");
                }
            } else if (opcion == 5) {
                
                System.out.println("\n--- Inventario ---");
                if (totalProductos == 0) {
                    System.out.println("El inventario está vacío.");
                } else {
                    System.out.printf("%-20s | %-10s | %-10s\n", "Nombre", "Precio", "Cantidad");
                    System.out.println("---------------------------------------------");
                    for (int i = 0; i < totalProductos; i++) {
                        System.out.printf("%-20s | $%-9s | %-10s\n",
                                inventario[i][0], inventario[i][1], inventario[i][2]);
                    }
                }
            } else if (opcion == 6) {
         
                System.out.println("Saliendo del programa...");
            } else {
                System.out.println("Opción inválida. Intenta nuevamente.");
            }
        } while (opcion != 6);
    }
}
/***
 * === MENU DE GESTION DE INVENTARIO ===
1. Agregar producto
2. Actualizar existencias
3. Buscar producto
4. Eliminar producto
5. Mostrar inventario
6. Salir
Elige una opcion: 1

--- Agregar Producto ---
Nombre del producto: Cafe
Precio del producto: 3,50
Cantidad disponible: 20
Producto agregado exitosamente.

=== MENU DE GESTION DE INVENTARIO ===
1. Agregar producto
2. Actualizar existencias
3. Buscar producto
4. Eliminar producto
5. Mostrar inventario
6. Salir
Elige una opcion: 1

--- Agregar Producto ---
Nombre del producto: Aceite Favorita
Precio del producto: 3,00
Cantidad disponible: 12
Producto agregado exitosamente.

=== MENU DE GESTION DE INVENTARIO ===
1. Agregar producto
2. Actualizar existencias
3. Buscar producto
4. Eliminar producto
5. Mostrar inventario
6. Salir
Elige una opcion: 1

--- Agregar Producto ---
Nombre del producto: Aceite Girasol
Precio del producto: 5,00
Cantidad disponible: 15
Producto agregado exitosamente.

=== MENU DE GESTION DE INVENTARIO ===
1. Agregar producto
2. Actualizar existencias
3. Buscar producto
4. Eliminar producto
5. Mostrar inventario
6. Salir
Elige una opcion: 3

--- Buscar Producto ---
Nombre del producto: Aceite Girasol
--Producto encontrado--
Nombre: Aceite Girasol
Precio: $5,00
Cantidad: 15

=== MENU DE GESTION DE INVENTARIO ===
1. Agregar producto
2. Actualizar existencias
3. Buscar producto
4. Eliminar producto
5. Mostrar inventario
6. Salir
Elige una opcion: 2

--- Actualizar Existencias ---
Nombre del producto: Aceite Favorita
Nueva cantidad: 10
Existencias actualizadas correctamente.

=== MENU DE GESTION DE INVENTARIO ===
1. Agregar producto
2. Actualizar existencias
3. Buscar producto
4. Eliminar producto
5. Mostrar inventario
6. Salir
Elige una opcion: 4

--- Eliminar Producto ---
Nombre del producto: Cafe
Producto eliminado exitosamente.

=== MENU DE GESTION DE INVENTARIO ===
1. Agregar producto
2. Actualizar existencias
3. Buscar producto
4. Eliminar producto
5. Mostrar inventario
6. Salir
Elige una opcion: 5

--- Inventario ---
Nombre               | Precio     | Cantidad  
---------------------------------------------
Aceite Favorita      | $3,00      | 10        
Aceite Girasol       | $5,00      | 15        

=== MENU DE GESTION DE INVENTARIO ===
1. Agregar producto
2. Actualizar existencias
3. Buscar producto
4. Eliminar producto
5. Mostrar inventario
6. Salir
Elige una opcion: 6
Saliendo del programa...
BUILD SUCCESSFUL (total time: 3 minutes 23 seconds)
 */