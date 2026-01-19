
---

## 🧠 Key Insight
- In a rotated array, the array is split into **two sorted parts**:
  - Left part (ascending)
  - Right part (ascending)
- If we find the **pivot** (largest element index), we can decide where to search.
- Binary Search works only on **sorted** ranges, so we search in one of the two parts.

---

## ⚙️ Short Recap (How we solve it)
1. **Find Pivot**
   - Pivot = index of the **largest element**
   - Rotation happens right after pivot  
     Example: `[3,4,5,6,7,0,1,2]` → pivot is `7` at index `4`
2. **Binary Search in Left Part**
   - Search in `0 ... pivot`
3. **If not found, Binary Search in Right Part**
   - Search in `pivot+1 ... n-1`
4. Return index if found, else `-1`

---

## ⚙️ Algorithm
1. Find pivot using binary search:
   - If `arr[mid] > arr[mid+1]` → `mid` is pivot
   - If `arr[mid] < arr[mid-1]` → `mid-1` is pivot
2. Apply Binary Search in range `[0 ... pivot]`
3. If not found, apply Binary Search in range `[pivot+1 ... n-1]`
4. Return answer or `-1`

---

## ⏱ Time & Space Complexity
- **Time:** O(log n)
- **Space:** O(1)

---

## 🔗 LeetCode
- Search in Rotated Sorted Array — LeetCode #33

---

## 📝 Notes
- Output is always the **index**, not the value  
  Example: `target = 0` is at index `5`, so answer is `5`
- This approach works for **no duplicates**
- For duplicates, pivot logic needs extra handling
