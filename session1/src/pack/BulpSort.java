package pack;

import java.util.Arrays;

public class BulpSort {
    public static void main(String[] args) {
        int[] arr = new int[] {2,6,4,8,3,9,5,8,2,6,7,9};
        System.out.println(Arrays.toString(bulpSort(arr)));
    }

    public static int[] bulpSort(int[] array) {
        boolean isSorted = false;
        int temp;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length-1; i++) {
                if (array[i] > array[i+1]) {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    isSorted = false;
                }
            }
        }
        return array;
    }
}
