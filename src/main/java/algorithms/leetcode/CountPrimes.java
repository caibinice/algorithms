package algorithms.leetcode;

import java.util.ArrayList;

public class CountPrimes {

    /**
Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
     */

     //埃拉托斯特尼筛法  https://blog.csdn.net/o83290102o5/article/details/79491834 
    public int countPrimes(int n) {
        if (n < 3)
            return 0;
            
        boolean[] f = new boolean[n];
        //Arrays.fill(f, true); boolean[] are initialed as false by default
        int count = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            if (f[i])
                continue;
            
            for (int j = i * i; j < n; j += 2 * i) {
                if (!f[j]) {
                    --count;
                    f[j] = true;
                }
            }
        }
        return count;
    }

}