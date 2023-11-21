package algorithms.binarysearch;

public class BinarySearch {


    public static void main(String[] args) {
        int[] arr = new int[1024];
        for (int i = 1; i < 1024; i++) {
            arr[i] = i;
        }

        int existentTarget = 55;
        int nonExistentTarget = 2000;

        System.out.println("Target " + existentTarget + " found: " + binarySearch(arr, existentTarget));
        System.out.println("Target " + nonExistentTarget + " found: " + binarySearch(arr, nonExistentTarget));
    }

    public static boolean binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int midIndex = (start + end) / 2;

            if (arr[midIndex] == target) return true;

            if (arr[midIndex] < target) {
                start = midIndex + 1;
            } else {
                end = midIndex - 1;
            }
        }
        return false;
    }
}
