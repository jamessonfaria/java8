import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8_Streams_Creation {

    public static void main(String[] args) throws IOException {

        // Collection
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        list.stream().forEach(System.out::println);

        // Arrays
        Integer[] intArray = new Integer[] {1,2,3,4};
        Arrays.stream(intArray).forEach(System.out::println);

        // Stream.of
        Stream.of("a", "b", "c", "d").forEach(System.out::println);

        // IntStream.range
        IntStream.range(15,20).forEach(System.out::println);
        IntStream.rangeClosed(15,20).forEach(System.out::println);

        // Stream.iterate
        Stream.iterate(5, n -> n * 2)
                .limit(10)
                .forEach(System.out::println);

        // BufferedReader - lines
        // streams.txt
        File file = new File("streams.txt");
        FileReader in = new FileReader(file);
        try (BufferedReader br = new BufferedReader(in)){
            br.lines().forEach(System.out::println);
        }

        // Files
        Path p = Paths.get("");
        Files.list(p).forEach(System.out::println);

        // Random
        new Random().ints()
                .limit(10)
                .forEach(System.out::println);


        // Pattern regex
        String s = "Deixa eu curtir o codigo";
        Pattern pa = Pattern.compile(" ");
        pa.splitAsStream(s).forEach(System.out::println);

    }

}
