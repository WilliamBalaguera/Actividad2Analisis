package controlador;

/**
 * Cronómetro simple basado en System.nanoTime().
 * Equivalente casero a la clase StopWatch sugerida en el curso.
 * No usa ninguna clase de java.util.
 */
public class StopWatch {
    private long inicio;
    private long fin;

    public void start() {
        inicio = System.nanoTime();
    }

    public void stop() {
        fin = System.nanoTime();
    }

    /** Retorna el tiempo transcurrido en milisegundos (con decimales). */
    public double getElapsedTimeMillis() {
        return (fin - inicio) / 1_000_000.0;
    }
}
