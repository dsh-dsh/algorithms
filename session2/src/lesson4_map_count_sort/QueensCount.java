package lesson4_map_count_sort;

import java.util.HashMap;
import java.util.Map;

public class QueensCount {
    public static void main(String[] args) {
        Cord[] cords = new Cord[]{new Cord(1,2), new Cord(3,4), new Cord(1, 4), new Cord(5, 2),
                new Cord(3, 1), new Cord(5, 4), new Cord(5, 1), new Cord(2, 1)};
        System.out.println(countPairs(cords));
    }

    private static int countPairs(Cord[] cords) {
        Map<Integer, Integer> xLine = new HashMap<>();
        Map<Integer, Integer> yLine = new HashMap<>();
        Map<Integer, Integer> leftDiagonal = new HashMap<>();
        Map<Integer, Integer> rightDiagonal = new HashMap<>();

        for (int i = 0; i < cords.length; i++) {
            addQueenOnAxis(xLine, cords[i].x);
            addQueenOnAxis(yLine, cords[i].y);
            addQueenOnDiagonal(leftDiagonal, cords[i], 1);
            addQueenOnDiagonal(rightDiagonal, cords[i], -1);

        }

        return getPairsNum(xLine) + getPairsNum(yLine) + getPairsNum(leftDiagonal) + getPairsNum(rightDiagonal);
    }

    private static int getPairsNum(Map<Integer, Integer> line) {
        int pairs = 0;
        for (Map.Entry<Integer, Integer> entry : line.entrySet()) {
            pairs += entry.getValue() - 1;
        }
        return pairs;
    }

    private static void addQueenOnAxis(Map<Integer, Integer> map, int cord) {
        map.merge(cord, 1, Integer::sum);
    }

    private static void addQueenOnDiagonal(Map<Integer, Integer> map, Cord cord, int sign) {
        int key = cord.x - (cord.y * sign);
        map.merge(key, 1, Integer::sum);
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
