package br.com.jamesson.aula01_lambda;

import java.util.Arrays;
import java.util.List;

public class Main03 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        // Java 7
        for (Integer integer : list) {
            if (integer % 2 == 0)
                System.out.println(integer);
        }

        System.out.println("----------------------");

        // Java 8
        list.stream()
                .filter(i -> i % 2 == 0)
                .forEach(e -> System.out.println(e));



    }
}
