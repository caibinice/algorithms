package algorithms.leetcode;

public class LongestCommonPrefix {

/**
    编写一个函数来查找字符串数组中的最长公共前缀。

    如果不存在公共前缀，返回空字符串 ""。

    示例 1:

    输入: ["flower","flow","flight"]
    输出: "fl"
    示例 2:

    输入: ["dog","racecar","car"]
    输出: ""
    解释: 输入不存在公共前缀。
    说明:

    所有输入只包含小写字母 a-z 。*/

    public String longestCommonPrefix(String[] strs) {
        if (strs==null || strs.length<1) return "";
        int arrLen = strs.length;
        String first = strs[0];
        if (arrLen == 1 || first.length()<1) return first;
        int maxIndex = 0;
        boolean reachEnd = false;
        for (int i=0;i<first.length();i++) {
            for (int j=1;j<arrLen;j++) {
                if (strs[j].length()<1) return "";
                if (i >= strs[j].length() || first.charAt(i) != strs[j].charAt(i)) {
                    reachEnd = true;
                    break;
                }
                maxIndex ++;
            }
            if (reachEnd) {
                if (i == 0) return "";
                return first.substring(0, i);
            }
        }
        return maxIndex >= first.length()? first : first.substring(0, maxIndex);
    }
}
