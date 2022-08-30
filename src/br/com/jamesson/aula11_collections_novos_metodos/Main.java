package br.com.jamesson.aula11_collections_novos_metodos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // Exemplos com List
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // forEach - aplica uma expressao lambda para cada elemento
        list.forEach(n -> System.out.println(n));

        // removeIf - recebe um predicate faz um teste se passar ele remove o item
        list.removeIf(n -> n % 2 == 0);
        list.forEach(System.out::println);

        // replaceAll - altera todos os elementos da lista de acordo baseado na expressao lambda
        list.replaceAll(n -> n * 2);
        list.forEach(System.out::println);

        // Exemplos com Map
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "Se");
        map.put(1, "inscreva");
        map.put(2, "no");
        map.put(3, "canal");

        // forEach - receber chave e valor e retorna algo
        map.forEach((k , v) -> System.out.println(k + v));

        // compute - recebe a chave e dois argumentos (chave / valor) e aplica a lambda para o indice informado
        map.compute(1, (k, v) -> v + " agora");
        map.forEach((k , v) -> System.out.println(k + v));

        // merge - recebe a chave o valor e uma lambda, faz um merge da chave e valor de acordo com a lambda
        map.merge(3, "!", (v1, v2) -> v1 + v2);
        map.forEach((k , v) -> System.out.println(k + v));

        // replaceAll - recebe a chave e valor e faz um replace baseado na lambda
        map.replaceAll((k, v) -> v + "!");
        map.forEach((k , v) -> System.out.println(k + v));

    }

}
