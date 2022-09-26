package org.example;

import org.example.model.Car;
import org.example.model.Maker;
import org.example.model.Wheel;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi {

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        List<Wheel> wheels = new ArrayList<>();
        wheels.add(new Wheel(16));
        wheels.add(new Wheel(16));
        wheels.add(new Wheel(16));
        wheels.add(new Wheel(16));
        cars.add(new Car(new Maker("ford"), wheels, 15_000));

        wheels = new ArrayList<>();
        wheels.add(new Wheel(18));
        wheels.add(new Wheel(18));
        wheels.add(new Wheel(18));
        wheels.add(new Wheel(18));
        cars.add(new Car(new Maker("dodge"), wheels, 25_000));

        cars.stream()
                .filter(car -> car.getPrice() < 20_000)
                .forEach(System.out::println);
        cars.stream()
                .map(car -> car.getWheels())
                .filter(wheels1 -> wheels1.size() > 5)
                .forEach(System.out::println);
        cars.stream()
                .flatMap(car -> car.getWheels().stream())
                .filter(wheel -> wheel.getRadius() > 16)
                .forEach(System.out::println);
        Stream<Object> objectStream = cars.stream()
                .map(car -> car.getMaker())
                .map(maker -> maker.getName());

        Stream.generate(() -> Math.random())
                .limit(5)
                .forEach(System.out::println);

        List<String> list = Stream.iterate(1, i -> ++i)
                .map(i -> "Integer " + i)
                .collect(Collectors.toList());
        cars.stream()
                .flatMap(car -> car.getWheels().stream())
                .peek(wheel -> wheel.setRadius(34))
                .forEach(System.out::println);

        boolean anyMatch = cars.stream().anyMatch(car -> car.getWheels().size() > 4);
        boolean allMatch = cars.stream().allMatch(car -> car.getPrice() > 20_000);
        boolean noneMatch = cars.stream().noneMatch(car -> car.getWheels().size() > 4);

        if (cars.stream().noneMatch(car -> car.getWheels().size() > 4)) {
            // logic
        }

        Map<Integer, List<Car>> map = cars.stream()
                .collect(Collectors.groupingBy(car -> car.getWheels().size()));
        long count = cars.stream()
                .flatMap(car -> car.getWheels().stream())
                .count();
        Optional<Integer> min = cars.stream()
                .map(car -> car.getPrice())
                .min(Integer::compareTo);
        Integer total = cars.stream()
                .map(car -> car.getPrice())
                .reduce(0, (price, sum) -> sum += price);
        Object[] makers = cars.stream()
                .map(car -> car.getMaker())
                .toArray();

        Optional<Car> any = cars.stream()
                .filter(car -> car.getPrice() > 30_000)
                .findAny();
        any.ifPresent(car -> car.getPrice());

        int sum = cars.parallelStream()
                .map(car -> car.getPrice())
                .mapToInt(value -> value)
                .sum();
    }

}
