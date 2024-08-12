package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.IntStream;

public class SpliteratorExample {

    public static void main(String... args){
        List<Integer> integers = List.of(1,2,3,4,56,8,9);

        Spliterator<Integer> s1 = integers.spliterator();
        Spliterator<Integer> s2 = s1.trySplit();

        s1.forEachRemaining(System.out::println);
        System.out.println("======================");
        s2.forEachRemaining(System.out::println);

        Spliterator<Integer> s3 =
                IntStream.range(0,20).parallel().map(x -> x * 2).spliterator();

        System.out.println(s3.characteristics());
        System.out.println(s3.estimateSize());
        s3.forEachRemaining(System.out::println);

    }


}
