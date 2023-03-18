package lesson2_line_search;

public class FindFirstEven {
    public static void main(String[] args) {
        System.out.println(findFirstEven(new int[]{1, 1, 2, 7, 5, -2, 3, 1, 8, 10, 9}));
        System.out.println(findFirstEven(new int[]{}));
        System.out.println(findFirstEven(new int[]{1, 1}));
        System.out.println(findFirstEven(new int[]{2, 1}));
        System.out.println(findFirstEven(new int[]{1, 3, 7, 5, -2, 3, 2}));
        System.out.println(findFirstEven(new int[]{2}));
        System.out.println(findFirstEven(new int[]{3}));

        System.out.println("-------------------");

        System.out.println(findFirstOdd(new int[]{2, 7, 5, -2, 3, 1, 8, 10, 9}));
        System.out.println(findFirstOdd(new int[]{}));
        System.out.println(findFirstOdd(new int[]{2, 2}));
        System.out.println(findFirstOdd(new int[]{1, 2}));
        System.out.println(findFirstOdd(new int[]{4, 2, 6, 8, -1, 4, 3}));
        System.out.println(findFirstOdd(new int[]{3}));
        System.out.println(findFirstOdd(new int[]{2}));
    }

    public static int findFirstEven(int[] arr) {
        if(arr.length == 0) return -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0 && arr[i] % 2 == 0) return arr[i];
        }
        return -1;
    }

    public static int findFirstOdd(int[] arr) {
        if(arr.length == 0) return -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0 && arr[i] % 2 == 1) return arr[i];
        }
        return -1;
    }
}
