package lesson2_line_search;

public class FirstEntrySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(findX(arr, 5));
        System.out.println(findX(arr, -5));
        System.out.println(findX(arr, 10));
        System.out.println(findX(arr, 1));
        System.out.println(findX(arr, 6));
    }

    public static int findX(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == x) return i;
        }
        return -1;
    }
}
