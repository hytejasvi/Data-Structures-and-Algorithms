
# Two Pointers Technique

## Table of Contents  
1. [Introduction to Two Pointers](#introduction-to-two-pointers)  
2. [Core Logic](#core-logic)  
3. [Types of Two Pointer Techniques](#types-of-two-pointer-techniques)  
   - [Pointers Starting at Ends](#pointers-starting-at-ends)  
     - [Pseudocode](#pseudocode-for-pointers-starting-at-ends)  
     - [Example](#example-for-pointers-starting-at-ends)  
     - [Code Snippet](#code-snippet-for-pointers-starting-at-ends)  
     - [Complexities](#complexities-for-pointers-starting-at-ends)  
     - [Common Use Cases](#common-use-cases-for-pointers-starting-at-ends)  
   - [Pointers Moving in Parallel](#pointers-moving-in-parallel)  
     - [Pseudocode](#pseudocode-for-pointers-moving-in-parallel)  
     - [Example](#example-for-pointers-moving-in-parallel)  
     - [Code Snippet](#code-snippet-for-pointers-moving-in-parallel)  
     - [Complexities](#complexities-for-pointers-moving-in-parallel)  
     - [Common Use Cases](#common-use-cases-for-pointers-moving-in-parallel)  
4. [Practice Problems](#practice-problems)  
5. [Tips for Java Developers](#tips-for-java-developers)  

---

## Introduction to Two Pointers  
The two pointers technique is a versatile algorithmic method used for solving problems involving arrays or strings. It involves maintaining two indices (pointers) and using them to traverse the iterable efficiently.  

---

## Core Logic  
1. **Positioning the Pointers:**  
   - Place the pointers at specific indices, such as the beginning and the end of the iterable.  

2. **Movement of Pointers:**  
   - The pointers move toward or away from each other based on the problem’s requirements.  

3. **Logic Application:**  
   - At each step, apply specific logic to determine the movement or update of the pointers.  

By reducing the number of iterations and comparisons, this technique optimizes the solution's performance.  

---

## Types of Two Pointer Techniques  

### Pointers Starting at Ends  

#### Pseudocode for Pointers Starting at Ends  
```  
function twoPointersEnds(arr):  
    left = 0  
    right = arr.length - 1  
    while left < right:  
        // Apply problem-specific logic  
        left++ or right-- depending on the logic  
```  

#### Example for Pointers Starting at Ends  
**Task:** Check if a string is a palindrome.  

#### Code Snippet for Pointers Starting at Ends  
```java
public class PalindromeCheck {
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
```  

#### Complexities for Pointers Starting at Ends  
| **Operation**      | **Time Complexity** | **Space Complexity** |  
|---------------------|---------------------|-----------------------|  
| Traversing Array    | O(n)               | O(1)                 |  

#### Common Use Cases for Pointers Starting at Ends  
1. Checking if a string or array is a palindrome.  
2. Partitioning arrays into two halves based on conditions.  

---

### Pointers Moving in Parallel  

#### Pseudocode for Pointers Moving in Parallel  
```  
function twoPointersParallel(arr1, arr2):  
    i = j = 0  
    while i < arr1.length AND j < arr2.length:  
        // Apply problem-specific logic  
        i++ or j++ depending on the logic  
```  

#### Example for Pointers Moving in Parallel  
**Task:** Merge two sorted arrays into one sorted array.  

#### Code Snippet for Pointers Moving in Parallel  
```java
import java.util.ArrayList;
import java.util.List;

public class MergeSortedArrays {
    public static List<Integer> merge(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();
        
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result.add(arr1[i++]);
            } else {
                result.add(arr2[j++]);
            }
        }
        
        while (i < arr1.length) {
            result.add(arr1[i++]);
        }
        
        while (j < arr2.length) {
            result.add(arr2[j++]);
        }
        
        return result;
    }
}
```  

#### Complexities for Pointers Moving in Parallel  
| **Operation**      | **Time Complexity** | **Space Complexity** |  
|---------------------|---------------------|-----------------------|  
| Traversing Arrays   | O(n + m)           | O(1)                 |  

#### Common Use Cases for Pointers Moving in Parallel  
1. Merging two sorted arrays.  
2. Simultaneously iterating through two lists for comparison.  

---

## Practice Problems  
Here are some curated problems for practice:  

### Easy  
1. [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)  
2. [Reverse String](https://leetcode.com/problems/reverse-string/)  
3. [Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)  
4. [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)  

### Medium  
5. [3Sum](https://leetcode.com/problems/3sum/)  
6. [Container With Most Water](https://leetcode.com/problems/container-with-most-water/)  
7. [Partition Labels](https://leetcode.com/problems/partition-labels/)  
8. [Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)  

### Hard  
9. [Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)  
10. [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)  

---

## Tips for Java Developers  
- Use `ArrayList` for dynamic arrays when working with variable-sized inputs.  
- Leverage Java's built-in functions like `Arrays.sort()` or `Collections.reverse()` for pre-processing.  
- Avoid creating unnecessary intermediate data structures to optimize space usage.  

---
