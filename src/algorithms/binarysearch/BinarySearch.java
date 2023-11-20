package algorithms.binarysearch;

//O(log n)
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[1024];
        for (int i = 0; i < 1024; i++) {
            arr[i] = i;
        }
        int start = 0;
        int end = arr.length - 1;
        int target = 55;

        System.out.println(binarySearch(arr, start, end, target));
    }

    private static boolean binarySearch(int[] arr, int start, int end, int target) {
        if (start > end) return false;
        int midIndex = (start + end) / 2;
        if(arr[midIndex] == target) return true;
        if(arr[midIndex] > target) {
            return binarySearch(arr, start, midIndex - 1, target);
        }
        return binarySearch(arr, midIndex + 1, end, target);
    }
}
