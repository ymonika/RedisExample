package com.example.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class KaprekarNumber {

    static void kaprekarNumbers(int p, int q) {
        List<Integer> kaprekarNums = new ArrayList<>();

        for (int num = p; num <= q; num++) {
            long squareNum = (long) num * num;
            String squareNumStr = String.valueOf(squareNum);
            String leftStr = squareNumStr.substring(0, squareNumStr.length() / 2);
            String rightStr = squareNumStr.substring(squareNumStr.length() / 2);
            int leftNum = leftStr.isEmpty() ? 0 : Integer.parseInt(leftStr);
            int rightNum = rightStr.isEmpty() ? 0 : Integer.parseInt(rightStr);

            if (leftNum + rightNum == num) {
                kaprekarNums.add(num);
            }
        }
        if (kaprekarNums.isEmpty()) {
            System.out.println("INVALID RANGE");
        }
        kaprekarNums.stream().forEach(i -> System.out.print(i + " "));
    }

    public static void main(String[] args) {
        //1 9 45 55 99 297 703 999 2223 2728 4950 5050 7272 7777 9999 17344 22222 77778 82656 95121 99999
        // kaprekarNumbers(1, 99999);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 7, 8, 19, 19, 5, 6);
        Map map = list.stream().filter(number -> number > 5).collect(
                Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                )
        );
        System.out.println(map);
    }
}
