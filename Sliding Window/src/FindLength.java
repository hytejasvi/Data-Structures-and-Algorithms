public class FindLength {
/*Given an array of positive integers nums and an integer k,
find the length of the longest subarray whose sum is less than or equal to k*/

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 7, 4, 2, 1, 1, 5};
        int k = 8;
        int len = findLength(nums, k);
        System.out.println(len);
    }

    private static int findLength(int[] nums, int k) {
        int maxlength=0;
        int left = 0, right =0;
        int windowSum=0;
        while(right < nums.length) {
            windowSum = windowSum+nums[right];
            while(windowSum > k){
                windowSum -=nums[left];
                left++;
            //if(windowSum <= k) {
            }
            maxlength = Math.max(maxlength, right - left + 1);
            right++;
        }
        return maxlength;
    }
}
