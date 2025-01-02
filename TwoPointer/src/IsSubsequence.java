public class IsSubsequence {

//https://leetcode.com/problems/is-subsequence/description/
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        boolean isSubsequence = isSubsequence(s, t);
        System.out.println(isSubsequence);
    }

    public static boolean isSubsequence(String s, String t) {
        int left = 0, right = 0;
        while ((left < s.length()) && (right < t.length())) {
            if (s.charAt(left)== t.charAt(right)) {
                left++;
                right++;
            } else {
                right++;
            }
            if (left == s.length()) {
                break;
            }
        }
        return left == s.length();
    }
}
