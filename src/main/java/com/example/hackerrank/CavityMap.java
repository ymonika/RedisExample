package com.example.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class CavityMap {

    static String[] cavityMap(String[] grid) {
        int[][] array = convertStringArrayToMatrix(grid);
        int[][] arrayCopy = array;
        int n = grid.length;

        for (int i = 1; i < (n - 1); i++) {
            for (int j = 1; j < (n - 1); j++) {
                int number = array[i][j];
                boolean upper = number > array[i - 1][j];
                boolean lower = number > array[i + 1][j];
                boolean previous = number > array[i][j - 1];
                boolean next = number > array[i][j + 1];

                if (upper && lower && previous && next) {
                    array[i][j] = Integer.MAX_VALUE;
                    //arrayCopy[i][j] = -1;
                }
            }
        }
        String[] printStr = new String[n];
        int i = 0;
        for (int[] line : array) {
            printStr[i] = getStringFromInt.apply(line).replace("2147483647", "X");
            System.out.println(printStr[i]);
            i++;
        }
        return printStr;
    }

    static Function<int[], String> getStringFromInt = line -> {
        String s = "";
        for (int i : line) {
            s += i;
        }
        return s;
    };


    private static int[][] convertStringArrayToMatrix(String[] grid) {
        int n = grid.length, i = 0;
        int[][] array = new int[n][n];
        for (String line : grid) {
            array[i] = Arrays.stream(line.split("")).mapToInt(Integer::parseInt)
                    .toArray();
            i++;

        }
        return array;
    }

    public static void main(String[] args) {
/*

        System.out.println(cavityMap(new String[]{"111", "111", "111"}));
        cavityMap(new String[]{"1112", "1912", "1892", "1234"});
*/

        cavityMap(new String[]{
                "179443854",
                "961621369",
                "164139922",
                "968633951",
                "812882578",
                "257829163",
                "812438597",
                "176656233",
                "485773814"
        });
    }
}
/*

        179443854
                961X21369
                164139922
                96X633951
                812882578
                25782X163
                8124385X7
                176656233
                485773814
*/









