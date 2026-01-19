package searching_algorithm.Binary_Search_Problems;

public class BinarySearchStart {
    
    // Binary search method - searches for target in a sorted array
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid; // Target found at index mid
            } else if (arr[mid] < target) {
                left = mid + 1; // Search in right half
            } else {
                right = mid - 1; // Search in left half
            }
        }
        
        return -1; // Target not found
    }
    
    // Main method for testing
    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 7;
        
        int result = binarySearch(sortedArray, target);
        if (result != -1) {
            System.out.println("Element " + target + " found at index: " + result);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }
    }
}


/**
 Use of Dynamic Array
 */

// public class BinarySearchStart {
    
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Welecome to Binary Search Algorithm");
//         //Define Dynamic Array
//         ArrayList<Integer> dynamicContainer = new ArrayList<>();
//         System.out.println("Enter elements one by one until you type {Stop} on your Keyboard");
//         while(true)
//         {
//             String input = sc.next();
//             if(input.equalsIgnoreCase("Stop"))
//             {
//                 break;
//             }
//             dynamicContainer.add(Integer.parseInt(input));
//         }
//         Collections.sort(dynamicContainer);
//         System.out.println("Your Inputs are");
//         for(int arr:dynamicContainer)
//         {
//             System.out.print(arr+" ");
//         }
//         System.out.println();
//         System.out.println("Enter the number you want to search for");
//         int searchInput=sc.nextInt();
//         int result=BinarySearch(dynamicContainer,searchInput);
//         if(result!=-1)
//         {
//             System.out.println("Your searched number was found at index: " + result);
//         }
//         else
//         {
//             System.out.println("Your searched number was not found in the given array");
//         }
//     }
//     public static int BinarySearch(ArrayList<Integer> dynamicArg,int searchInput)
//     {
//         int startIndex=0;
//         int endIndex=dynamicArg.size()-1;
//         while(startIndex<=endIndex)
//         {
//             int mid = startIndex+(endIndex-startIndex)/2;
//             if(searchInput>dynamicArg.get(mid))
//             {
//                 //Go RightSide
//                 startIndex=mid+1;
//             }
//             else if(searchInput<dynamicArg.get(mid))
//             {
//                 //Go LeftSide
//                 endIndex=mid-1;
//             }
//             else
//             {
//                 //Target Found
//                 return mid;
//             }
//         }
//         return -1;
//     }

// }