package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
public class MainFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(() -> {
            System.out.println("Tarea ejecutándose en segundo plano (runAsync) sin retorno");
        });
        CompletableFuture<String> supplyAsyncFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Calculando un número en segundo plano (supplyAsync) con retorno");
            return "El peteñito";
        });
        runAsyncFuture.thenAccept(result -> {
            System.out.println("Tarea sin retorno completada(thenAccept)");
        });
        CompletableFuture<String> thenApplyFuture = supplyAsyncFuture.thenApply(result -> {
            System.out.println("Resultado recibido: " + result + " es un perro");
            return "Resultado transformado: " + result;
        });
        CompletableFuture<String> exceptionallyFuture = thenApplyFuture.exceptionally(ex -> {
            System.out.println("Ocurrió una excepción: " + ex.getMessage() + " (exceptionally)");
            return "Excepción manejada: " + ex.getMessage();
        });
        exceptionallyFuture.thenRun(() -> {
            System.out.println("Tarea después de completar (thenRun)");
        });
        CompletableFuture<Void> allOfFuture = CompletableFuture.allOf(runAsyncFuture, supplyAsyncFuture, thenApplyFuture, exceptionallyFuture);
        allOfFuture.get();
    }

}
