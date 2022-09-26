package org.example;

import java.util.ConcurrentModificationException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        String name = "bob";
        if (name.equals("bob")) {
            name = "nick";
            System.out.println("name = " + name);
        }
        Wrap<String> wrappedBob = new Wrap<>("bob");
        wrappedBob
                .filter(object -> object.equals("bob"))
                .map(object -> new Wrap<>("nick"))
                .end(object -> System.out.println(object));

    }
}

class Wrap<T> {

    private T object;

    public Wrap(T object) {
        this.object = object;
    }

    public Wrap<T> filter(Predicate<T> predicate) {
        if (predicate.test(object)) {
            return this;
        } else {
            return new Wrap<>(null);
        }
    }

    public <U> Wrap<U> map(Function<T, Wrap<U>> function) {
        if (object != null) {
            return function.apply(object);
        } else {
            return new Wrap<>(null);
        }
    }

    public void end(Consumer<T> consumer) {
        if (object != null) {
            consumer.accept(object);
        }
    }
}