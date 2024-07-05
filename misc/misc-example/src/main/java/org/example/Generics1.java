package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Generics1<T>{

    public static void main(String[] args){

        printArray(List.of(1,2,3).toArray());
        printArray(List.of("Hello", "World").toArray());

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            if(sc.hasNextInt()){
                Generics1<Integer> s = new Generics1<>();
                s.print(sc.nextInt());
            }else{
                Generics1<String> s = new Generics1<>();
                s.print(sc.nextLine());
            }
        }
    }

    public void print(T elem){
        System.out.println(elem);
    }

    public static <T> void  printArray(T[] arr)
    {

        Arrays.stream(arr).forEach(System.out::println);
    }
}
