import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int size = sizes.length;
        int[] small = new int[size];
        int[] big = new int[size];
        for(int i=0; i<size; i++) {
            small[i] = Math.min(sizes[i][0], sizes[i][1]);
            big[i] = Math.max(sizes[i][0], sizes[i][1]); 
        }
        
        Arrays.sort(small);
        Arrays.sort(big);
        
        return small[size-1] * big[size-1];
    }
}