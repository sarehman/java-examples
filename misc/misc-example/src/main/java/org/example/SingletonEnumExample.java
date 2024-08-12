package org.example;

public class SingletonEnumExample {

    public static void main(String[] args) {
        Singleton s1 = Singleton.INSTANCE;
        Singleton s2 = Singleton.INSTANCE;

        System.out.println(s1 == s2);
        s1.doSomething();
    }
}

enum Singleton{
    INSTANCE;

    private Singleton(){}

    public void doSomething(){
        System.out.println("DOing Something");
    }
}
