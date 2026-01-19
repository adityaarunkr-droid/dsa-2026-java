# Floor and Ceiling (Binary Search)

## 📌 Problem
Given a **sorted array** and a target value:

- **Ceiling** → the smallest element **greater than or equal to** the target  
- **Floor** → the largest element **less than or equal to** the target  

If ceiling or floor does not exist, return `-1`.

---

## 🧠 Key Insight
- Binary Search works only on **sorted arrays**
- After Binary Search ends:
  - `start` points to **Ceiling**
  - `end` points to **Floor**
- Both values can be found using the **same search logic**

---

## ⚙️ Algorithm
1. Sort the array (if not already sorted)
2. Initialize `start = 0`, `end = n - 1`
3. While `start <= end`
   - Calculate `mid`
   - If `arr[mid] < target` → move right (`start = mid + 1`)
   - If `arr[mid] > target` → move left (`end = mid - 1`)
   - If exact match → both floor & ceiling are the element itself
4. After loop:
   - `start` → Ceiling index
   - `end` → Floor index
5. Handle edge cases where indices go out of bounds

---

## ⏱ Time & Space Complexity
- **Time:** O(log n)
- **Space:** O(1)

---

## 🔗 LeetCode
- Search Insert Position — LeetCode #35 (concept-based)
- Floor & Ceiling is a common **Binary Search interview pattern**

---

## 📝 Notes
- This problem builds the foundation for **Upper Bound & Lower Bound**
- Used in many problems like:
  - Next Greater Element
  - First & Last Position
  - Binary Search on Answer
- Understanding `start` and `end` after the loop is **crucial**
