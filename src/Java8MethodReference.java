import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Java8MethodReference {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // method reference
        list.stream()
                .forEach(System.out::println);

        // sem method reference
        list.stream()
                .forEach(n -> System.out.println(n));

        // metodos estaticos
        list.stream()
                .map(n -> multipliquePorDois(n))
                .forEach(n -> System.out.print(n));

        System.out.println("");

        list.stream()
                .map(Java8MethodReference::multipliquePorDois) // method reference
                .forEach(n -> System.out.print(n));

        System.out.println("");

        // construtores

        list.stream()
                .map(n -> new BigDecimal(n))
                .forEach(System.out::println);

        list.stream()
                .map(BigDecimal::new) // method reference
                .forEach(System.out::println);

        // varias instancias

        list.stream()
                .map(n -> n.doubleValue())
                .forEach(System.out::println);

        list.stream()
                .map(Integer::doubleValue) // method reference para conversao
                .forEach(System.out::println);

        // unica instancia
        BigDecimal dois = new BigDecimal(2);

        list.stream()
                .map(BigDecimal::new)
                .map(b -> dois.multiply(b))
                .forEach(System.out::println);

        list.stream()
                .map(BigDecimal::new)
                .map(dois::multiply) // method reference da instancia dois
                .forEach(System.out::println);



    }

    private static int multipliquePorDois(Integer i){
        return i * 2;
    }

}
