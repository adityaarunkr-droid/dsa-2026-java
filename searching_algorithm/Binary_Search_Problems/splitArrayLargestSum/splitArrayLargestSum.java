package searching_algorithm.Binary_Search_Problems.splitArrayLargestSum;

public class splitArrayLargestSum {
    
    public static void main(String[] args) {

        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;

        System.out.println(splitArray(nums, k)); // Output: 18
    }

    /**
     * We want to split the array into k subarrays
     * such that the maximum subarray sum is minimized.
     */
    public static int splitArray(int[] nums, int k) {

        int low = 0;   // minimum possible max sum
        int high = 0;  // maximum possible max sum

        // Step 1: Decide search space
        for (int num : nums) {
            low = Math.max(low, num); // at least the max element
            high += num;              // at most sum of all elements
        }

        // Step 2: Binary search on the answer
        while (low < high) {

            int mid = low + (high - low) / 2;
            int pieces = countSubarrays(nums, mid);

            /*
             * If pieces > k:
             * We are forced to create more than k subarrays
             * → mid is TOO SMALL
             * → increase allowed max sum
             */
            if (pieces > k) {
                low = mid + 1;
            }
            /*
             * If pieces <= k:
             * We can split within k subarrays
             * → mid is a VALID answer
             * → try smaller max sum
             */
            else {
                high = mid;
            }
        }

        // low == high is the minimum possible maximum subarray sum
        return low;
    }

    /**
     * Helper method:
     * Counts how many subarrays are needed
     * if no subarray sum exceeds maxAllowedSum
     */
    private static int countSubarrays(int[] nums, int maxAllowedSum) {

        int pieces = 1; // at least one subarray
        int currentSum = 0;

        for (int num : nums) {

            // If adding this number exceeds allowed sum
            // → start a new subarray
            if (currentSum + num > maxAllowedSum) {
                pieces++;
                currentSum = num;
            } else {
                currentSum += num;
            }
        }

        return pieces;
    }
}
