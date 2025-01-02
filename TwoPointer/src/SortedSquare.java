import java.util.Arrays;

/*Given an integer array nums sorted in non-decreasing order,
return an array of the squares of each number sorted in non-decreasing order.*/
public class SortedSquare {
    public static void main(String[] args) {
        int[] nums = {-7,-3,2,3,11};
        int[] res = sortedSquares(nums);
        System.out.println(Arrays.toString(res));
    }


    public static int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length-1;
        int k=nums.length-1;
        int[] res = new int[nums.length];
        while (left <= right) {
            if ((nums[left]*nums[left]) > (nums[right]*nums[right])) {
                res[k--] = nums[left]*nums[left];
                left++;
            } else {
                res[k--] = nums[right]*nums[right];
                right--;
            }
        }
        return res;
    }
}
