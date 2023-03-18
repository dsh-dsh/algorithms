package lesson3_sets;

import java.util.Random;

public class MySet {

    public static void main(String[] args) {

        Set<Integer> set = new Set<>();
        for (int i = 1; i < 10; i++) {
            set.add(i * 7);
        }
        set.delete(14);
        set.add(13);
        set.add(23);
        set.add(33);
        set.add(43);
        set.add(53);
        set.add(73);
        System.out.println(set.contains(33));
        System.out.println("------");

        Set<String> strings = new Set<>();
        for (int i = 0; i < 40; i++) {
            strings.add(getRandomString());
        }
        System.out.println("--------------");
;    }

    static String getRandomString(){
        int random = new Random().nextInt(20);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            builder.append(i * new Random().nextInt(10));
        }
        return builder.toString();
    }

}
