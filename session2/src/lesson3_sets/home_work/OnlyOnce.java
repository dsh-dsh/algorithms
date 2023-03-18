package lesson3_sets.home_work;

import java.util.*;

public class OnlyOnce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");

        Map<String, Integer> map = new LinkedHashMap<>();
        for (String str : line) {
            map.merge(str, 1, Integer::sum);
        }

        boolean start = true;
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                if(!start) System.out.print(" ");
                System.out.print(entry.getKey());
            }
            start = false;
        }
    }
}
