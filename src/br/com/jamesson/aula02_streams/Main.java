package br.com.jamesson.aula02_streams;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,5,8,9,1,4,7,6,6,9,9);

        // Java 7
        for (Integer integer : list) {
            System.out.println(integer);
        }

        System.out.println("----------");

        // Java 8
        list.stream().forEach(e -> System.out.println(e));

        System.out.println("----------");

        // Operacoes intermediarias
        list.stream() // abre o fluxo de dados
                .skip(2) // ignora os dois primeiros elementos
                .limit(8) // limita a apenas dois elementos para processar
                .filter(i -> i % 2 == 0) // aplica filtro especifico
                .distinct() // nao processa repetidos
                .map(e -> e * 2) // realiza uma transformação
                // Operacao terminal
                .forEach(System.out::println); // itera com o resultado apos o skip e imprime



    }

}
