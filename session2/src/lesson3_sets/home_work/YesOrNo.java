package lesson3_sets.home_work;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class YesOrNo {

    private static final String YES = "YES";
    private static final String NO = "NO";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().split(" ");
        Set<String> set = new HashSet<>();
        for (String str : line1) {
            if(set.contains(str)) {
                System.out.println(YES);
            } else {
                set.add(str);
                System.out.println(NO);
            }
        }
    }

}
