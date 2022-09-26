package org.example;

import java.util.function.*;

public class Functional {

    public static void main(String[] args) {
        MyFunc myFunc = new MyFunc() {
            @Override
            public void consume(String text) {
                System.out.println("text = " + text);
            }
        };
        MyFunc lambda = text -> System.out.println("text = " + text);
        MyFunc ref = System.out::println;
//        Function
//        Predicate
//        UnaryOperator
//        BinaryOperator
//        Consumer
//        Supplier
    }
}

@FunctionalInterface
interface MyFunc {

    void consume(String text);

    default void doSomething() {
        System.out.println();
    }

    static void doStatic() {

    }
}
