import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int cnt = 0;
        Arrays.sort(d);
        for(int k : d) {
            if(budget - k < 0) break;
            
            budget -= k;
            cnt++;
        }
            
        return cnt;
    }
}