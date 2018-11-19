package main.java.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author gukepeng
 * @since 2018/11/16
 */
public class PredicateTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "", "3", "");
        List<String> notEmpty = filter(list, s -> !s.isEmpty());
        System.out.println(notEmpty);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T s : list) {
            if (p.test(s)) { // 接收泛型对象，执行自定义行为，返回boolean值 T->boolean
                results.add(s);
            }
        }
        return results;
    }
}
