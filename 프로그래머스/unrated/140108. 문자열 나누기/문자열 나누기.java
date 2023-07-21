import java.util.*;
class Solution {
    public int solution(String s) {
        String[] M = s.split("");
        int cur = 1, other = 0;
        int cnt = 0;
        String target = M[0];
        for(int i=1; i<M.length; i++) {
            if(M[i].equals(target))
                cur++;
            else
                other++;
            
            if(cur == other) {
                cnt++;
                cur = 0;
                other = 0;
                if(i+1 >= M.length) break;
                target = M[i+1];
            }
        }
        
        if(cur != 0 || other != 0) cnt++;
        
        return cnt;
    }
}