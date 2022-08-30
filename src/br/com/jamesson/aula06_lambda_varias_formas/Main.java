package br.com.jamesson.aula06_lambda_varias_formas;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        // Parenteses obrigatorios no lambda
        Runnable runnable = () -> System.out.println("olaaaa");
        InterfaceFuncional intf = () -> System.out.println("invoca via lambda");

        IntStream.range(0, 5)
                .filter((int n) -> n % 2 ==0)
                .reduce((n1, n2) -> n1 + n2)
                .ifPresent(System.out::println);

        // chaves obrigatorias no lambda
        IntStream.range(0, 5)
                .filter((int n) -> {
                    System.out.println("passou => " + n);
                    return  n % 2 == 0;
                })
                .forEach(System.out::println);

    }

}
