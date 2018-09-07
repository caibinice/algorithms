package algorithms.leetcode;

public class CompareVersionNumbers {

    /**
     * Compare two version numbers version1 and version2.
     * If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
     * <p>
     * You may assume that the version strings are non-empty and contain only digits and the . character.
     * The . character does not represent a decimal point and is used to separate number sequences.
     * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
     * <p>
     * Example 1:
     * <p>
     * Input: version1 = "0.1", version2 = "1.1"
     * Output: -1
     * Example 2:
     * <p>
     * Input: version1 = "1.0.1", version2 = "1"
     * Output: 1
     * Example 3:
     * <p>
     * Input: version1 = "7.5.2.4", version2 = "7.5.3"
     * Output: -1
     */

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len = Math.max(v1.length, v2.length);
        int val1, val2;
        for (int i = 0; i < len; i++) {
            if (i >= v1.length) {
                if (Integer.valueOf(v2[i]) == 0) //为了解决"1.0"=="1"的题目要求
                    continue;
                return -1;
            }
            if (i >= v2.length) {
                if (Integer.valueOf(v1[i]) == 0)
                    continue;
                return 1;
            }
            val1 = Integer.valueOf(v1[i]);
            val2 = Integer.valueOf(v2[i]);
            if (val1 > val2) {
                return 1;
            } else if (val1 < val2) {
                return -1;
            }
        }
        return 0;
    }
}
