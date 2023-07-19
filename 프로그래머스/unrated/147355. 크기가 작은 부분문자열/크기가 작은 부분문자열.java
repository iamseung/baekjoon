import java.util.*;

class Solution {
    int cnt = 0;
    public int solution(String t, String p) {
        long limit = Long.parseLong(p);
        int pL = p.length();
        for(int i=0; i<=t.length()-pL; i++) {
            if(Long.parseLong(t.substring(i,i+pL)) <= limit) cnt++;
        }
        
        return cnt;
    }
}