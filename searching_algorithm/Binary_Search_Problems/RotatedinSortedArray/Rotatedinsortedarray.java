package searching_algorithm.Binary_Search_Problems.RotatedinSortedArray;

public class Rotatedinsortedarray {
      public static void main(String[] args) {

        // Rotated sorted array
        int arr[] = {3, 4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        /*
         * Step 1: Find pivot
         * Pivot = index of the largest element
         * Example: [3,4,5,6,7,0,1,2] -> pivot is 4 (value 7)
         */
        int pivot = findPivotinRotatedArray(arr);

        /*
         * Step 2: Search in left part (0 to pivot)
         * Left part is sorted in ascending order
         */
        int ans = BinarySearchFind(arr, target, 0, pivot);

        /*
         * Step 3: If not found in left part,
         * search in right part (pivot+1 to end)
         */
        if (ans != -1) {
            System.out.println(ans);
        } else {
            ans = BinarySearchFind(arr, target, pivot + 1, arr.length - 1);
            System.out.println(ans);
        }
    }

    /*
     * This method finds the pivot index in a rotated sorted array.
     *
     * Pivot definition:
     * - Pivot is the index where rotation happens
     * - Pivot is the largest element
     *
     * Example:
     * [4,5,6,7,0,1,2]
     * pivot index = 3 (value 7)
     */
    public static int findPivotinRotatedArray(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            /*
             * Case 1:
             * If mid element is greater than next element,
             * then mid is the pivot (largest element)
             */
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            /*
             * Case 2:
             * If mid element is smaller than previous element,
             * then previous element (mid-1) is the pivot
             */
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            /*
             * Case 3:
             * Decide which side to go
             *
             * If arr[start] >= arr[mid], it means left side is not strictly increasing,
             * so pivot lies on LEFT side (move end to mid-1)
             *
             * Else pivot lies on RIGHT side (move start to mid+1)
             */
            if (arr[start] >= arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        /*
         * If we never found a pivot,
         * that means array is not rotated and last element is the largest
         */
        return arr.length - 1;
    }

    /*
     * Standard Binary Search on ascending sorted array.
     * Used after we split the array into two sorted parts using pivot.
     */
    public static int BinarySearchFind(int[] arr, int target, int start, int end) {

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid; // target found
            }
            else if (target < arr[mid]) {
                end = mid - 1; // go left
            }
            else {
                start = mid + 1; // go right
            }
        }

        return -1; // target not found
    }
}
