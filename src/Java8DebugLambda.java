import java.util.Arrays;
import java.util.List;

public class Java8DebugLambda {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 5, 8, 9);

        list.stream()
                .map(n -> new StringBuilder().append(n).append("s").append("a"))
                .forEach(System.out::println);

        // formas de quebrar o codigo para debugar

        list.stream()
                .map((n) -> {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(n);
                    stringBuilder.append("s");
                    stringBuilder.append("a");
                    return stringBuilder;
                })
                .forEach(System.out::println);

        list.stream()
                .map(Java8DebugLambda::getStringBuilder)
                .forEach(System.out::println);


        // usando o metodo peek (log ou debug)
        list.stream()
                .peek(n -> System.out.println("antes: " + n))
                .filter(n -> n % 2 == 0)
                .peek(n -> System.out.println("depois: " + n))
                .map(n -> new StringBuilder().append(n).append("s").append("a"))
                .forEach(System.out::println);

    }

    private static StringBuilder getStringBuilder(Integer n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n);
        stringBuilder.append("s");
        stringBuilder.append("a");
        return stringBuilder;
    }


}
