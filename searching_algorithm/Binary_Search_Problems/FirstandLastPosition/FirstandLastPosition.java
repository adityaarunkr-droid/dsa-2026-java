package searching_algorithm.Binary_Search_Problems.FirstandLastPosition;
import java.util.*;

public class FirstandLastPosition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input size
        System.out.println("Enter size:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        // Input elements (must be sorted)
        System.out.println("Enter elements (sorted):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Input target
        System.out.println("Enter target:");
        int target = sc.nextInt();
        int[] result = searchRange(arr, target);
        System.out.println("Result: [" + result[0] + ", " + result[1] + "]");
    }

    /*
     * Returns [firstIndex, lastIndex]
     * If target is not found → returns [-1, -1]
     */
    public static int[] searchRange(int[] arr, int target) {

        int first = bound(arr, target, true);

        // If first occurrence not found, target doesn't exist
        if (first == -1) {
            return new int[]{-1, -1};
        }

        int last = bound(arr, target, false);

        return new int[]{first, last};
    }

    /*
     * Modified Binary Search
     *
     * isFirst = true  → FIRST occurrence
     * isFirst = false → LAST occurrence
     */
    private static int bound(int[] arr, int target, boolean isFirst) {

        int start = 0;
        int end = arr.length - 1;
        int ans = -1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                ans = mid;

                if (isFirst) {
                    end = mid - 1;   // move left
                } else {
                    start = mid + 1; // move right
                }
            }
            else if (target > arr[mid]) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return ans;
    }
}




