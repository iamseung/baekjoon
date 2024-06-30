import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        
    	for(int i=0; i<numbers.length; i++) {		
        	//stack에 idx값을 넣어 numbers배열에서 비교
    		while(!stack.empty() && numbers[stack.peek()] < numbers[i]) {
                //가까운 큰 값으로 변경
    			numbers[stack.pop()] = numbers[i];   			
    		}
            // numbers idx값 넣기
    		stack.push(i);
    	}
        
        // 남은 idx값은 더 큰 녀석이 없음
    	for(int i : stack) 
    		numbers[i] = -1;
    	
        return numbers;
    }
}