
---

## 🧠 Key Insight
- A rotated array is split into **two sorted parts**
- Binary Search works only on **sorted ranges**
- We first find the **pivot (largest element)**
- Then we apply Binary Search on the appropriate half
- **Duplicates make pivot detection harder**, so extra checks are needed

---

## ⚙️ Short Recap (How we solve it)
1. **Find the pivot**
   - Pivot = index of the **largest element**
   - Rotation happens right after pivot
2. **If no pivot is found**
   - Array is not rotated
   - Apply Binary Search on the whole array
3. **Search in left part**
   - Range: `0 → pivot`
4. **If not found, search in right part**
   - Range: `pivot+1 → n-1`
5. Return index if found, else `-1`

---

## ⚙️ Algorithm
1. Use modified Binary Search to find pivot:
   - If `arr[mid] > arr[mid+1]` → `mid` is pivot
   - If `arr[mid] < arr[mid-1]` → `mid-1` is pivot
2. If `arr[start] == arr[mid] == arr[end]`:
   - Cannot decide direction due to duplicates
   - Shrink boundaries (`start++`, `end--`)
3. Once pivot is found:
   - Apply Binary Search on left sorted part
   - If not found, apply Binary Search on right sorted part
4. Return index or `-1`

---

## ⏱ Time & Space Complexity
- **Average Time:** O(log n)
- **Worst Case (many duplicates):** O(n)
- **Space:** O(1)

---

## 🔗 LeetCode
- Search in Rotated Sorted Array II — LeetCode #81

---

## 📝 Notes
- Output is always the **index**, not the value
- Duplicate elements break normal pivot logic
- Shrinking boundaries helps handle duplicates safely
- This problem is an extension of:
  - Rotated Sorted Array without duplicates (LeetCode #33)
