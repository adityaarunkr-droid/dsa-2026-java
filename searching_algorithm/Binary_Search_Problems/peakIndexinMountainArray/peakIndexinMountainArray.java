package searching_algorithm.Binary_Search_Problems.peakIndexinMountainArray;

public class peakIndexinMountainArray {
        public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 3, 1};
        int target = 3;

        int ans = findInMountainArray(arr, target);
        System.out.println("Answer index: " + ans); // expected: 2
    }

    /*
     * Main logic from your notes:
     * 1) Find Peak index
     * 2) Search in left (ascending part)
     * 3) If not found, search in right (descending part)
     */
    public static int findInMountainArray(int[] arr, int target) {

        int peak = findPeakIndex(arr);

        // 1) Search in ascending part (0 to peak)
        int leftSearch = binarySearch(arr, target, 0, peak, true);
        if (leftSearch != -1) {
            return leftSearch; // return minimum index (left side)
        }

        // 2) Search in descending part (peak+1 to end)
        return binarySearch(arr, target, peak + 1, arr.length - 1, false);
    }

    /*
     * Finds peak index in a mountain array
     *
     * Mountain Array property:
     * - increasing part till peak
     * - decreasing part after peak
     *
     * Logic:
     * If arr[mid] > arr[mid+1] → we are in decreasing side → peak is at mid or left
     * Else → we are in increasing side → peak is on right
     */
    private static int findPeakIndex(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        // We use start < end because we compare mid with mid+1
        while (start < end) {

            int mid = start + (end - start) / 2;

            // Decreasing part: peak is mid or on left side
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            }
            // Increasing part: peak is on right side
            else {
                start = mid + 1;
            }
        }

        // start == end -> this is the peak index
        return start;
    }

    /*
     * Binary Search with direction flag
     *
     * isAsc = true  → ascending order binary search
     * isAsc = false → descending order binary search
     */
    private static int binarySearch(int[] arr, int target, int start, int end, boolean isAsc) {

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            // If array part is ascending
            if (isAsc) {
                if (target > arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            // If array part is descending
            else {
                if (target > arr[mid]) {
                    end = mid - 1;     // bigger values are on LEFT
                } else {
                    start = mid + 1;   // smaller values are on RIGHT
                }
            }
        }

        return -1; // not found
    }

}
