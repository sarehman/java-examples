package org.example.variants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CovariantTypesExample {

    public static void main(String[] args){
        List<Animal> animals = new ArrayList<>();
        animals.add(new Cat());

        for(Animal animal: animals){
            System.out.println(animal.getType());
        }

        //TYPE INVARIANCE
        /*
        Invariance means that type relationship remains unchanged between the
        type parameter and its subtypes or supertypes.In Java, arrays and generics
        are invariant, meaning that if you have a type A, and a subtype B, you
        cannot directly use an array or collection of B where A is expected
         */
        Animal[] animals1 = new Cat[1];
        //animals1[0] = new Animal(); throws runtime error
        animals1[0] = new Cat();
        Arrays.stream(animals1).forEach(a -> System.out.println(a.getType()));

        //List<Animal> animals2 = new ArrayList<Cat>(); //Compiler error
    }
}

class Animal {
    public String getType(){ return "Animal";  }
}
class Cat extends Animal {
    @Override
    public String getType(){ return "Cat"; }
}