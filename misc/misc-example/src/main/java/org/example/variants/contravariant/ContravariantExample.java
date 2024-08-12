package org.example.variants.contravariant;

import java.util.ArrayList;
import java.util.List;

public class ContravariantExample {
    public static void processAnimals(List<? extends Animal> animals){
        for(Animal animal : animals){
            animal.makeSound();
        }
    }
    public static void main(String[] args){
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat());

        //pass a List<Cat> to a method that accepts List<? extends Animal>
        processAnimals(cats);

        //using ? super Cat
        List<? super Cat> animals = new ArrayList<Animal>();//list of supertype of Dog
        animals.add(new Cat());

        //animals.add(new Animal());//not valid
        //Cat c = animals.get(0);//compilation error
        Object o = animals.get(0);
        if(o instanceof Cat){
            ((Cat) o).makeSound();
        }
    }

}

class Animal {
    public void makeSound(){
        System.out.println("Animal makes a sound");
    }
}
class Cat extends Animal {
    @Override
    public void makeSound(){
        System.out.println("Meow");
    }
}