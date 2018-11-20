package main.java.stream;

import main.java.domain.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author gukepeng
 * @since 2018/11/20
 */
public class Test {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println(dishesByType);

        System.out.println(menu.stream() // Stream<Dish>
                .filter(dish -> dish.getCalories() > 300) // Stream<Dish>
                .map(Dish::getName) // Stream<String>
                .limit(3)          // Stream<String>
                .collect(toList()));  // List<String>

        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
        //s.forEach(System.out::println); // java.lang.IllegalStateException: stream has already been operated upon or closed

        // 筛选出列表中的偶数，并打印
        Arrays.asList(1, 2, 1, 3, 3, 2, 4).stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);

        menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .forEach(System.out::println);
    }
}
