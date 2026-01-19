package searching_algorithm.Binary_Search_Problems.countNumberinRotationArray;

public class countNumberinRotationArray {
    public class rotationCountinArray {
    public static void main(String[] args) {

        int[] arr1 = {4, 5, 6, 7, 0, 1, 2};
        int[] arr2 = {2, 2, 2, 0, 1, 2};

        System.out.println("Rotation count (no duplicates): " + countRotated(arr1));
        System.out.println("Rotation count (with duplicates): " + countRotated(arr2));
    }

    /*
     * Rotation count = index of smallest element
     * = pivot index + 1
     */
    public static int countRotated(int[] arr) {

        int pivot = findPivotWithDuplicates(arr);

        // If pivot is -1, array is not rotated
        if (pivot == -1) {
            return 0;
        }

        return pivot + 1;
    }

    /*
     * Finds pivot index (largest element) in rotated sorted array
     * This version HANDLES DUPLICATES
     */
    public static int findPivotWithDuplicates(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            /*
             * Case 1:
             * mid element is greater than next element
             * → mid is pivot
             */
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            /*
             * Case 2:
             * mid element is smaller than previous element
             * → mid-1 is pivot
             */
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            /*
             * Case 3: DUPLICATES
             * arr[start] == arr[mid] == arr[end]
             * → cannot decide direction
             * → shrink the boundaries
             */
            if (arr[start] == arr[mid] && arr[mid] == arr[end]) {

                // Check if start itself is pivot
                if (start < end && arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // Check if end-1 is pivot
                if (start < end && arr[end - 1] > arr[end]) {
                    return end - 1;
                }
                end--;
            }

            /*
             * Left side is sorted OR left has duplicates but mid > end
             * → pivot must lie on RIGHT side
             */
            else if (arr[start] < arr[mid]
                    || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            }

            /*
             * Otherwise pivot lies on LEFT side
             */
            else {
                end = mid - 1;
            }
        }

        // No pivot found → array not rotated
        return -1;
    }
}

}
