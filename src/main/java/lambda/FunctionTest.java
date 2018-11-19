package main.java.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author gukepeng
 * @since 2018/11/16
 */
public class FunctionTest {

    public static void main(String[] args) {
        List<Integer> l = map(Arrays.asList("lambdas", "in", "action"), s -> s.length());
        System.out.println(l);
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T s : list) {
            result.add(f.apply(s)); // 接受泛型对象，执行自定义行为，并返回一个泛型对象T->R
        }
        return result;
    }
}
