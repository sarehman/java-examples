package org.example;

import java.util.Collection;
import java.util.Stack;

public class MyStack<E> extends Stack<E> {
    public void pushAll(Iterable<E> iterable){
        for(E e : iterable){
            push(e);
        }
    }
    //? extends E applies where its consumer i.e. consumer extends
    public void pushAllImproved(Iterable<? extends E> src){
        for(E e : src){
            push(e);
        }
    }

    public void popAll(Collection<E> dst){
        while(!isEmpty()){
            dst.add(pop());
        }
    }

    //producer super
    public void popAllImproved(Collection<? super E> dst){
        while(!isEmpty()){
            dst.add(pop());
        }
    }
}
