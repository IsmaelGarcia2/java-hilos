package org.ismaelg.hilos.ejemploexecutor;

import org.ismaelg.hilos.ejemplosync.Panaderia;
import org.ismaelg.hilos.ejemplosync.runnable.Consumidor;
import org.ismaelg.hilos.ejemplosync.runnable.Panadero;

import java.util.concurrent.*;

public class EjemeploExecutorProductorConsumidor {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ThreadPoolExecutor executor= (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: "+ executor.getQueue().size());

        Panaderia p = new Panaderia();
        Runnable productor = new Panadero(p);
        Runnable cosumidor = new Consumidor(p);

        Future<?> futuro1  = executor.submit(cosumidor);
        Future<?> futuro2  = executor.submit(productor);

        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: "+ executor.getQueue().size());

        executor.shutdown();
        System.out.println("Continuando ejecucion del main ");


    }
}
