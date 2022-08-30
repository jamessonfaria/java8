package br.com.jamesson.aula09_interfaces_funcionais;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        // supplier (nao recebe parametro e retorna um valor, ele é fornecedor)
        Stream.generate(() -> new Random().nextInt()) // esse lambda é um supplier
                .limit(5)
                .forEach(System.out::println);

        System.out.println("-------------");

        // consummer (recebe um parametro e nao retorna nada, ele é consumidor)
        Stream.generate(() -> new Random().nextInt())
                .limit(2)
                .forEach(e -> System.out.println(e)); // esse é um consummer

        // biconsumer (recebe dois parametros e nao retorna nada, ele é consumidor de dois valores)
        BiConsumer<Integer, Integer> addTwo = (x, y) -> System.out.printf("Total: %s \n", x + y);
        addTwo.accept(1,2);

        System.out.println("-------------");

        // predicate (recebe um parametro e retorna um valor booleano, ele é um testador)
        List<Integer> list = Arrays.asList(1, 2, 5, 8, 9);
        list.stream()
                .filter(e -> e % 2 == 0) // esse é um predicate
                .forEach(System.out::println);

        // bipredicate (recebe dois parametros e retorna um valor booleano, ele é um testador para dois parametros recebidos)
        BiPredicate<Integer, Integer> teste = (x, y) -> x > y;
        System.out.println(teste.test(4, 2));

        System.out.println("-------------");

        // function (recebe um valor e retorna um valor, é uma funcao, a interface mais generica)
        List<Integer> list2 = Arrays.asList(1, 2, 5, 8, 9);
        list2.stream()
                .map(e -> e.toString() + "x") // essa é uma funcion
                .forEach(System.out::println);

        // bifunction (recebe dois valores e retorna um valor)
        BiFunction<Integer, Integer, String> func = (x, y) -> (x.toString() + " - " + y.toString());
        System.out.println(func.apply(10,20));

        System.out.println("-------------");

        // unaryoperator (é uma function que garante que os valores recebidos sao iguais e o retorno tambem é igual)
        List<Integer> list3 = Arrays.asList(1, 2, 5, 8, 9);
        list3.stream()
                .reduce((n1, n2) -> n1 + n2) // esse é o unary operator
                .ifPresent(System.out::println);

        // binaryoperator (é uma bifunction que garante que os valores recebidos sao iguais e o retorno tambem é igual)
        List<Integer> list4 = Arrays.asList(1, 2, 5, 8, 9);
        list4.stream()
                .reduce((n1, n2) -> n1 + n2) // esse é o binary operator
                .ifPresent(System.out::println);
    }

}
