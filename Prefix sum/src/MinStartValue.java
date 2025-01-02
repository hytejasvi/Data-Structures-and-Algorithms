public class MinStartValue {

/*Given an array of integers nums, you start with an initial positive value startValue.
In each iteration, you calculate the step by step sum of startValue plus elements in nums
(from left to right).
Return the minimum positive value of startValue such that the step by step sum is never less than 1.
*/
    public static void main(String[] args) {
        int[] nums = {1,-2, -3};
        int res = minStartValue(nums);
        System.out.println(res);
    }

    private static int minStartValue(int[] nums) {
        int res = 0;
        int minimumSum = 0;
        int sum = 0;
        for(int i=0;i< nums.length;i++) {
            sum += nums[i];
            minimumSum = Math.min(minimumSum, sum);
        }
        return minimumSum < 0 ? -minimumSum+1 : 1;
    }
}
