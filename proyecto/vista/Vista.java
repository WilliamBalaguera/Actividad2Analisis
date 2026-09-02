package vista;

public class Vista {

    public void mostrarTitulo(String texto) {
        System.out.println("\n=================================================");
        System.out.println(texto);
        System.out.println("=================================================");
    }

    public void mostrarArreglo(int[] datos) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < datos.length; i++) {
            sb.append(datos[i]);
            if (i < datos.length - 1) sb.append(", ");
        }
        sb.append("]");
        System.out.println("Entrada: " + sb.toString());
    }

    public void mostrarResultado(String nombreMetodo, int[] resultado, double tiempoMs) {
        System.out.println(nombreMetodo + " -> Suma máxima = " + resultado[0]
                + " | Subarreglo = [índice " + resultado[1] + " .. " + resultado[2] + "]"
                + " | Tiempo = " + tiempoMs + " ms");
    }
}
