✅ Step-1: Find peak index
✅ Step-2: Binary search in ascending part (0 → peak)
✅ Step-3: If not found, binary search in descending part (peak+1 → end)
✅ Return minimum index (because we search left first)


---

## 🧠 Key Insight
- Mountain array has **two sorted parts**:
  - Left part is **ascending**
  - Right part is **descending**
- So we do Binary Search in 3 steps:
  1. Find the **peak index**
  2. Binary Search in **ascending** part
  3. If not found, Binary Search in **descending** part
- We search left side first because we need the **minimum index**

---

## ⚙️ Algorithm
1. Find the **peak index** using binary search:
   - If `arr[mid] > arr[mid+1]` → move left (`end = mid`)
   - Else → move right (`start = mid + 1`)
2. Search target in left part `[0 ... peak]` (ascending binary search)
3. If not found, search target in right part `[peak+1 ... n-1]` (descending binary search)
4. Return index if found, else return `-1`

---

## ⏱ Time & Space Complexity
- **Time:** O(log n) + O(log n) + O(log n) = **O(log n)**
- **Space:** O(1)

---

## 🔗 LeetCode
- Find in Mountain Array — LeetCode #1095

---

## 📝 Notes
- Peak finding uses `start < end` because we compare `mid` with `mid + 1`
- Descending binary search condition is reversed:
  - If `target > arr[mid]` → move LEFT
  - Else → move RIGHT
- Searching left part first ensures we return the **minimum index**
