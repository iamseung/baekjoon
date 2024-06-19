import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            // 스택이 비어있는 경우 삽입
            if(stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            // '(' 인 경우엔 그냥 넣어
            if(c == '(') {
                stack.push(c);
                continue;
            }

            if(c == ')') {
                stack.pop();
            }
        }

        return stack.isEmpty() ? true : false;
    }
}