package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
        System.out.println("HEROES" + heroes);

        // reduce
        int sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).reduce(1, (x, y) -> x * y);
        System.out.println("SUM: " + sum);

        // sum
        int totalBudget = IntStream.of(100, 200, 300).sum();
        System.out.println("Total Budget: " + totalBudget);

        // Collect
        List<Integer> grades = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());
        System.out.println("Grades: " + grades);

        List<Integer> grade2 = Stream.of(1, 2, 3, 4, 5).collect(
                () -> new ArrayList<Integer>(),
                (list2, item) -> {
                    list2.add(item);
                },
                (list2, ele) -> {
                    list2.addAll(ele);
                });
        System.out.println("Grade2: " + grade2);

        // min
        Optional myMin = Stream.of(5, 3, 1, 10, 9, 2).min((x, y) -> x - y);
        System.out.println("Min: " + myMin.get());

        // max
        Optional myMax = Stream.of(5, 3, 1, 10, 9, 2).max((x, y) -> x - y);
        System.out.println("Min: " + myMax.get());

        Double myAvg = Stream.of(5, 3, 1, 10, 9, 2).mapToInt(x -> x).average().getAsDouble();

        System.out.println("Avg: " + myAvg);

        // Any Match, for some
        boolean moreThan2 = Stream.of(0, 0, 0, 0, 1).anyMatch(x -> x > 2);
        System.out.println("More than 2: " + moreThan2);

        // All Match, for all
        boolean moreThan5 = Stream.of(110, 10, 10, 10, 11).allMatch(x -> x > 5);
        System.out.println("More than 5: " + moreThan5);

        // Find First
        Optional<Integer> myFirst = Stream.of(1, 2, 333, 42, 5).findFirst();
        System.out.println("First: " + myFirst.get());

        // Chain Operations
        System.out.println("======Filter======");
        Stream.of(1, 2, 3, 4, 5).filter(x -> x % 2 == 0).forEach(x -> {
            System.out.println(x);
        });

        System.out.println("======Map======");
        Stream.of(1, 2, 3, 4, 5).map(x -> x * 2).forEach(x -> {
            System.out.println(x);
        });

        // Distinct, Return all the unique value
        System.out.println("======Distinct======");
        Stream.of(1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6).distinct().forEach(x -> {
            System.out.println(x);
        });

        // Sorted
        System.out.println("======Sorted======");
        Stream.of(1,  5, 1, 2, 3, 4, 6).sorted().forEach(x -> {
            System.out.println(x);
        });
    }
}
