import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<int[]> stack = new Stack<>();
        
        for(int i = 0; i < prices.length; i++){
            answer[i] = answer.length - 1 - i;
            int[] arr = {i, prices[i]};
            
            // 값이 떨어짐
            while(!stack.empty() && stack.peek()[1] > prices[i]){
                int[] price = stack.pop();
                answer[price[0]] = i - price[0];
            }
            
            stack.push(arr);
        }
        
        return answer;
    }
}