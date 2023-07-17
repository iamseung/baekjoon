import java.util.*;

class Solution {
    static int[][] arr = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
    
    public int[] solution(int[] answers) {
        ArrayList<Integer> list = new ArrayList<>();
        int max = -1;
        int[] ans = new int[3];
        
        for(int i=0; i<3; i++) {
            for(int j=0; j<answers.length; j++) {
                ans[i] += (answers[j] == arr[i][j % arr[i].length]) ? 1 : 0;
            }
            
            max = Math.max(ans[i], max);
        }
        
        for(int i=0; i<3; i++) {
            if(max == ans[i]) list.add(i+1);
        }
        
        Collections.sort(list);
        
        return list.stream().mapToInt(i->i).toArray();
    }
}