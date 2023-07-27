import java.util.*;

class Solution {
    // static char[] option = {'*', '#'};
    // static char[] bonus = {'S', 'D', 'T'};
    static Stack<Integer> stack = new Stack<>();
    
    public int solution(String dartResult) {
       char target;
        int T, N;
        for(int i=0; i<dartResult.length(); i++) {
            target = dartResult.charAt(i);
            
            if(target == 'S' || target=='D' || target=='T') {
                N = dartResult.charAt(i-1) - '0';
                if(N == 0 && i-2 >= 0 && dartResult.charAt(i-2) == '1') N = 10;
                stack.push((int)Math.pow(N, bonusScore(target)));
                System.out.println(stack.peek());
            }
            
            else if(target=='*' || target=='#') {
                T = stack.pop();
                if(target=='*') {
                    if(!stack.isEmpty()) {
                        stack.push(stack.pop() * 2);
                    }
                    stack.push(T*2);
                }
                else {
                    stack.push(T*-1);
                }
                System.out.println(stack.peek());
            }
        }
        int ans = 0;
        while(!stack.isEmpty()) ans += stack.pop();
        
        return ans;
    }
    
    static int bonusScore(char target) {
        int index;
        if(target == 'S') {
            index = 1;
        } else if(target == 'D') {
            index = 2;
        } else {
            index = 3;
        }
        
        return index;
    }
}