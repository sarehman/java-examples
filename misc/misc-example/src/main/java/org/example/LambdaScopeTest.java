package org.example;

import java.util.function.Consumer;

public class LambdaScopeTest {

    public int x = 0;

    class FirstLevel{

        public int x = 1;

        void methodInFirstLevel(int x){

            int z = 2;

            Consumer<Integer> consumer = (y) -> {
               // z = 99; not allowed, z should be final
                System.out.println("x = "+x);
                System.out.println("y = "+y);
                System.out.println("z = "+z);
                System.out.println("this.x = "+this.x);
                System.out.println("LambdaScopeTest.this.x = "+LambdaScopeTest.this.x);
            };

            consumer.accept(x);
        }
    }

    public static void main(String[] args){
        LambdaScopeTest st = new LambdaScopeTest();
        LambdaScopeTest.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(20);
    }
}
