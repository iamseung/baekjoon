import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            // 비어있으면 무조건 insert
            if(stack.isEmpty()) {
                stack.add(c);
                continue;
            }
            // 마지막에 들어있는 것과 같다면
            if(stack.peek().equals(c)) {
                stack.pop();
                continue;
            }
            
            stack.add(c);
        }

        return (stack.isEmpty()) ? 1 : 0;
    }
}