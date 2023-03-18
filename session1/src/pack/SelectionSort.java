package pack;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        String[] arr = new String[] {"lyo", "bcd", "fge", "abc", "kfh", "jry", "pti"};
        System.out.println(Arrays.toString(selectionSort(arr)));
    }

    public static String[] selectionSort(String[] array) {
        for (int i = 0; i < array.length; i++) {
            String min = array[i];
            int minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if (min.compareTo(array[j]) > 0) {
                    min = array[j];
                    minIndex = j;
                }
            }
            String temp = array[i];
            array[i] = min;
            array[minIndex] = temp;
        }
        return array;
    }
}
