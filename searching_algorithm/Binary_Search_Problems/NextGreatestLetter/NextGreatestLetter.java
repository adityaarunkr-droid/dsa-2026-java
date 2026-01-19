package searching_algorithm.Binary_Search_Problems.NextGreatestLetter;

public class NextGreatestLetter {

    // Returns the smallest character strictly greater than target
    public static char nextGreatestLetter(char[] letters, char target) {

        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target >= letters[mid]) {
                // Move right if mid is less than or equal to target
                start = mid + 1;
            } else {
                // Potential answer found, move left to find smaller one
                end = mid - 1;
            }
        }

        // Wrap around using modulo (important edge case) , it help to give start value search is not found within array
        return letters[start % letters.length]; 
    }

    // Main method for testing
    public static void main(String[] args) {

        char[] letters = {'c', 'f', 'j'};
        char target = 'c';

        char result = nextGreatestLetter(letters, target);
        System.out.println("Next greatest letter after '" + target + "' is: " + result);
    }
}