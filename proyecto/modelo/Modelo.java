package modelo;

/**
 * Modelo del problema: Suma máxima de subarreglo contiguo.
 * Dado un arreglo de enteros (con posibles valores negativos),
 * se busca el subarreglo contiguo cuya suma de elementos sea máxima.
 *
 * Estructura de datos: ÚNICAMENTE arreglos nativos de Java (int[]).
 * No se usa ninguna clase de java.util.
 *
 * El resultado se retorna como un arreglo nativo de 3 posiciones:
 *   resultado[0] = suma máxima encontrada
 *   resultado[1] = índice inicial del subarreglo óptimo
 *   resultado[2] = índice final del subarreglo óptimo
 */
public class Modelo {

    /**
     * MÉTODO 1: Fuerza bruta - EFICAZ PERO NO EFICIENTE.
     * Revisa todos los posibles subarreglos [i..j] y para cada uno
     * vuelve a recorrer y sumar sus elementos desde cero.
     * Complejidad temporal: O(n^3)
     */
    public int[] getMetodo1(int[] datos) {
        int n = datos.length;
        int mejorSuma = datos[0];
        int mejorInicio = 0;
        int mejorFin = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sumaActual = 0;
                // Recalcula la suma del subarreglo [i..j] elemento por elemento
                for (int k = i; k <= j; k++) {
                    sumaActual = sumaActual + datos[k];
                }
                if (sumaActual > mejorSuma) {
                    mejorSuma = sumaActual;
                    mejorInicio = i;
                    mejorFin = j;
                }
            }
        }
        return new int[]{mejorSuma, mejorInicio, mejorFin};
    }

    /**
     * MÉTODO 2: Algoritmo de Kadane - EFICAZ, CORRECTO, EFICIENTE Y COMPLETO.
     * Recorre el arreglo una sola vez, manteniendo la suma máxima que
     * termina en la posición actual (sumaLocal). Si arrastrar la suma
     * anterior ya no conviene (es negativa), se reinicia desde la
     * posición actual.
     * Complejidad temporal: O(n)
     */
    public int[] getMetodo2(int[] datos) {
        int n = datos.length;
        int sumaLocal = datos[0];
        int sumaGlobal = datos[0];
        int inicioTemp = 0;
        int mejorInicio = 0;
        int mejorFin = 0;

        for (int i = 1; i < n; i++) {
            if (sumaLocal < 0) {
                sumaLocal = datos[i];
                inicioTemp = i;
            } else {
                sumaLocal = sumaLocal + datos[i];
            }

            if (sumaLocal > sumaGlobal) {
                sumaGlobal = sumaLocal;
                mejorInicio = inicioTemp;
                mejorFin = i;
            }
        }
        return new int[]{sumaGlobal, mejorInicio, mejorFin};
    }
}
