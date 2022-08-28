package br.com.jamesson.aula02_streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main02 {

    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1,5,8,9,1,4,7,6,6,9,9);

        Stream<Integer> map = lista.stream()
                .limit(3)
                .map(e -> e * 2);

        // forEach é uma operacao terminal, ao invocar ele fecha o stream
        map.forEach(e -> System.out.println(e));
        // Não pode ser chamado de novo, pois o stream foi fechado, teremos uma exception
        //map.forEach(e -> System.out.println(e));

        System.out.println("--------------");

        // Outras operacoes terminais
        List<Integer> novaLista = lista.stream()
                .filter(e -> e % 2 == 0)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(novaLista);

        Map<Boolean, List<Integer>> mapa = lista.stream()
                .map(e -> e * 3)
                .collect(Collectors.groupingBy(e -> e % 2 == 0)); // agrupa os elementos que sao pares e nao
        System.out.println(mapa);

        Map<Integer, List<Integer>> mapa2 = lista.stream()
                .collect(Collectors.groupingBy(e -> e % 3)); // agrupa os elementos pelo resto da divisao
        System.out.println(mapa2);

        String collect = lista.stream()
                .map(e -> String.valueOf(e))
                .collect(Collectors.joining(";"));// agrupa strings com delimitador
        System.out.println(collect);

        long count = lista.stream()
                .filter(e -> e % 2 == 0)
                .count(); // conta os elementos
        System.out.println(count);

        Optional<Integer> min = lista.stream()
                .filter(e -> e % 2 == 0)
                .min(Comparator.naturalOrder());// retorna o menor elemento
        System.out.println(min.get());

        Optional<Integer> max = lista.stream()
                .filter(e -> e % 2 == 0)
                .max(Comparator.naturalOrder());// retorna o maior elemento
        System.out.println(max.get());

    }

}
