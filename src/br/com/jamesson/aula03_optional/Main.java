package br.com.jamesson.aula03_optional;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        String s = "1";
        String s2 = "1aaaa";

        Optional<Integer> numero = converteEmNumero(s);
        Optional<Integer> numero2 = converteEmNumero(s2);

        System.out.println(numero);
        System.out.println(numero2);

        System.out.println(numero.isPresent());
        System.out.println(numero2.isPresent());

        System.out.println(numero.get());
        converteEmNumero(s).ifPresent(System.out::println); // como o metodo retorna optional temos suas funcoes
        numero2.ifPresent(n -> System.out.println(n)); // como se fosse um if implicito

        Integer numeroElse = converteEmNumero(s2).orElse(0); // caso o valor seja empty retorna  0
        System.out.println(numeroElse);

        Integer numeroElseGet = converteEmNumero(s2).orElseGet(() -> 5); // caso o valor seja empty executa a lambda
        System.out.println(numeroElseGet);

        Integer numeroElseThrow = converteEmNumero(s2).orElseThrow(() -> new NullPointerException("Valor Vazio"));
        System.out.println(numeroElseThrow);

    }

    public static Optional<Integer> converteEmNumero(String numeroStr) {
        try{
            Integer integer = Integer.valueOf(numeroStr);
            return Optional.of(integer);
        }catch (Exception e){
            return Optional.empty();
        }
    }

}
