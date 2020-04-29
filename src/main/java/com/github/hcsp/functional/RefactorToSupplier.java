package com.github.hcsp.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class RefactorToSupplier {
    private static int count = 0;
    
    private static int randomInt() {
        return new Random().nextInt();
    }
    
    private static String IncreaseInteger() {
        return "" + count++;
    }

    public static void main(String[] args) {
        /* create objects */
        Supplier<Object> createObjects = () -> new Object();
        System.out.println(create(createObjects));

        /* Create Strings */
        Supplier<Object> createStrings = () -> IncreaseInteger();
        System.out.println(createStrings());
        System.out.println(create(createStrings));

        /* Create Integers */
        Supplier<Object> createRandomIntegers = () -> randomInt();
        System.out.println(create(createRandomIntegers));
    }

    // 请尝试使用函数式接口Supplier对三个方法进行重构，消除冗余代码
    // 并尽量尝试使用lambda表达式和方法引用来传递参数
    public static List<Object> create(Supplier<Object> supplier) {
        List<Object> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            result.add(supplier.get());
        }
        return result;
    }

    public static List<Object> createObjects() {
        List<Object> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            result.add(new Object());
        }
        return result;
    }

    public static List<Object> createStrings() {
        List<Object> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            result.add("" + i);
        }
        return result;
    }

    public static List<Object> createRandomIntegers() {
        List<Object> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            result.add(randomInt());
        }
        return result;
    }
}
