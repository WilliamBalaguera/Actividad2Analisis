package controlador;

import modelo.Modelo;
import vista.Vista;

public class Controlador {
    private Modelo modelo;
    private Vista vista;

    public Controlador() {
        this.modelo = new Modelo();
        this.vista = new Vista();
    }

    public void ejecutarInstancia(String nombreInstancia, int[] datos) {
        vista.mostrarTitulo(nombreInstancia);
        vista.mostrarArreglo(datos);

        StopWatch sw1 = new StopWatch();
        sw1.start();
        int[] resultado1 = modelo.getMetodo1(datos);
        sw1.stop();
        vista.mostrarResultado("Método 1 (Fuerza bruta O(n^3))", resultado1, sw1.getElapsedTimeMillis());

        StopWatch sw2 = new StopWatch();
        sw2.start();
        int[] resultado2 = modelo.getMetodo2(datos);
        sw2.stop();
        vista.mostrarResultado("Método 2 (Kadane O(n))       ", resultado2, sw2.getElapsedTimeMillis());
    }
}
