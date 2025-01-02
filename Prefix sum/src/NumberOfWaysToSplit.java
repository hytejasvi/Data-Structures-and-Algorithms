public class NumberOfWaysToSplit {

//https://leetcode.com/problems/number-of-ways-to-split-array/description/
    public static void main(String[] args) {
        int[] nums = {2,3,1,0};
        int res = waysToSplitArray(nums);
        System.out.println(res);
    }

    private static int waysToSplitArray(int[] nums) {
        int res = 0;
        int[] sumArray = new int[nums.length];
        int sum = 0;
        for(int i=0;i<nums.length;i++) {
            sum+=nums[i];
            sumArray[i] += sum;
        }
        for(int i=0;i< nums.length-1;i++) {
            //System.out.println(sumArray[i]+" > "+sumArray[nums.length-1]+" - "+ sumArray[i]+" + "+ nums[i]);
            if(sumArray[i] > (sumArray[nums.length-1] -sumArray[i] + nums[i])) {
                res++;
            }
        }
        return res;
    }

    //implementation to optimize space complexity:
    public int waysToSplitArray2(int[] nums) {
        int ans = 0;
        long leftSection = 0;
        long total = 0;

        for (int num: nums) {
            total += num;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            leftSection += nums[i];
            long rightSection = total - leftSection;
            if (leftSection >= rightSection) {
                ans++;
            }
        }

        return ans;
    }
}
