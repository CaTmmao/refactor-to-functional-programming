package com.github.hcsp.functional;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RefactorToConsumer {
    public static void main(String[] args) {
        Map<String, String> map1 = Stream.of("a", "b", "c").collect(Collectors.toMap(k -> k, v -> v));
        Map<String, String> map2 = Stream.of("d", "e", "f").collect(Collectors.toMap(k -> k, v -> v));

        printWithDelim(map1, map2, ",");

        printWithDelim(map1, map2, "-");

        printWithDelim(map1, map2, ":");

        BiConsumer<String, String> consumerComma = (key, value) -> System.out.println(key + "," + value);
        printWithConsumer(map1, map2, consumerComma);

        BiConsumer<String, String> consumerDash = (key, value) -> System.out.println(key + "-" + value);
        printWithConsumer(map1, map2, consumerDash);

        BiConsumer<String, String> consumerColon = (key, value) -> System.out.println(key + ":" + value);
        printWithConsumer(map1, map2, consumerColon);
    }

    /*
     * 请尝试使用BiConsumer函数式接口重构下列三个方法，消除重复代码，提高可读性 // 提示：你可以使用Map.forEach方法 //
     * 加分项：如果你能编写一个返回BiConsumer的高阶函数（即"返回函数的函数"），那就更好了
     */

    public static void printWithDelim(Map<String, String> map1, Map<String, String> map2, String string) {
        map1.forEach((key, value) -> {
            System.out.println(key + string + value);
        });
        map2.forEach((key, value) -> {
            System.out.println(key + string + value);
        });
    }

    public static void printWithConsumer(Map<String, String> map1, Map<String, String> map2,
            BiConsumer<String, String> consumer) {
        map1.forEach(consumer);
        map2.forEach(consumer);
    }

    public static void printWithComma(Map<String, String> map1, Map<String, String> map2) {
        for (Map.Entry<String, String> entry : map1.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "," + value);
        }

        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "," + value);
        }
    }

    public static void printWithDash(Map<String, String> map1, Map<String, String> map2) {
        for (Map.Entry<String, String> entry : map1.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "-" + value);
        }

        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "-" + value);
        }
    }

    public static void printWithColon(Map<String, String> map1, Map<String, String> map2) {
        for (Map.Entry<String, String> entry : map1.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ":" + value);
        }

        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ":" + value);
        }
    }
}
