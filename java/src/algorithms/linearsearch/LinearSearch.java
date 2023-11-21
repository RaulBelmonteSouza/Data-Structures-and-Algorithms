package algorithms.linearsearch;

// O(n)
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1,8,2,7,6,3,5,4,50,10,15,58,77,11,99};
        int targetExistent = 58;
        int targetNonExistent = 987;

        System.out.println(linearSearch(arr, targetExistent));
        System.out.println(linearSearch(arr, targetNonExistent));
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }

        return -1;
    }
}
