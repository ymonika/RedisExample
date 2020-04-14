package com.example.hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class HappyLadyBug {

    static String happyLadybugs(String b) {
        boolean isAllEven = true;
        Map<String, Long> map = Arrays.stream(b.split("")).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        //System.out.println(map);
        boolean isUnderscore = !(map.get("_") == null);

        map.remove("_");
        for (Map.Entry<String, Long> mapRow : map.entrySet()) {
            Long value = mapRow.getValue();
            if (value == 1) {
                isAllEven = false;
            }
        }
        return (isAllEven && isUnderscore) || map.size() == 1 ? "YES" : "NO";
    }

    public static void main(String[] args) {
        System.out.println(happyLadybugs("CCC_"));
        System.out.println(happyLadybugs("CCC"));
        System.out.println(happyLadybugs("X_Y__X"));
    }
}
