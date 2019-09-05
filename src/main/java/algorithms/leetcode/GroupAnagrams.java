package algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

 /**
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.

  */   

    //brutal force暴力法
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        int[][] charMapArray = new int[strs.length][26];
        for (int i = 0; i < strs.length; i++) {
            charMapArray[i] = getCharMap(strs[i]);
        }
        List<List<Integer>> resultIndex = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            boolean isCharExisted = false;
            for (int j = 0; j < resultIndex.size(); j++) {
                if(compare2Str(i, resultIndex.get(j).get(0), charMapArray)) {
                    isCharExisted = true;

                    //这里去重了，原题要求不去重，因此可忽略isEqual的操作
                    boolean isEqual = false;
                    for (int k = 0; k < resultIndex.get(j).size(); k++) {
                        if (strs[i].equals(strs[resultIndex.get(j).get(k)])) {
                            isEqual = true;
                            break;
                        }
                    }
                    if (!isEqual) {
                        result.get(j).add(strs[i]);
                        resultIndex.get(j).add(i);
                    }
                    break;
                }
            }
            if (!isCharExisted) {
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                result.add(newList);
                List<Integer> newIndexList = new ArrayList<>();
                newIndexList.add(i);
                resultIndex.add(newIndexList);
            }
        }
        return result;
    }

    private boolean compare2Str(int s1, int s2, int[][] charMapArray) {
        int[] charMap1 = charMapArray[s1];
        int[] charMap2 = charMapArray[s2];
        for (int i = 0; i < 26; i++) {
            if (charMap1[i] != charMap2[i]) return false;
        }
        return true;
    }

    private int[] getCharMap(String str) {
        int[] charMap = new int[26];
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            charMap[index] ++;
        } 
        return charMap;
    }

    //将排序好的字符串作为Hashmap的key，value是排序以后和key相同的字符串的List
    public List<List<String>> groupAnagramsV2(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    //以记录char个数的数组 合成的字符(比如abc就是#1#2#3#0#0#0...#0)作为Key构建hashmap，value则为和该key一致的字符串list
    public List<List<String>> groupAnagramsV3(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}