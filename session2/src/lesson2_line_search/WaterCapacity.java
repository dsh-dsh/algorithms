package lesson2_line_search;

public class WaterCapacity {
    public static void main(String[] args) {
        System.out.print(findWaterCapacity(new int[]{3, 1, 4, 3, 5, 1, 1, 3, 1}));
        System.out.print(" ");
        System.out.println(findWaterCapacityTwoPointer(new int[]{3, 1, 4, 3, 5, 1, 1, 3, 1}));

        System.out.print(findWaterCapacity(new int[]{3, 1, 4, 3, 5, 1, 1, 3, 1, 3}));
        System.out.print(" ");
        System.out.println(findWaterCapacityTwoPointer(new int[]{3, 1, 4, 3, 5, 1, 1, 3, 1, 3}));

        System.out.print(findWaterCapacity(new int[]{3, 1, 4, 3, 3, 1, 1, 3, 1}));
        System.out.print(" ");
        System.out.println(findWaterCapacityTwoPointer(new int[]{3, 1, 4, 3, 3, 1, 1, 3, 1}));

        System.out.print(findWaterCapacity(new int[]{3, 1, 5, 3, 5, 1, 1, 3, 1}));
        System.out.print(" ");
        System.out.println(findWaterCapacityTwoPointer(new int[]{3, 1, 5, 3, 5, 1, 1, 3, 1}));

        System.out.print(findWaterCapacity(new int[]{1, 2, 3, 4, 3, 5, 1, 1, 3, 1}));
        System.out.print(" ");
        System.out.println(findWaterCapacityTwoPointer(new int[]{1, 2, 3, 4, 3, 5, 1, 1, 3, 1}));

        System.out.print(findWaterCapacity(new int[]{5, 1, 1, 1, 1, 1, 1, 1, 1, 5}));
        System.out.print(" ");
        System.out.println(findWaterCapacityTwoPointer(new int[]{5, 1, 1, 1, 1, 1, 1, 1, 1, 5}));

        System.out.print(findWaterCapacity(new int[]{5, 1, 1, 1, 5, 1, 1, 1, 1, 5}));
        System.out.print(" ");
        System.out.println(findWaterCapacityTwoPointer(new int[]{5, 1, 1, 1, 5, 1, 1, 1, 1, 5}));

        System.out.print(findWaterCapacity(new int[]{5, 1, 1, 7, 1, 8, 1, 1, 1, 5}));
        System.out.print(" ");
        System.out.println(findWaterCapacityTwoPointer(new int[]{5, 1, 1, 7, 1, 8, 1, 1, 1, 5}));
    }
    static int findWaterCapacity(int[] arr) {
        int max = 0, maxIndex = 0, result = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        max = arr[0];
        for (int i = 1; i < maxIndex; i++) {
            if(arr[i] > max) max = arr[i];
            result += max - arr[i];
        }
        max = arr[arr.length - 1];
        for (int i = arr.length - 2; i > maxIndex; i--) {
            if(arr[i] > max) max = arr[i];
            result += max - arr[i];
        }
        return result;
    }

    // todo add two pointer

    static int findWaterCapacityTwoPointer(int[] arr) {
        int left = 1, right = arr.length - 2;
        int prevLeft = 0, prevRight = arr.length - 1;
        int maxLeft = arr[0], maxRight = arr[arr.length - 1];
        int capacity = 0;
        while (left < right) {
            if(maxLeft < arr[left]) maxLeft = arr[left];
            if(prevLeft != left) capacity += maxLeft - arr[left];
            if(maxRight < arr[right]) maxRight = arr[right];
            if(prevRight != right) capacity += maxRight - arr[right];
            if(maxLeft <= maxRight) {
                left++;
                prevRight = right;
            } else {
                right--;
                prevLeft = left;
            }
        }
        return capacity;
    }
}
