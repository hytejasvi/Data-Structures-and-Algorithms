public class SubarrayProductLessThanK {

//https://leetcode.com/problems/subarray-product-less-than-k/description/
    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int k = 0;
        int res = numSubarrayProductLessThanK(nums, k);
        System.out.println(res);
    }

    private static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <=1) {
            return 0;
        }
        int res = 0;
        int left = 0, right = 0;
        int windowProduct = 1;
        while(right <nums.length) {
            windowProduct = windowProduct*nums[right];
            while(windowProduct >= k) {
                windowProduct = windowProduct/nums[left];
                left++;
            }
            res = res+ right-left+1;
            right++;
        }
        return res;
    }
}
