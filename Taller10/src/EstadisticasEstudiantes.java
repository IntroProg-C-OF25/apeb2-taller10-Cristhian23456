
/** *
 * Ejercicio 3
 * El primer ciclo paralelo C, cuenta con 28 estudiantes, de los cuáles al finalizar el periodo,
 * la Dirección de la carrera de Computación a solicitado las siguientes estadísticas de la materia
 * INTRODUCCIÓN A LA PROGRAMACIÓN en función a los promedios por estudiante, dichos promedios se deben calcular
 * (ponderar, ya que el docente ingresa todo sobre 10pts.) de 3 calificaciones (ACD que representa el 35% de la nota,
 * APE del 35% y la nota del AA con un peso del 30%). En resumen, los requerimientos son los siguientes:
 *
 * Registre los nombres de cada estudiante de dicho paralelo.
 * Genere aleatoriamente las notas ACD, APE, AA, para cada uno de los 28 estudiantes de 0-10 pts.
 * Calcule el promedio de cada uno de los estudiantes del paralelo dada la siguiente ponderación: ACD->35%, APE->35%, y el AA->30%.
 * Obtenga el promedio del curso, del paralelo C.
 * Liste los nombres de los estudiantes y su nota, que hayan obtenido un promedio por encima del promedio del curso.
 * Liste los nombres de los estudiantes y su nota, que hayan obtenido un promedio por debajo del promedio del curso.
 * Muestre el estudiante con su calificación, si es el del mayor promedio (el más alto de la clase).
 * Muestre el estudiante con su calificación, si es el del menor promedio (el más bajo de la clase).
 *
 * @author Cristhian Quizhpe
 */

public class EstadisticasEstudiantes {

    public static void main(String[] args) {

        String[] estudiantes = {"Juan S.", "Juan D.", "Ricardo", "Carlos", "Ana", "Maria", "Pedro",
            "Luis", "Sofia", "Lucia", "Fernando", "Diego", "Carmen", "Andrea",
            "Jorge", "Valeria", "Santiago", "Diana", "Roberto", "Paola", "Miguel",
            "Gabriela", "Camila", "Rafael", "Isabela", "Manuel", "Esteban", "Laura"};

        double[][] calificaciones = new double[estudiantes.length][3];
        double[] promedios = new double[estudiantes.length];
        double promedioCurso = 0.0;
        double maxPromedio = 0;
        double minPromedio = 5;
        String estudianteMax = "null";
        String estudianteMin = "null";

        for (int i = 0; i < estudiantes.length; i++) {

            calificaciones[i][0] = Math.random() * 3.5;
            calificaciones[i][1] = Math.random() * 3.5;
            calificaciones[i][2] = Math.random() * 3;

            promedios[i] = (calificaciones[i][0] + calificaciones[i][1] + calificaciones[i][2]);
            promedioCurso += promedios[i];
        }

        promedioCurso = promedioCurso / estudiantes.length;

        System.out.printf("%-10s | %-6s | %-6s | %-6s | %-9s\n", "NOMBRES", "ACD", "APE", "AA", "PROMEDIOS");
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.printf("%-10s | %-6.2f | %-6.2f | %-6.2f | %-9.2f\n",
                    estudiantes[i], calificaciones[i][0], calificaciones[i][1], calificaciones[i][2], promedios[i]);
        }

        System.out.printf("\nPromedio del curso: %.2f", promedioCurso);

        System.out.println("\nEstudiantes por encima del promedio del curso:");
        for (int i = 0; i < estudiantes.length; i++) {
            if (promedios[i] > promedioCurso) {
                System.out.printf("%-10s | %-9.2f\n", estudiantes[i], promedios[i]);
            }
        }

        System.out.println("\nEstudiantes por debajo del promedio del curso:");
        for (int i = 0; i < estudiantes.length; i++) {
            if (promedios[i] < promedioCurso) {
                System.out.printf("%-10s | %-9.2f\n", estudiantes[i], promedios[i]);
            }
        }

