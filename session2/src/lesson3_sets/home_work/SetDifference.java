package lesson3_sets.home_work;

import java.util.*;
import java.util.stream.Collectors;

public class SetDifference {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Set<Integer> conceived = getConceived(scanner.nextInt());
        Set<Integer> existing = new HashSet<>();
        Set<Integer> absent = new HashSet<>();
        String[] numbers = new String[0];
        String line = "";

        while(true) {
            line = scanner.nextLine();
            if(line.equals("NO")) {
                addAll(absent, numbers);
            } else if(line.equals("YES")) {
                addAll(existing, numbers);
            } else if(line.equals("HELP")) {
                break;
            } else {
                numbers = line.split(" ");
            }
        }

        if(existing.isEmpty()) existing = conceived;
        existing.removeAll(absent);

        System.out.println(existing.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));

    }

    private static Set<Integer> getConceived(int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(i);
        }
        return set;
    }

    private static void addAll(Set<Integer> set, String[] arr){
        Integer[] intArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            intArr[i] = Integer.parseInt(arr[i]);
        }
        Collections.addAll(set, intArr);
    }

}
