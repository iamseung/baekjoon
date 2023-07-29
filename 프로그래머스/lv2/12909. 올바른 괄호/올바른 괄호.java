import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<String> stack = new Stack<>();
        char[] c = s.toCharArray();
        
        for(char v : c) {
            if(v == ')') {
                if(!stack.isEmpty() && stack.peek().equals("(")) {
                    stack.pop();
                    continue;
                }
                   
                return false;
            }
            
            stack.push(String.valueOf(v));
        }
                   
        return (stack.isEmpty()) ? true : false;
    }
}