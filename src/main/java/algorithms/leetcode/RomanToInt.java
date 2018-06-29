package algorithms.leetcode;

public class RomanToInt {
    /**
     * 罗马数字包含以下七种字符：I， V， X， L，C，D 和 M。
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     * <p>
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * <p>
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     */

    public static int romanToInt(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int result = 0;
        char[] romans = s.toCharArray();
        for (int i = 0; i < romans.length; i++) {
            switch (romans[i]) {
                case 'M':
                    result += 1000;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'C':
                    if (i < romans.length - 1 && (romans[i + 1] == 'M' || romans[i + 1] == 'D')) {
                        result -= 100;
                    } else {
                        result += 100;
                    }
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'X':
                    if (i < romans.length - 1 && (romans[i + 1] == 'L' || romans[i + 1] == 'C')) {
                        result -= 10;
                    } else {
                        result += 10;
                    }
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'I':
                    if (i < romans.length - 1 && (romans[i + 1] == 'V' || romans[i + 1] == 'X')) {
                        result -= 1;
                    } else {
                        result += 1;
                    }
                    break;
            }
        }
        return result;
    }

    //convert Int to Roman  整数转罗马:一个简单的类似进制转换的方法
    public static String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }


    public static void main(String[] args) {
        System.out.println(romanToInt("IX"));
    }
}
