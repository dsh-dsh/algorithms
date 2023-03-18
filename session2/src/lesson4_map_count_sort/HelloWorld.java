package lesson4_map_count_sort;

import java.util.*;
import java.util.stream.Collectors;

public class HelloWorld {
    public static void main(String[] args) {
        String hello = "Hello, world!";
        Map<Character, Integer> map = new HashMap<>();
        int maxEntry = 0;
        for(char c : hello.toCharArray()) {
            if(map.containsKey(c)) {
               map.put(c, map.get(c) + 1);
               maxEntry++;
            } else {
                map.put(c, 1);
            }
        }
        List<Character> sortedList = new ArrayList<>(map.keySet());
        sortedList.sort(Comparator.comparing(Character::charValue));
        for (int i = maxEntry; i > 0; i--) {
            for (int j = 0; j < sortedList.size(); j++) {
                if(map.get(sortedList.get(j)) >= i) System.out.print("#");
                else System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println(sortedList.stream().map(String::valueOf).collect(Collectors.joining()));
    }
}
