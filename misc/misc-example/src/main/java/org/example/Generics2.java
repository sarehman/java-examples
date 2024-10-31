package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Generics2 {

    public static void main(String[] args){
        List<? super Number> numbers = new ArrayList<>();
        numbers.add(Integer.valueOf(10));
        numbers.add(Double.valueOf(20.5));

        System.out.println( hashDouble(35.4));
        System.out.println ( Double.hashCode(35.4));

        Object i = numbers.get(0);
        Object d = numbers.get(1);
        System.out.println("i = "+i+" d = "+d);

    }

    private static int hashDouble(double val){
        long longBits = Double.doubleToLongBits(val);
        return (int) ( longBits ^ (longBits >>> 32));
    }
}
