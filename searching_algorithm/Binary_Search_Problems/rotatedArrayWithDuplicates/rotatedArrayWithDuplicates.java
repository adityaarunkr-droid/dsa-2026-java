package searching_algorithm.Binary_Search_Problems.rotatedArrayWithDuplicates;

public class rotatedArrayWithDuplicates {
    
    public static void main(String[] args) {

        int[] arr = {4, 5, 2, 2, 2};
        int target = 2;

        /*
         * Step 1: Find pivot
         * Pivot = index of the largest element
         * Rotation happens after pivot
         */
        int pivot = findPivot(arr);

        /*
         * Step 2:
         * If pivot is -1 → array is NOT rotated
         * So we directly apply binary search on full array
         */
        if (pivot == -1) {
            System.out.println(BinarySearch(arr, target, 0, arr.length - 1));
            return;
        }

        /*
         * Step 3:
         * Search in left part (0 to pivot)
         * Left part is sorted
         */
        int ans = BinarySearch(arr, target, 0, pivot);

        /*
         * Step 4:
         * If not found in left part,
         * search in right part (pivot+1 to end)
         */
        if (ans != -1) {
            System.out.println(ans);
        } else {
            System.out.println(BinarySearch(arr, target, pivot + 1, arr.length - 1));
        }
    }

    /*
     * This method finds the pivot index in a rotated sorted array
     * that MAY CONTAIN DUPLICATES.
     *
     * Pivot definition:
     * - Pivot is the index of the largest element
     * - Rotation happens right after pivot
     */
    public static int findPivot(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            /*
             * Case 1:
             * If mid element is greater than next element,
             * then mid itself is the pivot
             *
             * Example: [4,5,6,1,2]
             * mid = 2 (value 6)
             */
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            /*
             * Case 2:
             * If mid element is smaller than previous element,
             * then mid-1 is the pivot
             *
             * Example: [4,5,1,2,3]
             * mid = 2 (value 1)
             * pivot = 1 (value 5)
             */
            if (mid > start && arr[mid - 1] > arr[mid]) {
                return mid - 1;
            }

            /*
             * Case 3: DUPLICATES
             * When start, mid and end are equal,
             * we cannot decide which side is sorted
             *
             * Example: [2,2,2,3,1,2]
             */
            if (arr[start] == arr[mid] && arr[mid] == arr[end]) {

                // Check if start itself is pivot
                if (start < end && arr[start] > arr[start + 1]) {
                    return start;
                }
                start++; // skip duplicate

                // Check if end-1 is pivot
                if (start < end && arr[end - 1] > arr[end]) {
                    return end - 1;
                }
                end--; // skip duplicate
            }

            /*
             * Left side is sorted OR left side has equal values
             * but mid is greater than end
             *
             * So pivot must lie on RIGHT side
             */
            else if (arr[start] < arr[mid]
                    || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            }

            /*
             * Otherwise, pivot lies on LEFT side
             */
            else {
                end = mid - 1;
            }
        }

        /*
         * If no pivot is found,
         * array is NOT rotated
         */
        return -1;
    }

    /*
     * Standard Binary Search on sorted array
     */
    public static int BinarySearch(int[] arr, int target, int start, int end) {

        while (start <= end) {

            int mid = start + (end - start) / 2;

            // Target found
            if (arr[mid] == target) {
                return mid;
            }
            // Target is greater → move right
            else if (arr[mid] < target) {
                start = mid + 1;
            }
            // Target is smaller → move left
            else {
                end = mid - 1;
            }
        }
        return -1; // target not found
    }
}
