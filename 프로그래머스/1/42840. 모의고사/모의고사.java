import java.util.*;
import java.util.stream.*;

class Solution {
    static final int len = 3;
    static int[][] arr = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
    
    public static int[] solution(int[] answers) {
        List<Integer> list = new ArrayList<>();
        int max = 0;
        int[] ans = new int[len];
        
        for(int i=0; i<len; i++) {
            for(int j=0; j<answers.length; j++) {
                ans[i] += (answers[j] == arr[i][j % arr[i].length]) ? 1 : 0;
            }
            
            max = Math.max(ans[i], max);
        }
        
        for(int i=0; i<len; i++) {
            if(max == ans[i]) list.add(i+1);
        }
        
        return list.stream()
                    .sorted()
                    .mapToInt(i->i)
                    .toArray();
    }
}