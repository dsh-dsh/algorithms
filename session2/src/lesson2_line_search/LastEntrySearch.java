package lesson2_line_search;

public class LastEntrySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 5, 1, 3};
        System.out.println(findLastX(arr, 5));
        System.out.println(findLastX(arr, -5));
        System.out.println(findLastX(arr, 10));
        System.out.println(findLastX(arr, 2));
        System.out.println(findLastX(arr, 3));
        System.out.println(findLastX(arr, 1));
    }

    public static int findLastX(int[] arr, int x) {
        for (int i = arr.length - 1 ; i >= 0; i--) {
            if(arr[i] == x) return i;
        }
        return -1;
    }
}
