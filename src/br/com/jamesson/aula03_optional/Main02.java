package br.com.jamesson.aula03_optional;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.Stream;

public class Main02 {

    public static void main(String[] args) {

        // antes
        Optional<Integer> first = Stream.of(1, 2, 3)
                .findFirst();
        System.out.println(first.get());

        // depois
        Stream.of(1, 2, 3)
                .findFirst()
                .ifPresent(System.out::println);

        // tipos primitivos
        OptionalInt numeros = OptionalInt.of(1);
        OptionalLong numeroLong = OptionalLong.of(1);
        OptionalDouble numeroDouble = OptionalDouble.of(1);




    }
}
