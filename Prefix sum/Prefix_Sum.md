
# Prefix Sum Technique

## Table of Contents

1. [Introduction to Prefix Sum](#introduction-to-prefix-sum)
2. [Core Logic](#core-logic)
3. [Advantages of Prefix Sum](#advantages-of-prefix-sum)
4. [Implementation Details](#implementation-details)
   - [Building a Prefix Sum Array](#building-a-prefix-sum-array)
     - [Pseudocode](#pseudocode-for-building-a-prefix-sum-array)
     - [Example](#example-for-building-a-prefix-sum-array)
     - [Code Snippet](#code-snippet-for-building-a-prefix-sum-array)
   - [Using Prefix Sum for Subarray Queries](#using-prefix-sum-for-subarray-queries)
     - [Pseudocode](#pseudocode-for-subarray-queries)
     - [Example](#example-for-subarray-queries)
5. [Optimization Techniques](#optimization-techniques)
   - [Reducing Space Complexity](#reducing-space-complexity)
6. [Practice Problems](#practice-problems)
7. [Tips for Java Developers](#tips-for-java-developers)

---

## Introduction to Prefix Sum

The prefix sum technique is a powerful tool used to efficiently calculate the sum of elements in a subarray of a given array. It involves preprocessing the array to create a prefix sum array, where each element represents the cumulative sum of the array up to that index. This preprocessing allows subarray sum queries to be answered in constant time.

For example, given an array `nums = [5, 2, 1, 6, 3, 8]`, the corresponding prefix sum array would be `prefix = [5, 7, 8, 14, 17, 25]`. Using the prefix sum array, the sum of any subarray from index `i` to `j` can be calculated as `prefix[j] - prefix[i - 1]`.

---

## Core Logic

1. **Build the Prefix Sum Array:**
   - Start with the first element of the input array as the first element of the prefix sum array.
   - Iteratively compute the cumulative sum by adding the current element to the last element of the prefix sum array.

2. **Query Subarray Sums Efficiently:**
   - For a subarray from index `i` to `j`, compute the sum using the formula `prefix[j] - prefix[i - 1]`.
   - Handle the edge case when `i = 0` by directly using `prefix[j]`.

3. **Preprocessing for Optimization:**
   - The preprocessing step to build the prefix sum array takes O(n) time.
   - Once built, subarray sum queries are answered in O(1) time.

---

## Advantages of Prefix Sum

- **Efficiency:** Precomputing the prefix sum array reduces the time complexity of subarray sum queries from O(n) to O(1).
- **Simplicity:** The concept is straightforward and can be implemented with minimal code.
- **Versatility:** Applicable to various problems involving subarrays, such as range queries, split conditions, and constraints.

---

## Implementation Details

### Building a Prefix Sum Array

#### Pseudocode for Building a Prefix Sum Array

```
function buildPrefixSum(nums):
    prefix = [nums[0]]
    for i = 1 to nums.length - 1:
        prefix.append(nums[i] + prefix[i - 1])
    return prefix
```

#### Example for Building a Prefix Sum Array

**Input:** `nums = [5, 2, 1, 6, 3, 8]`  
**Output:** `prefix = [5, 7, 8, 14, 17, 25]`

#### Code Snippet for Building a Prefix Sum Array

```java
public class PrefixSum {
    public static int[] buildPrefixSum(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
        }
        return prefix;
    }
}
```

---

### Using Prefix Sum for Subarray Queries

#### Pseudocode for Subarray Queries

```
function querySum(prefix, i, j):
    if i == 0:
        return prefix[j]
    return prefix[j] - prefix[i - 1]
```

#### Example for Subarray Queries

**Input:** `prefix = [5, 7, 8, 14, 17, 25]`, `i = 1`, `j = 4`  
**Output:** `prefix[4] - prefix[0] = 17 - 5 = 12`

#### Code Snippet for Subarray Queries

```java
public class SubarraySum {
    public static int querySum(int[] prefix, int i, int j) {
        if (i == 0) {
            return prefix[j];
        }
        return prefix[j] - prefix[i - 1];
    }
}
```

---

## Optimization Techniques

### Reducing Space Complexity

In certain cases, the prefix sum array can be avoided by using two variables:

1. **Left Section:**
   - Maintain a running sum (`leftSection`) as you iterate over the array.
   - Update the running sum by adding the current element.

2. **Right Section:**
   - Calculate the right section dynamically as `total - leftSection`, where `total` is the sum of the entire array.

This optimization reduces the space complexity from O(n) to O(1) while preserving the logic of prefix sums.

---

## Practice Problems

### Easy

1. [Range Sum Query - Immutable](https://leetcode.com/problems/range-sum-query-immutable/)
2. [Find Pivot Index](https://leetcode.com/problems/find-pivot-index/)

### Medium

3. [Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)
4. [Number of Subarrays with Bounded Maximum](https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/)

### Hard

5. [Maximum Sum of Two Non-Overlapping Subarrays](https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/)
6. [Split Array into Consecutive Subsequences](https://leetcode.com/problems/split-array-into-consecutive-subsequences/)

---

## Tips for Java Developers

- Use `Arrays` utility methods for pre-processing, such as `Arrays.stream(nums).sum()` for calculating the total sum.
- Consider edge cases such as empty arrays or single-element arrays during implementation.
- Leverage prefix sum logic for custom constraints by adapting the subtraction formula.

---
