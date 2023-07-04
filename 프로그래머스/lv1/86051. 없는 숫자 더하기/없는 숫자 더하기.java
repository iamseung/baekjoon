import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 45;
        for(int k : numbers) answer -= k;
        
        return answer;
    }
    
}