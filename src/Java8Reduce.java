import java.util.*;
import java.util.stream.DoubleStream;

public class Java8Reduce {

    public static void main(String[] args) {
        String s = "Inscreva-se no canal cabecao";
        String[] split = s.split(" ");
        List<String> listaStr = Arrays.asList(split);
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        Optional<Integer> reduce = list.stream()
                .parallel()
                .reduce((n1, n2) -> n1 + n2);
        System.out.println(reduce.get());

        Optional<String> reduce1 = listaStr.stream()
                .parallel()
                .reduce((s1, s2) -> s1.concat(s2));
        System.out.println(reduce1.get());


        Integer reduce2 = list.stream()
                .reduce(0, (n1, n2) -> n1 + n2);
        System.out.println(reduce2);

        Integer reduce3 = list.stream()
                .reduce(1, (n1, n2) -> n1 * n2);
        System.out.println(reduce3);

        String reduce4 = listaStr.stream()
                .reduce("", (s1, s2) -> s1.concat(s2));
        System.out.println(reduce4);

        // reduce - menor valor
        double reduce5 = DoubleStream.of(1.5, 2.9, 6.7)
                .reduce(Double.POSITIVE_INFINITY, (d1, d2) -> Math.min(d1, d2));
        System.out.println(reduce5);



        Integer soma = list.stream()
                .reduce(0, (n1, n2) -> n1 + n2, (n1, n2) -> n1 + n2);
        System.out.println(soma);

        // reduce - map + combiner
        String soma2 = list.stream()
                .reduce("", (n1, n2) -> n1.toString().concat(n2.toString()), (n1, n2) -> n1.concat(n2));
        System.out.println(soma2);


    }


}
