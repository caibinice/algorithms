package algorithms.leetcode;

public class ValidNumber {

    /**
     * Validate if a given string is numeric.
     * <p>
     * Some examples:
     * "0" => true
     * " 0.1 " => true
     * "abc" => false
     * "1 a" => false
     * "2e10" => true
     * <p>
     * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
     */
    public boolean isNumber(String s) {
        if (s == null || s.trim().length() < 1) return false;
        String str = s.trim();
        boolean containsE = false, containsPoint=false, containsNumber=false;
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (c>='0' && c<='9') {
                containsNumber = true;
            } else if (c == 'e' || c=='E') {
                if (!containsNumber || containsE || i==str.length()-1) return false;
                containsE = true;
                containsNumber = false;
                containsPoint = false;
            } else if (c=='.') {
                if (containsPoint||containsE) return false;
                containsPoint = true;
            }
            else if (c =='-'||c=='+') {
                if (i == 0) continue;
                if (str.charAt(i-1)=='e'||str.charAt(i-1)=='E') continue;
                return false;
            }
            else {
                return false;
            }
        }
        return containsNumber;
    }


}
