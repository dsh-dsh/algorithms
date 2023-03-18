package lesson2_line_search;

public class FindMaxValue {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, -2, 3, 1};
        System.out.println(findMaxEntry(arr));
        System.out.println(findMinEntry(arr));

        int[] emptyArr = new int[0];
        System.out.println(findMinEntry(emptyArr));
    }
    public static int findMaxEntry(int[] arr) {
        if(arr.length == 0) return -1;
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > result) result = arr[i];
        }
        return result;
    }

    public static int findMinEntry(int[] arr) {
        if(arr.length == 0) return -1;
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < result) result = arr[i];
        }
        return result;
    }
}
