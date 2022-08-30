package br.com.jamesson.aula05_collect;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        // supplier (fornecedor) - accumulator (acumulador) - combiner (combinacao)
        // forma mais crua de usar collection
        List<Integer> collect = list.stream()
                .collect(
                        () -> new ArrayList<>(), // fornecedor (instancia do meu novo objeto que vou usar)
                        (lista, e) -> lista.add(e), // acumulador (funcao de acumulacao)
                        (lista1, lista2) -> lista1.addAll(lista2) // combinacao (funcao de combinacao do resultado da acumulacao com a nova instancia de lista)
                );

        System.out.println(list);
        System.out.println(collect);

        System.out.println("--------------");

        // collector toList
        List<Integer> collect2 = list.stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(collect2);

        // collector toSet
        Set<Integer> collect3 = list.stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toSet());
        System.out.println(collect3);

        // collector toCollection - vc define que colecao usar
        LinkedList<Integer> collect4 = list.stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toCollection(() -> new LinkedList<>()));
        System.out.println(collect4);

        // collector joining
        String collectc5 = list.stream()
                .map(n -> n.toString())
                .collect(Collectors.joining(";")); // usa internamente um stringBuilder, fica mais performatico
        System.out.println(collectc5);

        System.out.println("--------------");

        // averaging
        Double media = list.stream()
                .collect(Collectors.averagingInt(n -> n.intValue()));
        System.out.println(media);

        // summing
        Integer sum = list.stream()
                .collect(Collectors.summingInt(n -> n.intValue()));
        System.out.println(sum);

        // summarizing
        IntSummaryStatistics stats = list.stream()
                .collect(Collectors.summarizingInt(n -> n.intValue()));
        System.out.println(stats);

        // couting
        Long count = list.stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.counting());
        System.out.println(count);

        // max
        list.stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.maxBy(Comparator.naturalOrder()))
                .ifPresent(System.out::println);

        // min
        list.stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.minBy(Comparator.naturalOrder()))
                .ifPresent(System.out::println);

        System.out.println("--------------");

        // groupingBy
        Map<Integer, List<Integer>> mapa = list.stream()
                .collect(Collectors.groupingBy((n) -> n % 3)); // vai agrupar os numeros pelo resto da divisao
        System.out.println(mapa);

        // partitioningBy
        Map<Boolean, List<Integer>> mapa2 = list.stream()
                .collect(Collectors.partitioningBy((n) -> n % 3 == 0)); // vai agrupar por valores true / false de acordo com o resto da divisao
        System.out.println(mapa2);

        // toMap
        Map<Integer, Double> mapa3 = list.stream()
                .collect(Collectors.toMap(n -> n, n -> Math.pow(n.doubleValue(), 5)));
                // vai agrupar os valores por uma chave (primeira lambda) e por valor (segunda lambda)
        System.out.println(mapa3);



    }

}
