package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyStackTest {
    public static void main(String[] args) {
        MyStack<Number> stack = new MyStack<>();
        stack.push(10);
        Iterable<Integer> iterable = List.of(11,12,13,14);
        stack.push(10.5d);

        //stack.pushAll(iterable); //fails because Iterable<Integer> can't be converted to Iterable<Number>
        stack.pushAllImproved(iterable);
        System.out.printf("Size of stack %d\n", stack.size());
        Collection<Object> collection = new ArrayList<>();
        //stack.popAll(collection);//doesn't work because of type invariance
        stack.popAllImproved(collection); //compiles cleanly
        System.out.println(collection.size());
    }
}
