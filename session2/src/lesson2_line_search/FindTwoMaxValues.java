package lesson2_line_search;

import java.util.Arrays;

public class FindTwoMaxValues {
    public static void main(String[] args) {
        int[] arr = {1, 9, 2, 1, 5, -2, 3, 1, 8, 10};
        System.out.println(Arrays.toString(findMaxEntry(arr)));
        int[] emptyArr = {2, 1};
        System.out.println(Arrays.toString(findMaxEntry(emptyArr)));
        int[] arr1 = {3, 3};
        System.out.println(Arrays.toString(findMaxEntry(arr1)));
        int[] arr2 = {1, 1, 2, 1, 5, -2, 3, 1, 8, 10};
        System.out.println(Arrays.toString(findMaxEntry(arr2)));
        int[] arr3 = {1, 1, 2, 7, 5, -2, 3, 1, 8, 10, 9};
        System.out.println(Arrays.toString(findMaxEntry(arr3)));
    }
    public static int[] findMaxEntry(int[] arr) {
        int max1 = Math.max(arr[0], arr[1]);
        int max2 = Math.min(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            if(arr[i] > max1) {
                max2 = max1;
                max1 = arr[i];
            } else if(arr[i] > max2) {
                max2 = arr[i];
            }
        }
        return new int[]{max1, max2};
    }
}
