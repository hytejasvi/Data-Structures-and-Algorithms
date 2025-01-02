import java.util.Arrays;

/*Given an integer array nums, an array queries where queries[i] = [x, y]
and an integer limit, return a boolean array that represents the answer to each query.
A query is true if the sum of the subarray from x to y is less than limit, or false otherwise.

Example, given nums = [1, 6, 3, 2, 7, 2], queries = [[0, 3], [2, 5], [2, 4]], and
limit = 13, the answer is [true, false, true]. For each query, the subarray sums are [12, 14, 12]

*/

public class AnswerQueries {
    public static void main(String[] args) {
        int[] nums = {1, 6, 3, 2, 7, 2};
        int[][]queries = {{0, 3}, {2, 5}, {2, 4}};
        int limit = 13;
        boolean[] queryResult = answerQueries(nums, queries, limit);
        System.out.println(Arrays.toString(queryResult));
    }

    private static boolean[] answerQueries(int[] nums, int[][] queries, int limit) {
        boolean[] queryResult = new  boolean[queries.length];
        int sum = nums[0];
        int[] arraySum = new int[nums.length];
        arraySum[0] = sum;
        for(int i=1;i< nums.length;i++) {
            sum += nums[i];
            arraySum[i] = sum;
        }
        for(int i=0;i< queries.length;i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            queryResult[i] = (arraySum[y] - arraySum[x] + nums[x]) < limit;
        }
        return queryResult;
    }
}
