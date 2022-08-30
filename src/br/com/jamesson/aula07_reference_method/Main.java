package br.com.jamesson.aula07_reference_method;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // method reference
        list.stream()
                .forEach(System.out::println);

        // sem method reference
        list.stream()
                .forEach((n) -> System.out.println(n));

        // metodos estaticos
        list.stream()
                .map(n -> multipliquePorDois(n)) // sem method reference
                .forEach(n -> System.out.println(n));

        System.out.println("----------");

        list.stream()
                .map(Main::multipliquePorDois) // com method reference
                .forEach(n -> System.out.println(n));

        System.out.println("----------");

        // construtores

        list.stream()
                .map(n -> new BigDecimal(n)) // sem method reference
                .forEach(System.out::println);

        list.stream()
                .map(BigDecimal::new) // com method reference
                .forEach(System.out::println);

        System.out.println("----------");

        // varias instancias

        list.stream()
                .map(n -> n.doubleValue()) // sem method reference
                .forEach(System.out::println);

        list.stream()
                .map(Integer::doubleValue) // method reference para conversao
                .forEach(System.out::println);

        System.out.println("----------");

        // unica instancia (com a propria instancia)
        BigDecimal dois = new BigDecimal(2);

        list.stream()
                .map(BigDecimal::new)
                .map(b -> dois.multiply(b)) // sem method reference
                .forEach(System.out::println);

        list.stream()
                .map(BigDecimal::new)
                .map(dois::multiply) // method reference da instancia dois
                .forEach(System.out::println);

    }
    private static int multipliquePorDois(Integer i) {
        return i * 2;
    }

}

