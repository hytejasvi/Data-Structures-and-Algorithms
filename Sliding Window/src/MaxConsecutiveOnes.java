public class MaxConsecutiveOnes {

/*Given a binary array nums and an integer k, return the maximum number of
consecutive 1's in the array if you can flip at most k 0's.
 */

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k=3;
        int res = longestOnes(nums, k);
        System.out.println(res);
    }

    private static int longestOnes(int[] nums, int k) {
        int res = 0;
        int left = 0, right=0;
        int zeroCount = 0;
        while(right < nums.length) {
            if(nums[right] == 0) {
                zeroCount++;
            }
            while(zeroCount > k) {
                if(nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            res = Math.max(res, right-left+1);
            right++;
        }
        return res;
    }
}
