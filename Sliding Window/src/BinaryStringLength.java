public class BinaryStringLength {
/*You are given a binary string s (a string containing only "0" and "1").
You may choose up to one "0" and flip it to a "1".
What is the length of the longest substring achievable that contains only "1"?*/

    public static void main(String[] args) {
        String s = "1101100111";
        int len = findLength(s);
        System.out.println(len);
    }

    private static int findLength(String s) {
        int res = 0;
        int left = 0, right = 0;
        boolean isZeroAllowed = true;
        while (right < s.length()) {
            if(s.charAt(right) == '0') {
                if(isZeroAllowed) {
                    isZeroAllowed = false;
                } else {
                    while(s.charAt(left) != '0') {
                        left++;
                    }
                    left++;
                }
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }


    //a better program:
    private static int findLength2(String s) {
        int res = 0;
        int left = 0, zeroCount = 0;

        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '0') {
                zeroCount++;
            }

            // If more than 1 zero is in the window, shrink from the left
            while (zeroCount > 1) {
                if (s.charAt(left) == '0') {
                    zeroCount--;
                }
                left++;
            }

            // Update the result with the current window size
            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}
