public class MaxAverageSubArray {
/*You are given an integer array nums consisting of n elements, and an integer k.
Find a contiguous subarray whose length is equal to k that has the maximum average value
and return this value. Any answer with a calculation error less than 10-5 will be accepted.*/

    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        double maxAverage = findMaxAverage(nums, k);
        System.out.println(maxAverage);
    }

    private static double findMaxAverage(int[] nums, int k) {
        int windowSum = 0;
        for (int i=0;i<k;i++) {
            windowSum = windowSum+nums[i];
        }
        double maxAverage = windowSum/k;
        int left = 0;
        for (int i=k;i<nums.length;i++) {
            windowSum = windowSum + nums[i] - nums[left];
            left++;
            maxAverage = Math.max(maxAverage, windowSum/k);
        }
        return maxAverage;
    }
}
