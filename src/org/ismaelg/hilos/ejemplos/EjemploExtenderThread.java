package org.ismaelg.hilos.ejemplos;

import org.ismaelg.hilos.ejemplos.threads.NombreThreads;

public class EjemploExtenderThread {
    public static void main(String[] args) throws InterruptedException {
        Thread hilo = new NombreThreads("Jhon Doe");
        hilo.start();
       // Thread.sleep(3);
        Thread hilo2 = new NombreThreads("Maria");
        hilo2.start();

        Thread hilo3 = new NombreThreads("Pepe");
        hilo3.start();
        System.out.println(hilo.getState());
    }
}
