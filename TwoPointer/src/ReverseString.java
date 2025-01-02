import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        System.out.println("before reversing: "+ Arrays.toString(s));
        reverseString(s);
        System.out.println("after reversing: "+ Arrays.toString(s));
    }

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
