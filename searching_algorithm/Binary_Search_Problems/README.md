# Standard Binary Search

## 📌 Problem
Search for a target element in a **sorted array** and return its index.
If the element is not present, return `-1`.

---

## 🧠 Key Insight
- Binary Search works only on **sorted data**
- At every step, we **reduce the search space by half**

---

## ⚙️ Algorithm
1. Initialize `start = 0`, `end = n - 1`
2. While `start <= end`
   - Calculate `mid`
   - If `arr[mid] == target` → return `mid`
   - If `arr[mid] < target` → search right half
   - Else → search left half
3. If not found → return `-1`

---

## ⏱ Time & Space Complexity
- **Time:** O(log n)
- **Space:** O(1)

---

## 🔗 LeetCode
- Binary Search — LeetCode #704

---

## 📝 Notes
- Always use `mid = start + (end - start) / 2` to avoid overflow
- This pattern is the base for **all Binary Search variations**