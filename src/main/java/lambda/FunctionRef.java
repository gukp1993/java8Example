package main.java.lambda;

import main.java.lambda.domain.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author gukepeng
 * @since 2018/11/19
 */

/**
 * 1.指向静态方法的方法引用（Integer::parseInt）
 * 2.指向任意类型实例方法的方法引用（str.length()==>String::length）
 * 3.指向现有对象的实例方法的方法引用
 */
public class FunctionRef {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(160, "green"), new Apple(150, "red"));
        inventory.sort(Comparator.comparing(Apple::getWeight)); // Apple::getWeight 引用Apple类中定义的方法getWeight
        System.out.println(inventory);

        // Suppier接口，无参，执行自定义行为，返回泛型T
        Supplier<Apple> c1 = Apple::new; // 构造函数引用执行默认的Apple()构造函数
        Apple a1 = c1.get(); // 调用Supplier的get方法将产生一个新的Apple
        System.out.println(a1);

        // 上面等价于
        Supplier<Apple> c11 = () -> new Apple(); // 利用默认构造函数创建Apple的lambda表达式
        Apple a11 = c11.get();
        System.out.println(a11);

        Function<Integer, Apple> c2 = Apple::new;
        Apple a2 = c2.apply(110);
        System.out.println("默认构造函数方法引用：" + a2);

        Function<Integer, Apple> c22 = (weight) -> new Apple(weight);
        Apple a22 = c22.apply(110);
        System.out.println("默认构造函数，函数描述符：" + a22);


        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        map(weights, Apple::new);

        BiFunction<Integer, String, Apple> c3 = Apple::new;
        Apple a3 = c3.apply(110, "green");
        System.out.println("默认构造函数方法引用：" + a3);

        BiFunction<Integer, String, Apple> c33 = (weight, color) -> new Apple(weight, color);
        Apple a33 = c33.apply(110, "green");
        System.out.println("默认构造函数，函数描述符：" + a33);
    }

    public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for (Integer e : list) {
            result.add(f.apply(e));
        }
        System.out.println(result);
        return result;
    }
}
