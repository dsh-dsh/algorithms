package lesson3_sets.home_work;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CountSame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().split(" ");
        String[] line2 = scanner.nextLine().split(" ");
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        for (String str : line1) {
            set1.add(str);
        }
        int count = 0;
        for(String str : line2) {
            if(!set2.contains(str) && set1.contains(str)) count++;
            set2.add(str);
        }
        System.out.println(count);
    }
}
