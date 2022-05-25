import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Java8_InterfacesFuncionais {

    public static void main(String[] args) {

        // supplier (nao recebe parametro e retorna um valor, ele é fornecedor)
        Stream.generate(() -> new Random().nextInt())
                .limit(5)
                .forEach(System.out::println);

        // consummer (recebe um parametro e nao retorna nada, ele é consumidor)
        Stream.generate(() -> new Random().nextInt())
                .limit(5)
                .forEach(e -> System.out.println(e));

        // biconsumer (recebe dois parametros e nao retorna nada, ele é consumidor de dois valores)

        // predicate (recebe um parametro e retorna um valor booleano, ele é um testador)
        List<Integer> list = Arrays.asList(1, 2, 5, 8, 9);
        list.stream()
                .filter(e -> e % 2 == 0)
                .forEach(System.out::println);


        // bipredicate (recebe dois parametros e retorna um valor booleano, ele é um testador para dois parametros recebidos)

        // function (recebe um valor e retorna um valor, é uma funcao)
        List<Integer> list2 = Arrays.asList(1, 2, 5, 8, 9);
        list2.stream()
                .map(e -> e.toString() + "x")
                .forEach(System.out::println);

        // bifunction (recebe dois valores e retorna um valor)

        // unaryoperator (é uma function que garante que os valores recebidos sao iguais e o retorno tambem é igual)
        List<Integer> list3 = Arrays.asList(1, 2, 5, 8, 9);
        list3.stream()
                .reduce((n1, n2) -> n1 + n2)
                .ifPresent(System.out::println);

        // binaryoperator (é uma bifunction que garante que os valores recebidos sao iguais e o retorno tambem é igual)
        List<Integer> list4 = Arrays.asList(1, 2, 5, 8, 9);
        list4.stream()
                .reduce((n1, n2) -> n1 + n2)
                .ifPresent(System.out::println);
    }

}
