package com.carlosguemes;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class testLambdas {

    @Test
    public void regular() {
        //Count the number of names starting with alphabet A in list
        List<String> names = new ArrayList<>();
        names.add("Antonio");
        names.add("Damián");
        names.add("Alex");
        names.add("Adam");
        names.add("Ramón");
        int count = 0;

        for (int i=0; i< names.size(); i++) {
            String actual = names.get(i);
            if (actual.startsWith("A")) {
                count++;
            }
        }
        System.out.println("This is count " + count);

    }

    @Test
    public void streamFilter() {
        List<String> names = new ArrayList<>();
        names.add("Antonio");
        names.add("Damián");
        names.add("Alex");
        names.add("Adam");
        names.add("Ramón");

        // there is not life for intermediate operation if there is no terminal operation.
        // terminal operation will execute only if intermediate operation (filter in this case) returns true
        // we can create stream
        // how to use filter in Stream API
        long counter = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println("This is counter " + counter);

        long d = Stream.of("Antonio","Damián","Alex","Adam","Ramón").filter(s -> {
            s.startsWith("A");
            return true;
        }).count();
        System.out.println(d);

        //print all the names of List
        names.stream().filter(s -> s.length() > 4).forEach(x -> System.out.println(x));
        names.stream().filter(s -> s.length() > 4).limit(1).forEach(System.out::println);
    }

    /**
     * MAPS
     * */

    @Test
    public void streamMap() {
        List<String> names = new ArrayList<>();
        names.add("man");
        names.add("Don");
        names.add("women");

        //print names which have last letter as "n" with Uppercase
        Stream.of("Antonio","Damián","Alex","Adam","Ramón")
                .filter(s -> s.endsWith("n"))
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);

        //converting arrays in List
        List<String> names1 = Arrays.asList("Antonio","Damian","Alex","Adam","Ramon");

        //print names which have first letter as "a" with uppercase and sorted
        names.stream()
                .filter(s -> s.startsWith("A"))
                .sorted()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // Merging 2 different lists
        Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
//        newStream.sorted().forEach(System.out::println);
        boolean flag = newStream.anyMatch(s -> s.equals("Adam"));
        System.out.println(flag);
        Assert.assertTrue(flag);
    }

    @Test
    public void streamCollect() {
        List<String> ls = Stream.of("Antonio","Damián","Alex","Adam","Ramón")
                .filter(s -> s.startsWith("A"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        // print first element in the list
        System.out.println(ls.get(0));
        //instead of the line above you can use limit
        ls.stream().limit(2).forEach(System.out::println);


        List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
        // PRINT unique numbers from array
        values.stream().distinct().forEach(System.out::println);

        // sort array
        List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());

        // get the third value
        System.out.println(li.get(2));
    }

}
