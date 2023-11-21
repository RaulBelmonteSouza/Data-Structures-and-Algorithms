package algorithms.binarysearch;

//O(log n)
public class RecursiveBinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[1024];
        for (int i = 0; i < 1024; i++) {
            arr[i] = i;
        }
        int start = 0;
        int end = arr.length - 1;
        int target = 55;

        System.out.println(recursiveBinarySearch(arr, start, end, target));
    }

    private static boolean recursiveBinarySearch(int[] arr, int start, int end, int target) {
        if (start > end) return false;
        int midIndex = (start + end) / 2;
        if(arr[midIndex] == target) return true;
        if(arr[midIndex] > target) {
            return recursiveBinarySearch(arr, start, midIndex - 1, target);
        }
        return recursiveBinarySearch(arr, midIndex + 1, end, target);
    }
}
