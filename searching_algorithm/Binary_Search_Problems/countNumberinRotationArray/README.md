## 🧠 Key Insight
- A rotated sorted array is split into **two sorted parts**
- The **smallest element** tells how many times the array was rotated
- The smallest element is found **right after the pivot**
- So: rotation count = pivot index + 1
- Duplicate elements make pivot detection harder, so special handling is required

---

## ⚙️ Short Recap (How we solve it)
1. **Find the pivot**
 - Pivot = index of the **largest element**
 - Rotation happens immediately after pivot
2. **If no pivot is found**
 - Array is not rotated
 - Rotation count = `0`
3. **If duplicates hide sorted order**
 - Shrink search window (`start++`, `end--`)
4. **Return rotation count**
 - `pivot + 1`

---

## ⚙️ Algorithm
1. Use modified Binary Search to find pivot:
 - If `arr[mid] > arr[mid + 1]` → `mid` is pivot
 - If `arr[mid] < arr[mid - 1]` → `mid - 1` is pivot
2. If `arr[start] == arr[mid] == arr[end]`:
 - Cannot decide direction due to duplicates
 - Shrink boundaries (`start++`, `end--`)
3. If left side is sorted → search right
4. Else → search left
5. If pivot not found → return `0`
6. Else → return `pivot + 1`

---

## ⏱ Time & Space Complexity
- **Average Time:** O(log n)
- **Worst Case (many duplicates):** O(n)
- **Space:** O(1)

---

## 🔗 LeetCode
- Find Minimum in Rotated Sorted Array — LeetCode #153
- Find Minimum in Rotated Sorted Array II — LeetCode #154

---

## 📝 Notes
- Rotation count is always the **index of the smallest element**
- Duplicate elements can break normal binary search assumptions
- Shrinking boundaries is the key to handling duplicates safely
- This logic works for **both duplicate and non-duplicate arrays**
