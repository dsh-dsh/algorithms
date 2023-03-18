package lesson4_map_count_sort;

import java.util.*;

public class RooksCount {
    public static void main(String[] args) {
        Cord[] cords = new Cord[]{new Cord(1,2), new Cord(3,4), new Cord(1, 4), new Cord(3, 1), new Cord(5, 4), new Cord(5, 1)};
        System.out.println(countPairs(cords));
    }

    private static int countPairs(Cord[] cords) {
        Map<Integer, Integer> xLine = new HashMap<>();
        Map<Integer, Integer> yLine = new HashMap<>();

        for (int i = 0; i < cords.length; i++) {
            addRook(xLine, cords[i].x);
            addRook(yLine, cords[i].y);
        }

        return getPairsNum(xLine) + getPairsNum(yLine);
    }

    private static int getPairsNum(Map<Integer, Integer> line) {
        int pairs = 0;
        for (Map.Entry<Integer, Integer> entry : line.entrySet()) {
            pairs += entry.getValue() - 1;
        }
        return pairs;
    }

    private static void addRook(Map<Integer, Integer> map, int cord) {
        map.merge(cord, 1, Integer::sum);
    }

    static class Cord {
        int x = 0;
        int y = 0;
        public Cord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
