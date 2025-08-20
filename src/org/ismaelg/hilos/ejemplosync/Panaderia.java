package org.ismaelg.hilos.ejemplosync;

public class Panaderia {
    private String pan;
    private boolean disponible;

    public synchronized void hornear(String masa) {
        while (disponible){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.pan = masa;
        System.out.println("Panadero horenea: " + this.pan);
        this.disponible = true;
        notify();
    }

    public synchronized String consumir(){
        while (!disponible){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Cliente consume pan " + this.pan);
        this.disponible = false;
        notify();
        return pan;
    }
}
