import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int max = 0;
        int min = 0;

        for(int[] e : sizes) {
            max = Math.max(max, Math.max(e[0], e[1]));
            min = Math.max(min, Math.min(e[0], e[1]));
        }
        
        return max * min;
    }
}