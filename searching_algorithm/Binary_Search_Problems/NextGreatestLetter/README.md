# Next Greatest Letter (Binary Search)

## 📌 Problem
Given a sorted array of characters `letters` and a character `target`,  
find the **smallest character strictly greater than `target`**.

If no such character exists, return the **first character of the array** (wrap-around case).

---

## 🧠 Key Insight
This problem is a classic **Binary Search – Upper Bound** pattern.

- We are NOT searching for an exact match
- We are searching for the **first character greater than target**
- The array is **sorted**, which makes binary search applicable

---

## ⚙️ Algorithm
1. Initialize two pointers:
   - `start = 0`
   - `end = letters.length - 1`
2. While `start <= end`:
   - Calculate `mid`
   - If `target >= letters[mid]` → move right (`start = mid + 1`)
   - Else → move left (`end = mid - 1`)
3. After the loop, `start` points to the smallest valid answer
4. Use **modulo** to handle wrap-around case

---

## 🧩 Code Logic (Important Line)
```java
return letters[start % letters.length];

---

## ⏱ Time & Space Complexity
- **Time:** O(log n)
- **Space:** O(1)

---

## 🔗 LeetCode
- Find Smallest Letter Greater Than Target — LeetCode #744

---

## 📝 Notes
- This problem is a classic **Upper Bound** application