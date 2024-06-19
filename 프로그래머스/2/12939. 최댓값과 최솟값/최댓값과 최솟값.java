import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s, " ");

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while(st.hasMoreTokens()) {
            int e = Integer.parseInt(st.nextToken());
            min = Math.min(min, e);
            max = Math.max(max, e);
        }
        
        return min + " " + max;
    }
}