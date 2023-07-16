package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
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
            (list2, item) -> {list2.add(item); },
            (list2, ele) -> {list2.addAll(ele); }
        );
        System.out.println("Grade2: " + grade2);

        // min
        Optional myMin = Stream.of(5,3,1,10,9,2).min((x,y) -> x-y);
        System.out.println("Min: " + myMin.get());

        // max
        Optional myMax = Stream.of(5,3,1,10,9,2).max((x,y) -> x-y);
        System.out.println("Min: " + myMax.get());

        Double myAvg = Stream.of(5,3,1,10,9,2).mapToInt(x -> x).average().getAsDouble();

        System.out.println("Avg: " + myAvg);

    }
}
