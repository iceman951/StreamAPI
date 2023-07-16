package main;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("A", "B", "C", "D", "E");
        System.out.println(list);

        Stream<Integer> stream = Stream.iterate(0, (i) -> {
            return i + 1;
        }).limit(10);

        var para = List.of(1, 2, 3, 4).stream().parallel();

        Stream.of(1, 2, 3, 4).parallel().forEach(n -> System.out.println(n));

        Object[] heroes = Stream.of("Spiderman", "Ironman", "Hulk", "Thor").toArray();

        int sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).reduce(0, (x, y) -> x + y);
        System.out.println(sum);

    }
}
