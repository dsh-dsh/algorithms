package lesson3_sets.home_work;

import java.util.*;

public class CarNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] testimonies = getTestimonies(scanner);
        List<String> signList = getSignsList(scanner);
        Map<String, Integer> signs = getSigns(signList);
        int max = setMatches(testimonies, signs);

        for(String str : signList) {
            if(signs.get(str) == max) System.out.println(str);
        }
    }

    private static int setMatches(String[] testimonies, Map<String, Integer> signs) {
        int max = 0;
        for (int i = 0; i < testimonies.length; i++) {
            for (String str : signs.keySet()) {
                char[] arr = str.toCharArray();
                boolean match = true;
                for(char c : testimonies[i].toCharArray()) {
                    if(!containsChar(arr,c)) {
                        match = false;
                        break;
                    }
                }
                if(match) {
                    signs.put(str, signs.get(str) + 1);
                    max = Math.max(max, signs.get(str));
                }
            }
        }
        return max;
    }

    private static boolean containsChar(char[] arr, char c) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == c) return true;
        }
        return false;
    }

    private static String[] getTestimonies(Scanner scanner){
        int witnessNum = scanner.nextInt();
        String[] testimonies = new String[witnessNum];
        for (int i = 0; i < witnessNum; i++) {
            String str = scanner.nextLine();
            if(str.equals("")) {
                i--;
                continue;
            }
            testimonies[i] = str;
        }
        return testimonies;
    }

    private static List<String> getSignsList(Scanner scanner) {
        int signsNum = scanner.nextInt();
        List<String> signs = new ArrayList<>();
        for (int i = 0; i < signsNum; i++) {
            String str = scanner.nextLine();
            if(str.equals("")) {
                i--;
                continue;
            }
            signs.add(str);
        }
        return signs;
    }

    private static Map<String, Integer> getSigns(List<String> list) {
        Map<String, Integer> signs = new LinkedHashMap<>();
        for (int i = 0; i < list.size(); i++) {
            signs.put(list.get(i), 0);
        }
        return signs;
    }
}
