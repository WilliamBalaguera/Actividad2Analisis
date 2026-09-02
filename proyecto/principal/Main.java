package principal;

import controlador.Controlador;

/**
 * Clase principal.
 * Ejecuta el problema "Suma máxima de subarreglo contiguo" con
 * tres instancias de prueba distintas, incluyendo casos límite.
 */
public class Main {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();

        // Instancia 1: caso típico (arreglo mixto con positivos y negativos)
        int[] instancia1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        controlador.ejecutarInstancia("INSTANCIA 1 - Caso típico (mixto)", instancia1);

        // Instancia 2: caso límite - todos los elementos negativos
        int[] instancia2 = {-8, -3, -6, -2, -5, -4};
        controlador.ejecutarInstancia("INSTANCIA 2 - Caso límite: todos negativos", instancia2);

        // Instancia 3: caso límite - arreglo de un solo elemento
        int[] instancia3 = {7};
        controlador.ejecutarInstancia("INSTANCIA 3 - Caso límite: un solo elemento", instancia3);

        // Instancia extra (opcional) para EVIDENCIAR la diferencia de eficiencia
        // con una entrada grande, donde el Método 1 (O(n^3)) tarda notoriamente
        // más que el Método 2 (O(n)).
        int n = 2000;
        int[] instanciaGrande = new int[n];
        for (int i = 0; i < n; i++) {
            // Genera valores pseudoaleatorios deterministas entre -50 y 50
            instanciaGrande[i] = ((i * 37) % 101) - 50;
        }
        controlador.ejecutarInstancia("INSTANCIA EXTRA - n = 2000 (comparación de eficiencia)", instanciaGrande);
    }
}
