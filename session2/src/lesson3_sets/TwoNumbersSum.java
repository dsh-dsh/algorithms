package lesson3_sets;


public class TwoNumbersSum {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 4, 4, 6, 5, 8, 9, 22, 45, 67};
        System.out.println(findTwoNumbersOfSum(arr, 8));
        System.out.println(findTwoNumbersWithSet(arr, 8));
    }

    static Cort findTwoNumbersWithSet(int[] arr, int x) {
        Set<Integer> set = new Set<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
            if(i > 0) {
                if(arr[i] + arr[i] != x && set.contains(x - arr[i]))
                    return new Cort(x - arr[i], arr[i]);
            }
        }
        return Cort.empty();
    }

    static Cort findTwoNumbersOfSum(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] != arr[j] && arr[i] + arr[j] == x) {
                    return new Cort(arr[i], arr[j]);
                }
            }
        }
        return Cort.empty();
    }

    static class Cort {
        int a;
        int b;

        public Cort(int a, int b) {
            this.a = a;
            this.b = b;
        }

        static Cort empty(){
            return new Cort(0,0);
        }

        @Override
        public String toString() {
            return "Cort{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }
}
