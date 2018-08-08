package algorithms.leetcode;

public class ImplementSqrt {

    /**
     * Implement int sqrt(int x).
     * <p>
     * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
     * <p>
     * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
     * <p>
     * Example 1:
     * <p>
     * Input: 4
     * Output: 2
     * Example 2:
     * <p>
     * Input: 8
     * Output: 2
     * Explanation: The square root of 8 is 2.82842..., and since
     * the decimal part is truncated, 2 is returned.
     */

    public int mySqrt(int x) {
        if (x < 1) return 0;
        if (x < 4) return 1;
        long k = 2, result=k*k;
        int max=0;
        while (result < x) {
            k = 2 * k;
            result = k * k;
            max++;
        }
        if (result == x) return (int) k;
        for(int i=max-1;i>=0;i--) {
            result = k * k;
            while (result > x) {
                k = k - (long) Math.pow(2, i);
                result = k * k;
            }
            if (result == x) return (int) k;
            k = k +  (long) Math.pow(2, i);
        }
        return (int) k-1;
    }

    //binary search
    public int mySqrtV2(int x) {
        if (x==0)
            return 0;
        if (x>0 && x<4)
            return 1;
        int left = 1, right = x/2;
        while (true) {
            int mid = (left + right)/2;
            if (mid > 0 && mid > x/mid) {
                right = mid-1;
            } else if ((mid+1) > x/(mid+1)) {
                return mid;
            } else {
                left = mid+1;
            }
        }
    }

    //直接求Integer Newton 牛顿整数
    public int mySqrtV3(int x) {
        long r = x;
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int) r;
    }

    //位移法，和第一种逻辑类似
    public int mySqrtV4(int x) {
        if(x == 0) return 0;
        long ans = 0, bit = 1;
        while(bit * bit <= x) {  // firstly, find the most significant bit
            bit <<= 1;
        }
        bit >>= 1;
        ans |= bit;
        bit >>= 1;
        while(bit > 0) {
            ans |= bit;
            if(ans * ans > x)
                ans ^= bit;
            bit >>= 1;
        }
        return (int)ans;
    }


    public static void main(String[] args) {
        System.out.println(new ImplementSqrt().mySqrt(555666));
    }
}
