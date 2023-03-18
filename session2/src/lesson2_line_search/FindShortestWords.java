package lesson2_line_search;

import java.util.LinkedList;
import java.util.List;

public class FindShortestWords {
    public static void main(String[] args) {
        System.out.println(findShortestWordsNaive(new String[]{"a", "bb", "ccc", "dddd", "eeeee", "ffffff"}));
        System.out.println(findShortestWordsNaive(new String[]{"a", "bb", "ccc", "d", "eeeee", "f"}));

        System.out.println(findShortestWords(new String[]{"a", "bb", "ccc", "dddd", "eeeee", "ffffff"}));
        System.out.println(findShortestWords(new String[]{"a", "bb", "ccc", "d", "eeeee", "f"}));
        System.out.println(findShortestWords(new String[]{"eeeee", "aaa", "ss", "s", "a", "bb", "ccc", "d", "eeeee", "f"}));
    }
    static String findShortestWordsNaive(String[] strings) {
        int min = strings[0].length();
        for (int i = 1; i < strings.length; i++) {
            if(min > strings[i].length()) min = strings[i].length();
        }
        StringBuilder builder = new StringBuilder();
        boolean exists = false;
        for (int i = 0; i < strings.length; i++) {
            if(strings[i].length() == min) {
                if(exists) builder.append(" ");
                builder.append(strings[i]);
                exists = true;
            }
        }
        return builder.toString();
    }

    static String findShortestWords(String[] strings) {
        List<String> list = new LinkedList<>();
        list.add(strings[0]);
        int min = strings[0].length();
        for (int i = 1; i < strings.length; i++) {
            if(strings[i].length() == min) {
                list.add(strings[i]);
            } else if(strings[i].length() < min) {
                list.clear();
                list.add(strings[i]);
                min = strings[i].length();
            }
        }
        return String.join(" ", list);
    }
}
