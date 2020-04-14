package com.example.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SpaceStation {

    static int flatlandSpaceStations(int n, int[] c) {
        List<Integer> spaceStationDistance = new ArrayList<>();
        Arrays.sort(c);
        for (int station = 0; station < n; station++) {
            int minDistance = Integer.MAX_VALUE;
            for (int spaceStation : c) {
                if (station - spaceStation == 0) {
                    minDistance = 0;
                } else if (Math.abs(station - spaceStation) <= minDistance) {
                    minDistance = Math.abs(station - spaceStation);
                }
            }
            spaceStationDistance.add(minDistance);
        }
        //System.out.println(spaceStationDistance);

        return spaceStationDistance.stream().max(Comparator.naturalOrder()).get();
    }


    public static void main(String[] args) {

        //System.out.println(flatlandSpaceStations(5, new int[]{0, 4})); // 0 1 2 1 0
        System.out.println(flatlandSpaceStations(6, new int[]{10, 1, 2, 3, 4, 5})); // 0 0 0 0 0 0
    }
}
