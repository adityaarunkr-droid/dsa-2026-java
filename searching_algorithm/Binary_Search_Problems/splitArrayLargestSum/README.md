🔹 Input
nums = [7, 2, 5, 10, 8]
k = 2

🔹 Output
18

🧠 Explanation

The array is split into 2 continuous subarrays

One optimal split is:

[7, 2, 5] → sum = 14
[10, 8]   → sum = 18


The maximum subarray sum here is 18

No other split can produce a smaller maximum sum

Hence, the answer is 18

🔁 Short Recap

We minimize the largest subarray sum by binary searching the answer range and checking if the array can be split into k subarrays.



-------------------------------------------------------------------------------------------------------------------------------------------------------

## 🧠 Key Insight
- We are **not searching for an index**
- We are searching for the **best possible answer**
- The answer lies between:
  - `max(nums)` → minimum possible value
  - `sum(nums)` → maximum possible value
- This follows the **Binary Search on Answer** pattern

---

## ⚙️ Short Recap (How we solve it)
1. **Decide the search range**
   - `low = max(nums)`
   - `high = sum(nums)`
2. **Binary search on the answer**
   - Try `mid` as the maximum allowed subarray sum
3. **Count required subarrays**
   - If more than `k` subarrays are needed → `mid` is too small
4. **Adjust search space**
   - `pieces > k` → move right (`low = mid + 1`)
   - `pieces <= k` → move left (`high = mid`)
5. **Final answer**
   - When `low == high`, that value is the answer

---

## ⚙️ Algorithm
1. Initialize:
   - `low = max(nums)`
   - `high = sum(nums)`
2. While `low < high`:
   - `mid = low + (high - low) / 2`
   - Compute `pieces = countSubarrays(nums, mid)`
3. If `pieces > k`:
   - Increase `low`
4. Else:
   - Decrease `high`
5. Return `low`

---

## ⏱ Time & Space Complexity
- **Time:** O(n log(sum − max))
- **Space:** O(1)

---

## 🔗 LeetCode
- Split Array Largest Sum — LeetCode #410

---

## 📝 Notes
- Subarrays must be **continuous**
- Binary Search is applied on **possible sums**, not indices
- Greedy splitting helps decide feasibility
- This pattern is reused in:
  - Book Allocation
  - Painter Partition
  - Shipping Packages

---

## 🔁 One-Line Recap
> Binary search the answer range to minimize the maximum subarray sum.
