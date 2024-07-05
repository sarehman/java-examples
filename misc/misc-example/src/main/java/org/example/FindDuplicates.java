package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicates {

    public static void main(String[] args){
        List<Integer> nos = List.of(4, 3, 2, 9, 3, 5, 1, 4, 7, 2, 3, 7);

        System.out.println(findBySetAdd(nos));

        System.out.println(findByGrouping(nos));

        System.out.println(findDuplicatesByFrequency(nos));
        List<Integer> list = nos.stream().sorted().toList();
        System.out.println(Collections.binarySearch(list, 4));
    }

    private static Set<Integer> findBySetAdd(List<Integer> nums){
        Set<Integer> uniques = new HashSet<>();
        return nums.stream().filter(n -> !uniques.add(n))
                .collect(Collectors.toSet());
    }

    private static Map<Integer, Long> findByGrouping(List<Integer> nums){
        return nums.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


    }

    private static <T> Set<T> findDuplicatesByFrequency(List<T> list){
        return list.stream().filter(i -> Collections.frequency(list, i) > 1)
                .collect(Collectors.toSet());
    }


}
