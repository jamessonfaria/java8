import java.util.*;
import java.util.stream.Collectors;

public class Java8Collect {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> collect = list.stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(list);
        System.out.println(collect);

        String collect1 = list.stream()
                .map(e -> e.toString())
                .collect(Collectors.joining(";"));

        Double avg = list.stream()
                .collect(Collectors.averagingInt(n -> n.intValue()));
        System.out.println(avg);

        Integer sum = list.stream()
                .collect(Collectors.summingInt(n -> n.intValue()));
        System.out.println(sum);

        IntSummaryStatistics sum2 = list.stream()
                .collect(Collectors.summarizingInt(n -> n.intValue()));
        System.out.println(sum2.getCount());
        System.out.println(sum2.getMax());
        System.out.println(sum2.getSum());
        System.out.println(sum2.getAverage());
        System.out.println(sum2.getMin());

        Long count = list.stream()
                .collect(Collectors.counting());
        System.out.println(count);

        list.stream()
                .collect(Collectors.maxBy(Comparator.naturalOrder()))
                .ifPresent(System.out::println);


        Map<Integer, List<Integer>> mapa = list.stream()
                .collect(Collectors.groupingBy(n -> n % 3));
        System.out.println(mapa);

        Map<Boolean, List<Integer>> mapa2 = list.stream()
                .collect(Collectors.partitioningBy(n -> n % 3 == 0));
        System.out.println(mapa2);

        Map<Integer, Double> mapa3 = list.stream()
                .collect(Collectors.toMap(
                        n -> n,
                        n -> Math.pow(n.doubleValue(), 5)));
        System.out.println(mapa3);


    }

}
