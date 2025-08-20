package org.ismaelg.hilos.ejemplos;

import org.ismaelg.hilos.ejemplos.runnable.ImprimirFrases;

public class EjemploSincronizacionThread {
    public static void main(String[] args) throws InterruptedException {

        new Thread(new ImprimirFrases("Hola", "que tal?")).start();
        new Thread(new ImprimirFrases("Quien eres", "tu?")).start();
        new Thread(new ImprimirFrases("Hey", "como estas?")).start();
        Thread.sleep(100);
        Thread h4 = new Thread(new ImprimirFrases("Muchas", "gracias!"));
        h4.start();
        Thread.sleep(100);
        System.out.println(h4.getState());
    }

    public synchronized static void imprimirFrases(String frase1,String frase2){
        System.out.println(frase1);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(frase2);
    }
}
