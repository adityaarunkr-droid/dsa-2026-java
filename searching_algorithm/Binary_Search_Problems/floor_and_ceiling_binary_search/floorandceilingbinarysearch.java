package searching_algorithm.Binary_Search_Problems.floor_and_ceiling_binary_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class floorandceilingbinarysearch {
  public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();

        // Input numbers until STOP
        System.out.println("Enter numbers (type STOP to finish):");
        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("STOP")) break;

            // Optional: ignore empty lines
            if (input.trim().isEmpty()) continue;

            arr.add(Integer.parseInt(input));
        }

        if (arr.isEmpty()) {
            System.out.println("Array is empty. Please enter at least one number.");
            return;
        }

        // Binary Search works only on sorted data
        Collections.sort(arr);
        System.out.println("Sorted array: " + arr);

        // Target number
        System.out.println("Enter number to find CEILING and FLOOR for:");
        int target = Integer.parseInt(sc.nextLine());

        // First Ceiling then Floor
        int ceil = ceiling(arr, target);
        int flr = floor(arr, target);

        System.out.println("Ceiling is: " + ceil);
        System.out.println("Floor is: " + flr);
    }

    /*
     * CEILING = smallest number >= target
     */
    public static int ceiling(ArrayList<Integer> arr, int target) {

        int startIndex = 0;
        int endIndex = arr.size() - 1;

        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;

            if (target > arr.get(mid)) {
                startIndex = mid + 1;
            } else if (target < arr.get(mid)) {
                endIndex = mid - 1;
            } else {
                return arr.get(mid); // exact match
            }
        }

        // If target is greater than all elements, ceiling doesn't exist
        if (startIndex >= arr.size()) return -1;

        return arr.get(startIndex);
    }

    /*
     * FLOOR = largest number <= target
     */
    public static int floor(ArrayList<Integer> arr, int target) {

        // If target is smaller than the smallest element, floor doesn't exist
        if (target < arr.get(0)) return -1;

        int startIndex = 0;
        int endIndex = arr.size() - 1;

        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;

            if (target > arr.get(mid)) {
                startIndex = mid + 1;
            } else if (target < arr.get(mid)) {
                endIndex = mid - 1;
            } else {
                return arr.get(mid); // exact match
            }
        }

        return arr.get(endIndex);
    }
}