package br.com.jamesson.aula04_reduce;

import java.util.*;
import java.util.stream.DoubleStream;

public class Main {

    public static void main(String[] args) {
        String s = "Inscreva-se no canal cabecao";
        String[] split = s.split(" ");
        List<String> listaStr = Arrays.asList(split);
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        // operacoes mais simples (funcoes associativas - podem ser usadas e nao afeta o resultado)
        // reduce - soma
        Optional<Integer> soma = list.stream()
                .parallel()
                .reduce((n1, n2) -> n1 + n2); // pega a soma dos valores e coloca em n1 para somar com o proximo n2
        System.out.println(soma.get());

        // reduce - multiplicacao
        Optional<Integer> multi = list.stream()
                .parallel()
                .reduce((n1, n2) -> n1 * n2); // pega a multiplicacao dos valores e coloca em n1 para multiplicar com o proximo n2
        System.out.println(multi.get());

        // reduce - concatenacao
        Optional<String> concat = listaStr.stream()
                .reduce((s1, s2) -> s1.concat(s2));
        System.out.println(concat.get());

        // (funcao nao associativa - *** NAO PODE usar funcao nao associativa em reduce, pois o resultado da operacao sera invalido)
        // reduce - subtracao
        Optional<Integer> sub = list.stream()
                .reduce((n1, n2) -> n1 - n2); // pega a subtracao dos valores e coloca em n1 para subtracao com o proximo n2
        System.out.println(sub.get());

        // operacoes mais complexas (usando identidade)
        // *** o valor de identidade garanti pelo menos um valor caso a operacao seja vazia, retornando asism um integer em vez de um optional
        Integer soma2 = list.stream()
                .reduce(0, (n1, n2) -> n1 + n2); // o valor de identidade ao somar com o primeiro valor deve ser o proprio valor
        System.out.println(soma2);

        Integer mult2 = list.stream()
                .reduce(1, (n1, n2) -> n1 * n2); // o valor de identidade ao multiplicar com o primeiro valor deve ser o proprio valor
        System.out.println(mult2);

        String concat2 = listaStr.stream()
                .reduce("", (s1, s2) -> s1.concat(s2)); // o valor de identidade ao concatenas com o primeiro valor deve ser o proprio valor
        System.out.println(concat2);

        List<Integer> listaVazia = Arrays.asList();
        Integer somaVazio = listaVazia.stream()
                .reduce(0, (n1, n2) -> n1 + n2);
        System.out.println(somaVazio);

        // reduce - menor valor (identidade na pratica)
        double menorValor = DoubleStream.of(1.5, 2.9, 6.7)
                .reduce(Double.POSITIVE_INFINITY, (d1, d2) -> Math.min(d1, d2));
        System.out.println(menorValor);


        // funca de combinacao
        // reduce - soma
        Integer soma3 = list.stream()
                .reduce(0, (n1, n2) -> n1 + n2, (n1, n2) -> n1 + n2);
        System.out.println(soma3);

        // reduce - map + combiner
        String soma4 = list.stream()
                .reduce("", (n1, n2) -> n1.concat(n2.toString()),
                        (n1, n2) -> n1.concat(n2));
        System.out.println(soma4);

    }
}
