import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8_Stream_Paralelos {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4);

//        list.parallelStream();
//        IntStream.range(0,5).parallel();

        // forEach x forEachOrdered
        list.parallelStream()
                .forEach(System.out::println);

        list.parallelStream()
                .forEachOrdered(System.out::println);

        // findAny
        list.parallelStream()
                .findAny()
                .ifPresent(System.out::println);

        System.out.println("------------");

        list.stream()
                .findAny()
                .ifPresent(System.out::println);

        System.out.println("------------");

        // unordered
        list.parallelStream()
                .unordered() // melhora a performance, pois as threads nao vao precisar de comunicar ...
                .skip(1)
                .limit(2)
                .forEach(System.out::println);

        // reduce
        // (1 + 2) + (3 + 4) = 10 - é associativa
        // (1 - 2) - (3 - 4) != -8 - não é associativa
        // No reduce so podemos usar operacao associativa, caso contrario o resultado da errado

        System.out.println("------------");

        list.parallelStream()
                .reduce((n1, n2) -> n1 - n2)
                .ifPresent(System.out::println);

        Map<Integer, Boolean> collect = list.parallelStream()
                //.collect(Collectors.toMap(n -> n, n -> n % 2 == 0)); // nao é performatico, cria um mapa para cada thread e junta no final
                .collect(Collectors.toConcurrentMap(n -> n, n -> n % 2 == 0));
                // ConcurrentMap performatico, cria apenas um mapa para as threads, ele é thread safe
        System.out.println(collect);

        System.out.println("------------");

        // groupingBy
        Map<Boolean, List<Integer>> collect2 = list.parallelStream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0)); // nao é performatico, cria um mapa para cada thread e junta no final
        System.out.println(collect2);

        Map<Boolean, List<Integer>> collect3 = list.parallelStream()
                .collect(Collectors.groupingByConcurrent(n -> n % 2 == 0)); // performatico, cria apenas um mapa para as threads, ele é thread safe
        System.out.println(collect3);

    }

}
