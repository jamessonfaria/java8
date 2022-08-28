package br.com.jamesson.aula01_lambda;

public class Main {

    public static void main(String[] args) {

        // Java 7
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Ola mundo...");
            }
        }).run();

        // Java 8
        new Thread(() -> System.out.println("Ola mundo...")).run();

    }

}
