package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamExample {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Map<String, List<String>> maps = new HashMap<String, List<String>>();
        maps.put("Animals", Arrays.asList("Tiger", "Dog", "Cat", "Deer", "Monkey", "SPARROW", "Tiger", "Cat")); // SPARROW
        maps.put("Fruits", Arrays.asList("apple", "mango", "banana", "chiku")); // all ignore
        maps.put("Cities", Arrays.asList("Hyderabad", "Pune", "Mumbai", "New York", "Goa", "Chennai", "Pune"));

        maps.replace("Cities", maps.get("Cities"), maps.get("Cities").stream().distinct().toList());
        List<String> animalAndCities =
                maps.entrySet().stream()
                        .filter(e -> !e.getKey().equals("Fruits"))
                        
                        //.map(e -> e.getKey())
                        .flatMap(e -> e.getValue().stream())
                        .filter(item -> !item.equals("SPARROW"))
                        .filter(item -> !item.equals("New York"))
                        .filter(item -> item.length() > 3)
                        .toList();

        System.out.println(animalAndCities);

    }
}
