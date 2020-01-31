package algorithms.leetcode;

public class ValidPalindrome {

/** 
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
*/

    //判断字符串是否是回文串（左右对称），忽略大小写和非数字/字母
    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) return true;
        int left = 0;
        int right = s.length() - 1;
        while(left <= right) {
            while(!Character.isLetterOrDigit(s.charAt(left)) && left < right) {
                left ++;
            }
            while(!Character.isLetterOrDigit(s.charAt(right)) && left < right) {
                right --;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            left ++;
            right --;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("Live on evasions No I save no evil"));

        
    }
}