
# Two Pointers Technique

## Table of Contents  
1. [Introduction to Two Pointers](#introduction-to-two-pointers)  
2. [Types of Two Pointer Techniques](#types-of-two-pointer-techniques)  
   - [Pointers Starting at Ends](#pointers-starting-at-ends)  
   - [Pointers Moving in Parallel](#pointers-moving-in-parallel)  
3. [Common Use Cases](#common-use-cases)  
4. [Examples in Java](#examples-in-java)  
5. [Time and Space Complexity](#time-and-space-complexity)  
6. [Tips for Java Developers](#tips-for-java-developers)  

## Introduction to Two Pointers  
The two pointers technique is a versatile algorithmic method used for solving problems involving arrays or strings. The idea involves maintaining two indices (pointers) and using them to traverse the iterable efficiently.

## Types of Two Pointer Techniques  

### Pointers Starting at Ends  
This approach starts one pointer at the beginning and the other at the end of the iterable. Both pointers move towards each other based on specific conditions.  
**Example Use Case:** Checking if a string is a palindrome.  

### Pointers Moving in Parallel  
In this approach, two pointers move along two iterables simultaneously or at different speeds.  
**Example Use Case:** Merging two sorted arrays.

---

## Common Use Cases  
1. Finding pairs in a sorted array with a given sum.  
2. Reversing a string or array in place.  
3. Partitioning problems, such as segregating even and odd numbers.  

---

## Examples in Java  

### Example 1: Reversing a String  
```java
public class ReverseString {
    public static void reverse(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
```

### Example 2: Two Sum in a Sorted Array  
```java
public class TwoSumSortedArray {
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }
}
```

---

## Time and Space Complexity  

| **Technique**              | **Time Complexity** | **Space Complexity** |  
|----------------------------|---------------------|-----------------------|  
| Pointers Starting at Ends  | O(n)               | O(1)                 |  
| Pointers Moving in Parallel| O(n + m)           | O(1)                 |  

---

## Tips for Java Developers  
- Use `ArrayList` for dynamic arrays when working with variable-sized inputs.  
- Leverage Java's built-in functions like `Arrays.sort()` or `Collections.reverse()` for pre-processing.  
- Avoid creating unnecessary intermediate data structures to optimize space usage.  

---

## Visual Guide  

Below is a visual representation of the Two Pointers Technique:

![Two Pointers Visualization](two_pointers_diagram.png)

In this diagram:  
1. The two pointers start at opposite ends or at specific positions in the array.  
2. The pointers move based on the logic dictated by the problem, eventually meeting the required condition.  

---

This concludes the introduction to Two Pointers. Future documents will explore more advanced variations like Sliding Window, Merge K Sorted Arrays, and more.
