package org.ismaelg.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemeploExecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executor= Executors.newSingleThreadExecutor();

        Callable<String> tarea = () -> {
            System.out.println("Inicio de la tarea...");
            try {
                System.out.println("Nombre del thread: "+ Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            System.out.println("Finaliza la tarea...");
            return "Alguna resultado de una consulta de la tarea";
        };
        Future<String> resultado  = executor.submit(tarea);
        executor.shutdown();
        System.out.println("Continuando ejecucion del main ");

        //System.out.println(resultado.isDone());
        while (!resultado.isDone()){
            System.out.println("Ejecutando tarea ...");
            TimeUnit.MILLISECONDS.sleep(1500);
        }
        System.out.println("Obtenemos resultado de la tarea: "+resultado.get());
        System.out.println("Finaliza la tarea: "+resultado.isDone());

    }
}
