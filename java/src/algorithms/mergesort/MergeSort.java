package algorithms.mergesort;

import java.util.Arrays;
import java.util.stream.IntStream;

//O(n log n)
public class MergeSort {


    public static void main(String[] args) {
        int[] arr = {1,8,2,7,6,3,5,4,50,10,15,58,77,11,99};
        int[] resultArray = mergeSort(arr);
        System.out.println(Arrays.toString(resultArray));
    }

    private static int[] mergeSort(int[] arr) {
        if(arr.length < 2) return arr;

        int middleIndex = arr.length / 2;
        int[] leftArray = Arrays.copyOfRange(arr, 0, middleIndex);
        int[] rightArray = Arrays.copyOfRange(arr, middleIndex, arr.length);

        return merge(mergeSort(leftArray), mergeSort(rightArray));
    }

    private static int[] merge(int[] leftArray, int[] rightArray) {
        int[] resultArray = new int[0];
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            resultArray = Arrays.copyOf(resultArray, resultArray.length + 1);
            if (leftArray[leftIndex] < rightArray[rightIndex]) {
                resultArray[resultIndex] = leftArray[leftIndex];
                leftIndex++;
            } else {
                resultArray[resultIndex] = rightArray[rightIndex];
                rightIndex++;
            }
            resultIndex++;
        }

        resultArray = concatIntArray(resultArray, Arrays.copyOfRange(leftArray, leftIndex, leftArray.length));
        resultArray = concatIntArray(resultArray, Arrays.copyOfRange(rightArray, rightIndex, rightArray.length));
        return resultArray;
    }

    private static int[] concatIntArray(int[] arr, int[] concatArray) {
        return IntStream.concat(Arrays.stream(arr), Arrays.stream(concatArray)).toArray();
    }
}
