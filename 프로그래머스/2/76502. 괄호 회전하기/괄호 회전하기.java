import java.util.*;

class Solution {
    public int solution(String s) {
        int len = s.length();
        int ans = 0;
        
        while (len-- >0) {
            s = transString(s);
            ans += valid(s);
        }

        return ans;
    }
    
    public static int valid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(stack.isEmpty()) {
                stack.add(c);
                continue;
            }

            if(c == ']') {
                if(stack.peek() == '[') {
                    stack.pop();
                }
            }else if(c == '}') {
                if(stack.peek() == '{') {
                    stack.pop();
                }
            }else if(c == ')') {
                if(stack.peek() == '(') {
                    stack.pop();
                }
            } else {
                stack.add(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static String transString(String s) {
        return s.substring(1, s.length()) + String.valueOf(s.charAt(0));
    }
}