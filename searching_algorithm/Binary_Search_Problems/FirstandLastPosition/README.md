### 🔹 Example
**Input:**
arr = [5, 7, 7, 8, 8, 10]
target = 8

makefile
Copy code

**Output:**
[3, 4]


**Input:**
arr = [5, 7, 7, 8, 8, 10]
target = 6

makefile
Copy code

**Output:**
[-1, -1]



---

## 🧠 Key Insight
- Binary Search works only on **sorted arrays**
- The same Binary Search logic is reused twice:
  - One for **first occurrence**
  - One for **last occurrence**
- On finding the target:
  - Move **left** for first position
  - Move **right** for last position

---

## ⚙️ Algorithm
1. Perform Binary Search to find the **first occurrence**
2. If first occurrence is `-1`, return `[-1, -1]`
3. Perform Binary Search again to find the **last occurrence**
4. Return both indices

---

## ⏱ Time & Space Complexity
- **Time:** O(log n)
- **Space:** O(1)

---

## 🔗 LeetCode
- Find First and Last Position of Element in Sorted Array — LeetCode #34

---

## 📝 Notes
- This problem is a classic **Lower Bound & Upper Bound** application
- Understanding how to move pointers after a match is crucial
- This pattern is widely used in many Binary Search problems
