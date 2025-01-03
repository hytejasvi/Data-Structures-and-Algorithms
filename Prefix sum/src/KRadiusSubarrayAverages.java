import java.util.Arrays;


/*
You are given a 0-indexed array nums of n integers, and an integer k.
The k-radius average for a subarray of nums centered at some index i with
the radius k is the average of all elements in nums between the indices i - k and
i + k (inclusive). If there are less than k elements before or after the index i,
then the k-radius average is -1.

Build and return an array avgs of length n where avgs[i] is the k-radius average
for the subarray centered at index i.
The average of x elements is the sum of the x elements divided by x, using integer division.
The integer division truncates toward zero, which means losing its fractional part.
*/

public class KRadiusSubarrayAverages {
    public static void main(String[] args) {
        int[] nums = {7,4,3,9,1,8,5,2,6};
        int k=3;
        int [] res = getAverages(nums , k);
        System.out.println(Arrays.toString(res));
    }

    private static int[] getAverages(int[] nums, int k) {
        if (k >= nums.length) {
           return new int[]{-1};
        }
        int []res = new int[nums.length];
        int windowSize = k*2+1;
        int left = 0, right = 0, windowSum=0;
        for(int i=0;i< nums.length;i++) {
            res[i] = -1;
        }
        while(right < nums.length) {
            windowSum = windowSum+nums[right];
            if(right >= windowSize) {
                windowSum = windowSum-nums[left];
                left++;
            }
            if (right >= windowSize-1) {
                res [right-k] = windowSum/windowSize;
            }
            right++;
        }
        return res;
    }
}
