package main.java.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author gukepeng
 * @since 2018/11/16
 */
public class ConsumerTest {
    public static void main(String[] args) {
        forEach(Arrays.asList(1, 2, 3, 4, 5), i -> System.out.println(i));
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T i : list) {
            c.accept(i); // 接收泛型对象，执行自定义行为，返回类型void T->void
        }
    }

}
