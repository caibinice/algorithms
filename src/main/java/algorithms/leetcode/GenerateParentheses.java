package algorithms.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {

    /*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
    */

    //backtrack
    public List<String> generateParenthesisV1(int n) {
        List<String> result = new LinkedList<>();
        if (n < 1) {
            result.add("");
            return result;
        } 
        generatePstr(n, n, "");
        result = ans;
        return result;
    }
    
    private List<String> ans = new LinkedList<>();;
    
    private void generatePstr(int left, int right, String temp) {
        if (right == 0) {
            ans.add(temp);
            return;
        }
        if (left == 0) {
            generatePstr(left, right - 1, temp + ")");
        } else if (right == left) {
            generatePstr(left - 1, right, temp + "(");
        } else {
            generatePstr(left - 1, right, temp + "(");
            generatePstr(left, right - 1, temp + ")");
        }
    }

    //DP iterative 
    /*
First consider how to get the result f(n) from previous result f(0)...f(n-1).
Actually, the result f(n) will be put an extra () pair to f(n-1). Let the "(" always at the first position, to produce a valid result, we can only put ")" in a way that there will be i pairs () inside the extra () and n - 1 - i pairs () outside the extra pair.

Let us consider an example to get clear view:

f(0): ""

f(1): "("f(0)")"

f(2): "("f(0)")"f(1), "("f(1)")"

f(3): "("f(0)")"f(2), "("f(1)")"f(1), "("f(2)")"

So f(n) = "("f(0)")"f(n-1) , "("f(1)")"f(n-2) "("f(2)")"f(n-3) ... "("f(i)")"f(n-1-i) ... "(f(n-1)")"
    */
    public List<String> generateParenthesisV2(int n)
    {
        List<List<String>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(""));
        
        for (int i = 1; i <= n; ++i)
        {
            final List<String> list = new ArrayList<>();
            
            for (int j = 0; j < i; ++j)
            {
                for (final String first : lists.get(j))
                {
                    for (final String second : lists.get(i - 1 - j))
                    {
                        list.add("(" + first + ")" + second);
                    }
                }
            }
            
            lists.add(list);
        }
        
        return lists.get(lists.size() - 1);
    }

}