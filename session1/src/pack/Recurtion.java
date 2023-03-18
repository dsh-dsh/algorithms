package pack;

import java.util.*;

public class Recurtion {

    public static void main(String[] args) {

        //recurtion(10);

        //System.out.println(factorial(3));

        //System.out.println(sumArray(new int[] {1,2,3,4,5}));

        int[] arr = new int[1000]; //{3,8,5,6,1,9,2,4,7};
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(arr.length);
        }
        Clock clock = new Clock();
        Long timeStart = new Date().getTime();
        int[] array = quickSort(arr, 0);
        //int[] array = bulpSort(arr);
        clock.interrupt();
        Long timeStop = new Date().getTime();
        System.out.println("\n" + (timeStop-timeStart));
        System.out.println(Arrays.toString(array));
        System.out.println(BinarySearch(657, array));

    }

    public static int BinarySearch(int value, int[] sortedArr) {
        if (sortedArr.length < 2) {
            return sortedArr[0];
        } else {
            int[] newArr;
            int pivot = sortedArr.length/2;
            if (value < sortedArr[pivot]) {
                newArr = new int[pivot];
                System.arraycopy(sortedArr, 0, newArr, 0, pivot);
            } else {
                int newLen = pivot + ((sortedArr.length % 2 == 0) ? 0 : 1);
                newArr = new int[newLen];
                System.arraycopy(sortedArr, pivot, newArr, 0, newLen);
            }
            return BinarySearch(value, newArr);
        }
    }

    public static void recurtion(int count) {
        System.out.print(count + " ");
        if (count <= 0) {
            return;
        } else {
            recurtion(--count);
        }
    }

    public static int factorial(int arg) {
        if (arg == 1) {
            return arg;
        } else {
            return arg * factorial(arg-1);
        }
    }

    public static int sumArray(int[] array) {
        if (array.length < 2) {
            return array[0];
        } else {
            return array[0] + sumArray(Arrays.copyOfRange(array, 1, array.length));
        }
    }

    public static int[] getLeft(int[] array, int pivot) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[pivot]) {
                list.add(array[i]);
            }
        }
        int[] leftArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            leftArr[i] = list.get(i);
        }
        return leftArr;
    }

    public static int[] getRight(int[] array, int pivot) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[pivot]) {
                list.add(array[i]);
            }
        }
        int[] rightArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            rightArr[i] = list.get(i);
        }
        return rightArr;
    }

    public static int[] quickSort(int[] array, int i) {
        if (array.length < 2) {
            return array;
        } else {
            int pivot = array.length / 2;

            int[] newArray = new int[array.length];

            int[] leftArray = quickSort(getLeft(array, pivot), pivot);
            int[] rightArray = quickSort(getRight(array, pivot), pivot);

            System.arraycopy(leftArray, 0, newArray, 0, leftArray.length);
            System.arraycopy(array, pivot, newArray, leftArray.length, 1);
            System.arraycopy(rightArray, 0, newArray, leftArray.length+1, rightArray.length);

            return  newArray;
        }
    }

    static class Clock extends Thread {
        public Clock() {
            start();
        }

        @Override
        public void run() {
            while (!isInterrupted()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    return;
                    //e.printStackTrace();
                }
                System.out.print(". ");
            }
        }
    }

}

class ListNode {
    ListNode next;
    int value;

    public ListNode(int value) {
        this.value = value;
    }
}

class LinkList {
    private ListNode head;

    public LinkList() {
        head = null;
    }

    public void add(int value) {
        ListNode node = new ListNode(value);
        node.next = head;
        head = node;
    }

    public boolean isEmpty() {
        return head == null;
    }

//    public boolean hasNext() {
//        return
//    }

    public void print() {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}
