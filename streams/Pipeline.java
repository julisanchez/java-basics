package streams;

import java.io.IOException;
import java.lang.String;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// VENTAJAS
// Programar mas eficiente
// Hacer uso intenso de expresiones lambda
// Posibilidad de trabajar con varios Threads

// Stream pipeline consiste de un recurso, seguido de cero o mas operaciones intermedias
// y una operacion terminal

public class Pipeline {
    public static void main(String[] args) {

    }

    void intStream() {
        // Imprime 123456789
        // System.out::print es una referencia al metodo System.out.print
        // Este metodo va a recibir como parametro cada elemento que le envie el stream
        IntStream.range(1, 10).forEach(System.out::print);
        System.out.println();
    }

    void skipStream() {
        IntStream.range(1, 10).skip(5).forEach(x -> System.out.println(x));
    }

    void sumStream() {
        System.out.println(IntStream.range(1, 5).sum());

        System.out.println();
    }

    void streamof() {
        Stream.of("Juli", "Sara", "Paula").sorted().findFirst().ifPresent(System.out::println);
    }

    void arrayStream() {
        String[] names = { "Al", "Ankit", "Kushal", "Brent", "Sarika", "Amanda", "Hans", "Sarah" };
        Arrays.stream(names).filter(x -> x.startsWith("S")).sorted().forEach(System.out::println);
    }

    void mapStream() {
        Arrays.stream(new int[] { 2, 4, 6, 8, 10 }).map(x -> x * x).average().ifPresent(System.out::println);
    }

    void listStream() {
        List<String> people = Arrays.asList("Al", "Ankit", "Kushal", "Brent", "Sarika", "Amanda", "Hans", "Sarah");

        people.stream().map(String::toLowerCase).filter(x -> x.startsWith("a")).forEach(System.out::println);
    }

    void fileStream() throws IOException{
        // Stream rows from text file, sort, filter and print them
        Stream<String> bands = Files.lines(Paths.get("bands.txt"));
        bands
            .sorted()
            .filter(x -> x.length() > 13)
            .forEach(System.out::println);

        bands.close();
    }

    void collectStream() throws IOException {
        // Stream rows from text file and save to List
        List<String> bands;
            bands = Files.lines(Paths.get("bands.txt"))
                .filter(x -> x.contains("jit"))
                .collect(Collectors.toList());

            bands.forEach(x -> System.out.println(x));
    }

    void csvStream() throws IOException {
        Stream<String> rows1 = Files.lines(Paths.get("data.txt"));
        int rowCount = (int) rows1
            .map(x -> x.split(","))
            .filter(x -> x.length == 3)
            .count();

        System.out.println(rowCount + " rows.");
        rows1.close();
    }

    void reduceStream() {
        double total = Stream.of(7.3, 1.5, 4.8)
            .reduce(0.0, (Double a, Double b) -> a + b);
        System.out.println("Total = " + total);
    }

    void summaryStatistics() {
        IntSummaryStatistics summary = IntStream.of(7,2,19,88,73,4,10)
            .summaryStatistics();

        System.out.println(summary);
    }
}