
# Sliding Window Technique

## Table of Contents

1. [Introduction to Sliding Window](#introduction-to-sliding-window)
2. [Core Logic](#core-logic)
3. [When Should We Use Sliding Window?](#when-should-we-use-sliding-window)
4. [Why Is Sliding Window Efficient?](#why-is-sliding-window-efficient)
5. [Types of Sliding Window](#types-of-sliding-window)
   - [Dynamic Window Size](#dynamic-window-size)
     - [Pseudocode](#pseudocode-for-dynamic-window-size)
     - [Example](#example-for-dynamic-window-size)
     - [Code Snippet](#code-snippet-for-dynamic-window-size)
     - [Complexities](#complexities-for-dynamic-window-size)
     - [Common Use Cases](#common-use-cases-for-dynamic-window-size)
   - [Fixed Window Size](#fixed-window-size)
     - [Pseudocode](#pseudocode-for-fixed-window-size)
     - [Example](#example-for-fixed-window-size)
     - [Code Snippet](#code-snippet-for-fixed-window-size)
     - [Complexities](#complexities-for-fixed-window-size)
     - [Common Use Cases](#common-use-cases-for-fixed-window-size)
6. [Practice Problems](#practice-problems)
7. [Tips for Java Developers](#tips-for-java-developers)

---

## Introduction to Sliding Window

The sliding window technique is a powerful approach for solving problems that involve subarrays or substrings of a given array or string. By maintaining two pointers, it optimizes the traversal of the iterable and avoids unnecessary computations by dynamically adjusting the bounds of the window.

---

## Core Logic

1. **Define the Window:**

   - The window is defined by two pointers, `left` and `right`.

2. **Expand the Window:**

   - Move the `right` pointer to include new elements into the window.

3. **Shrink the Window:**

   - Move the `left` pointer to exclude elements when constraints are violated.

4. **Update Results:**

   - Perform operations such as updating maximum/minimum values or counting subarrays based on the current valid window.

The goal is to ensure the window slides efficiently without redundant recalculations, making this technique suitable for problems requiring linear time complexity.

---

## When Should We Use Sliding Window?

Sliding window is ideal for problems involving contiguous subarrays or substrings where constraints need to be checked dynamically. Typical use cases include:

1. **Finding optimal subarrays or substrings:** Problems like finding the longest, shortest, or maximum sum subarray.
2. **Counting subarrays or substrings:** For example, counting valid subarrays that meet specific conditions.
3. **Dynamic constraints:** Problems that require adding or removing elements dynamically to maintain validity (e.g., character frequency constraints in substrings).

If a problem requires efficient exploration of subarrays or substrings under dynamic constraints, sliding window is a strong candidate.

---

## Why Is Sliding Window Efficient?

Sliding window minimizes redundant calculations by dynamically adjusting the boundaries of the window rather than recalculating for every subarray or substring. Key efficiency aspects:

1. **Linear Complexity:** Both pointers traverse the array at most once, resulting in O(n) complexity.
2. **Amortized Analysis:** Even though a `while` loop inside a `for` loop might seem O(n²), the total number of pointer movements is linear across all iterations.
3. **Minimal Space Usage:** Requires only a few variables (e.g., `left`, `right`, `current_sum`) for calculations, leading to O(1) space complexity.

This efficiency makes it ideal for large datasets where naive approaches would be computationally expensive.

---

## Types of Sliding Window

### Dynamic Window Size

Dynamic window size refers to situations where the size of the window changes dynamically based on the constraints of the problem. The window is expanded by moving the `right` pointer to include new elements, and when the constraints are violated, the `left` pointer is moved to shrink the window. This approach is often used when the task requires maximizing or minimizing properties such as sums, products, or counts within a subarray or substring.

#### Pseudocode for Dynamic Window Size

```
function slidingWindowDynamic(arr, k):
    left = 0
    curr = 0
    answer = 0
    for right in range(len(arr)):
        curr += arr[right]

        while curr > k:
            curr -= arr[left]
            left++

        answer = max(answer, right - left + 1)

    return answer
```

#### Example for Dynamic Window Size

**Task:** Find the longest subarray with a sum less than or equal to `k`.

#### Code Snippet for Dynamic Window Size

```java
public class SlidingWindowExample {
    public static int longestSubarray(int[] nums, int k) {
        int left = 0, curr = 0, maxLength = 0;
        for (int right = 0; right < nums.length; right++) {
            curr += nums[right];

            while (curr > k) {
                curr -= nums[left];
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
```

#### Complexities for Dynamic Window Size

| **Operation**  | **Time Complexity** | **Space Complexity** |
| -------------- | ------------------- | -------------------- |
| Sliding Window | O(n)                | O(1)                 |

#### Common Use Cases for Dynamic Window Size

1. Longest subarray with a sum/product constraint.
2. Longest substring with specific character constraints.
3. Counting valid subarrays.

---

### Fixed Window Size

Fixed window size refers to scenarios where the window size remains constant throughout the traversal. The size is determined beforehand (e.g., `k`), and the window slides by adding a new element from the right and removing an element from the left to maintain the fixed size. This approach is suitable for problems that require operations such as calculating maximum sums or averages for subarrays of a specific size.

#### Pseudocode for Fixed Window Size

```
function slidingWindowFixed(arr, k):
    curr = sum(arr[0:k])
    answer = curr

    for i in range(k, len(arr)):
        curr += arr[i] - arr[i - k]
        answer = max(answer, curr)

    return answer
```

#### Example for Fixed Window Size

**Task:** Find the maximum sum of a subarray of size `k`.

#### Code Snippet for Fixed Window Size

```java
public class FixedSlidingWindow {
    public static int maxSumSubarray(int[] nums, int k) {
        int currSum = 0, maxSum = 0;

        for (int i = 0; i < k; i++) {
            currSum += nums[i];
        }
        maxSum = currSum;

        for (int i = k; i < nums.length; i++) {
            currSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
```

#### Complexities for Fixed Window Size

| **Operation**  | **Time Complexity** | **Space Complexity** |
| -------------- | ------------------- | -------------------- |
| Sliding Window | O(n)                | O(1)                 |

#### Common Use Cases for Fixed Window Size

1. Maximum/minimum sum of fixed-length subarrays.
2. Counting occurrences of fixed-length substrings.

---

## Practice Problems

Here are some curated problems for practice:

### Easy

1. [Maximum Average Subarray I](https://leetcode.com/problems/maximum-average-subarray-i/)
2. [Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)
3. [Find Pivot Index](https://leetcode.com/problems/find-pivot-index/)

### Medium

4. [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
5. [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)
6. [Fruit Into Baskets](https://leetcode.com/problems/fruit-into-baskets/)

### Hard

7. [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)
8. [Count Number of Nice Subarrays](https://leetcode.com/problems/count-number-of-nice-subarrays/)

---

## Tips for Java Developers

- Use `HashMap` for counting elements within a window efficiently.
- Leverage Java Streams for concise implementation in some cases.
- Optimize space usage by avoiding unnecessary intermediate structures.

---
