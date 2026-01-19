## 🧠 Key Insight
- We **do not know the size** of the array
- Binary Search needs **start and end boundaries**
- So first, we **expand the search window exponentially**
- Once the target lies inside the window, we apply **Binary Search**

---

## ⚙️ Algorithm
1. Initialize pointers:
   - `start = 0`
   - `end = 1`
2. While `target > arr[end]`
   - Save new start as `end + 1`
   - Increase window size exponentially  
     `end = end + (end - start + 1) * 2`
   - Update `start = newStart`
3. After loop:
   - Target lies between `start` and `end`
4. Apply Binary Search between `start` and `end`
5. If target is found, return index
6. Else, return `-1`

---

## ⏱ Time & Space Complexity
- **Time:** O(log n)
- **Space:** O(1)

---

## 🔗 LeetCode
- Search in a Sorted Array of Unknown Size — LeetCode #702 (concept-based)

---

## 📝 Notes
- `start` always points to the **beginning of the current window**
- `end` always points to the **end of the current window**
- Window size doubles every time, keeping the algorithm fast
- This pattern is commonly asked in **FAANG interviews**
