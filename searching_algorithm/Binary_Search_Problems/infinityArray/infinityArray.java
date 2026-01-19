package searching_algorithm.Binary_Search_Problems.infinityArray;

public class infinityArray {

    public static void main(String[] args) {

        // Sorted array (we assume it is infinite in size conceptually)
        int arr[] = {3, 5, 7, 9, 10, 100, 130, 140, 160, 170};

        // Target element to search
        int target = 160;

        // Print index of target
        System.out.println(infinityArrayLogic(arr, target));
    }

    /*
     * This method searches an element in an infinite sorted array.
     *
     * Since we don't know the array size:
     * 1. First we find a range where the target can exist
     * 2. Then we apply Binary Search in that range
     */
    public static int infinityArrayLogic(int[] arr, int target) {

        // Initial search range
        int start = 0;
        int end = 1;

        /*
         * Expand the search range until:
         * target <= arr[end]
         *
         * Means: target must lie between start and end
         */
        while (target > arr[end]) {

            // New start is just after current end
            int newStart = end + 1;

            /*
             * Increase the window size exponentially
             *
             * Current window size = (end - start + 1)
             * New end = end + 2 * window size
             */
            end = end + (end - start + 1) * 2;

            // Move start to newStart
            start = newStart;

            // If start crosses array length, target cannot exist
            if (start >= arr.length) {
                return -1;
            }

            // If end crosses array length, adjust it to last index
            if (end >= arr.length) {
                end = arr.length - 1;
            }
        }

        // Apply normal binary search in the found range
        return binarySearch(arr, target, start, end);
    }

    /*
     * Standard Binary Search between given start and end
     */
    public static int binarySearch(int[] arr, int target, int start, int end) {

        while (start <= end) {

            // Calculate middle index
            int mid = start + (end - start) / 2;

            // If target is greater, search right half
            if (target > arr[mid]) {
                start = mid + 1;
            }
            // If target is smaller, search left half
            else if (target < arr[mid]) {
                end = mid - 1;
            }
            // Target found
            else {
                return mid;
            }
        }

        // Target not found
        return -1;
    }
}
