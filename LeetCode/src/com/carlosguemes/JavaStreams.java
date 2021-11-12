package com.carlosguemes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {

    public static void main(String[] args) throws IOException {

        int [] numbers = {1,2,3,4,5,6};

        for (int num : numbers) {
            System.out.println(num);
        }

        Arrays.stream(numbers).forEach(System.out::println);

        List<Integer> list = Arrays.stream(numbers)
                        .filter(x -> x % 2 == 0)
                        .boxed()
                        .collect(Collectors.toList());

        System.out.println(list); // it will print 2, 4, 6

        List<String> words = Arrays.asList("Apples", "", "Oranges", "Winter");

        for (String fruit : words) {
            System.out.println(fruit);
        }

        words.stream().filter(x -> !x.isEmpty()).forEach(x -> System.out.println(x));

        boolean hasG = words.stream().anyMatch(x -> x.contains("g"));

        List<String> lowerCasedWords = words.parallelStream().map(String::toLowerCase).collect(Collectors.toList());

        lowerCasedWords.forEach(System.out::println);

        System.out.println("*******************************");

        // 1. Integer Stream
        IntStream
                .range(1,10)
                .forEach(System.out::println);
        System.out.println();

        // 2. Integer Stream with skip
        IntStream
                .range(1,10)
                .skip(5)
                .forEach(System.out::println);
        System.out.println();

        // 3. Integer Stream with sum
        System.out.println(
                IntStream
                        .range(1,10)
                        .sum()
        );
        System.out.println();

        // 4. Stream.of, sorted and findFirst
        Stream.of("Ava", "Aneri", "Alberto")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
        System.out.println();

        // 5. Stream from Array, sort, filter and print
        String [] names = {"Al","Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sara"};
        Arrays.stream(names)
                .filter(x -> x.startsWith("S"))
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        // 6. Average of squares of an int array
        Arrays.stream(new int[] {2,4,6,8,10})
                .map(x-> x * x)
                .average()
                .ifPresent(System.out::println);
        System.out.println();

        // 7. Stream from List, filter and print
        List<String> people = Arrays.asList("Al","Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sara");

        people.stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("a"))
                .forEach(System.out::println);

        // 8. Stream rows from text file, sort, filter and print
        Stream<String> bands = Files.lines(Paths.get("bands.txt"));
        bands.sorted()
                .filter(x -> x.length() > 13)
                .forEach(System.out::println);
        bands.close();
        System.out.println();

        // 9. Stream rows from text file and save to List
        List<String> band2 = Files.lines(Paths.get("bands.txt"))
                .filter(x -> x.contains("jit"))
                .collect(Collectors.toList());
        band2.forEach(System.out::println);
        System.out.println();

        // 10. Stream rows form CSV file and count
        Stream<String> rows1 = Files.lines(Paths.get("data.txt"));
        int rowCount = (int) rows1
                .map(s -> s.split(","))
                .filter(x -> x.length == 3)
                .count();

        System.out.println("row" + rowCount);
        System.out.println();
        // 11. Stream rows from CSV file, parse data from rows
        Stream<String> rows2 = Files.lines(Paths.get("data.txt"));
        rows2
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15)
                .forEach(x -> System.out.println(x[0] + " " + x[1] + " " + x[2]));
        rows2.close();


    }
}
