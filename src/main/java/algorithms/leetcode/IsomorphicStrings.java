package algorithms.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class IsomorphicStrings {

    /** 
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. 
No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.
*/

    //未通过，最后的超长字符串出错了
    public boolean isIsomorphicFailed(String s, String t) {
        if (s.length() <= 1) return true;
        HashMap<Character, List<Integer>> sChar = getCharRepeatArray(s);
        HashMap<Character, List<Integer>> tChar = getCharRepeatArray(t);
        for (int i = 0; i < s.length(); i++) {
            if (!compareList(sChar.get(s.charAt(i)), tChar.get(t.charAt(i)))) return false;
        }
        return true;
    }

    private static HashMap<Character, List<Integer>> getCharRepeatArray(String str) {
        int[] arr = new int[str.length()];
        HashMap<Character, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> indexList;
            if (indexMap.containsKey(str.charAt(i))) {
                indexList = indexMap.get(str.charAt(i));
            } else {
                indexList = new ArrayList<>();
            }
            indexList.add(i);
            indexMap.put(str.charAt(i), indexList);
        }
        return indexMap;
    }

    private static boolean compareList(List<Integer> l1, List<Integer> l2) {
        if(l1 == null || l2 == null ||l1.size() != l2.size()) return false;
        for (int i = 0; i < l1.size(); i++) {
            if (l1.get(i) != l2.get(i)) return false;
        }
        return true;
    }

    //正确版本，直接用数组，以当前Char为角标的元素记录当前Char出现的位置，然后下次又出现时判断两个String里的Char上一次出现的位置是否一致
    //i+1是为了将Index为0的情况和数组初始化的值0区分，256是ASCII的最大值，可以扩大
    public boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        
    }

}