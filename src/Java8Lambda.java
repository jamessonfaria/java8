import java.util.stream.IntStream;

public class Java8Lambda {

    public static void main(String[] args) {

        // Parenteses obrigatorios no lambda
        Runnable runnable = () -> System.out.println("olaaaa");

        IntStream.range(0, 5)
                .filter((int n) -> n % 2 ==0)
                .reduce((n1, n2) -> n1 + n2)
                .ifPresent(System.out::println);

        // chaves obrigatorias no lambda
        IntStream.range(0, 5)
                .filter((int n) -> {
                    System.out.println("x: " + n);
                    return  n % 2 == 0;
                })
                .forEach(System.out::println);

    }

}