        for (int i = 1; i < estudiantes.length; i++) {
            if (promedios[i] > maxPromedio) {
                maxPromedio = promedios[i];
                estudianteMax = estudiantes[i];
            }
            if (promedios[i] < minPromedio) {
                minPromedio = promedios[i];
                estudianteMin = estudiantes[i];
            }
        }

        System.out.println("\nEstudiante con el mayor promedio:");
        System.out.printf("%-10s | %-9.2f\n", estudianteMax, maxPromedio);

        System.out.println("\nEstudiante con el menor promedio:");
        System.out.printf("%-10s | %-9.2f\n", estudianteMin, minPromedio);
    }
}
/***
 * run:
NOMBRES    | ACD    | APE    | AA     | PROMEDIOS
Juan S.    | 1,97   | 0,02   | 1,24   | 3,23     
Juan D.    | 0,32   | 2,42   | 1,68   | 4,41     
Ricardo    | 1,83   | 1,42   | 2,40   | 5,66     
Carlos     | 2,73   | 3,42   | 0,45   | 6,59     
Ana        | 1,92   | 1,00   | 1,35   | 4,26     
Maria      | 2,67   | 1,15   | 1,79   | 5,61     
Pedro      | 0,78   | 3,47   | 0,05   | 4,29     
Luis       | 1,04   | 1,49   | 0,61   | 3,14     
Sofia      | 1,22   | 3,31   | 1,93   | 6,47     
Lucia      | 0,39   | 0,68   | 1,56   | 2,62     
Fernando   | 1,37   | 1,81   | 0,19   | 3,37     
Diego      | 0,12   | 2,33   | 2,37   | 4,82     
Carmen     | 3,42   | 0,90   | 1,58   | 5,90     
Andrea     | 2,12   | 1,84   | 0,73   | 4,69     
Jorge      | 3,01   | 1,90   | 0,60   | 5,51     
Valeria    | 2,97   | 2,68   | 0,29   | 5,94     
Santiago   | 1,44   | 0,71   | 2,81   | 4,95     
Diana      | 2,41   | 1,36   | 1,93   | 5,70     
Roberto    | 3,48   | 1,43   | 0,33   | 5,24     
Paola      | 1,64   | 1,60   | 0,60   | 3,85     
Miguel     | 2,23   | 1,68   | 0,23   | 4,14     
Gabriela   | 1,66   | 2,99   | 0,53   | 5,18     
Camila     | 1,79   | 0,61   | 1,23   | 3,63     
Rafael     | 0,52   | 0,17   | 1,84   | 2,53     
Isabela    | 2,50   | 0,74   | 2,37   | 5,61     
Manuel     | 1,98   | 1,12   | 1,45   | 4,56     
Esteban    | 0,10   | 1,28   | 2,04   | 3,42     
Laura      | 2,58   | 2,93   | 0,29   | 5,81     

Promedio del curso: 4,68
Estudiantes por encima del promedio del curso:
Ricardo    | 5,66     
Carlos     | 6,59     
Maria      | 5,61     
Sofia      | 6,47     
Diego      | 4,82     
Carmen     | 5,90     
Andrea     | 4,69     
Jorge      | 5,51     
Valeria    | 5,94     
Santiago   | 4,95     
Diana      | 5,70     
Roberto    | 5,24     
Gabriela   | 5,18     
Isabela    | 5,61     
Laura      | 5,81     

Estudiantes por debajo del promedio del curso:
Juan S.    | 3,23     
Juan D.    | 4,41     
Ana        | 4,26     
Pedro      | 4,29     
Luis       | 3,14     
Lucia      | 2,62     
Fernando   | 3,37     
Paola      | 3,85     
Miguel     | 4,14     
Camila     | 3,63     
Rafael     | 2,53     
Manuel     | 4,56     
Esteban    | 3,42     

Estudiante con el mayor promedio:
Carlos     | 6,59     

Estudiante con el menor promedio:
Rafael     | 2,53     
BUILD SUCCESSFUL (total time: 0 seconds)
 */