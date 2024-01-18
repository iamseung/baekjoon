import java.util.*;

class Solution {
    static int[] selected;
    static int K;
    static int ANS = 0;
    
    public int solution(int[] numbers, int target) {
        K = numbers.length;
        selected = new int[K];
        
        DFS(0, numbers, target);
        
        return ANS;
    }
    
    static void DFS(int k, int[] numbers, int target) {
        // 모두 select
        if(k == K) {
            int sum = 0;
            for(int s : selected) sum += s;
            if(sum == target) ANS++;
            return;
        } else {
            selected[k] = numbers[k];
            
            DFS(k+1, numbers, target);
            
            selected[k] = numbers[k] * -1;
            
            DFS(k+1, numbers, target);
        }
    }
}