package lesson4_map_count_sort;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        long input = 8392874586299185098L;
        System.out.println(getLong(getSortedLong(getSortedArr(input))));
        String strInput = "abcdeakdfaoptdhfjdkfophafjyzxttlalsdkfh kdasfkajsdtkywxzfjdskjfkasjddfa dads";
        System.out.println(getSortedString(getSortedArr(strInput)));

        System.out.println(equalsByNumbers(2021L, 1012));
        System.out.println(equalsByNumbers(2021L, 1022));
    }

    private static boolean equalsByNumbers(long a, long b) {
        int[] arrA = getSortedArr(a);
        int[] arrB = getSortedArr(b);
        return arraysEquals(arrA, arrB);
    }

    private static boolean arraysEquals(int[] arrA, int[] arrB) {
        if(arrA.length != arrB.length) return false;
        for (int i = 0; i < arrA.length; i++) {
            if(arrA[i] != arrB[i]) return false;
        }
        return true;
    }

    private static String getSortedLong(int[] arr) {
        StringBuilder builder = new StringBuilder();
        System.out.println(Arrays.toString(arr));
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= arr[i]; j++) {
                builder.append(i);
            }
        }
        return builder.toString();
    }

    private static String getSortedString(int[] arr) {
        StringBuilder builder = new StringBuilder();
        System.out.println(Arrays.toString(arr));
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= arr[i]; j++) {
//                System.out.println((i + " " + (char) (i + 97)));
                builder.append((char)(i + 97));
            }
        }
        return builder.toString();
    }

    // only latin letters
    private static int[] getSortedArr(String input) {
        int[] arr = new int[26];
        int index;
        for(char c : input.toLowerCase().replaceAll(" ", "").toCharArray()){
            index = (int) c - 97;
            arr[index] = arr[index] + 1;
        }
        return arr;
    }

    private static int[] getSortedArr(long a) {
        int[] arr = new int[10];
        int number;
        while(a != 0) {
            number = (int)(a % 10);
            arr[number] = arr[number] + 1;
            a = a / 10;
        }
        return arr;
    }

    private static long getLong(String input) {
        return Long.parseLong(input);
    }
}
