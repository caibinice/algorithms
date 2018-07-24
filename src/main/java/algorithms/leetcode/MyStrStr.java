package algorithms.leetcode;

public class MyStrStr {

/**
    实现 strStr() 函数。

    给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

    示例 1:

    输入: haystack = "hello", needle = "ll"
    输出: 2
    示例 2:

    输入: haystack = "aaaaa", needle = "bba"
    输出: -1
    说明:

    当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

    对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。*/

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() < 1)
            return 0;
        if (haystack == null || haystack.length() < 1)
            return -1;
        int hLen = haystack.length();
        int nLen = needle.length();
        if (nLen > hLen || (nLen == hLen && !needle.equals(haystack)))
            return -1;
        int nextIndex = 0;
        Character first = needle.charAt(0);
        int i = 0;
        while (i < hLen) {
            for (int j = 0; j < nLen; j++) {
                if (i+j>=hLen) return -1;
                Character hc = haystack.charAt(i+j);
                Character nc = needle.charAt(j);
                if (hc == first && nextIndex <= i) {
                    nextIndex = i+j;
                }
                if (hc != nc) {
                    break;
                }
                if (j == nLen -1) {
                    return i;
                }
            }
            i = nextIndex>i?nextIndex:i+1;
        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(strStr("cdcecdceg","cdceg"));

    }
}

