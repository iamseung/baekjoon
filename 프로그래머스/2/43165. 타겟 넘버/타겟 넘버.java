import java.util.*;
import java.util.stream.*;

class Solution {
    static int len;
    static int[] selected;
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        len = numbers.length;
        selected = new int[len];
        dfs(0, numbers, target);

        return answer;
    }

    static void dfs(int k, int[] numbers, int target) {
        if(k == len) {
            int ans = Arrays.stream(selected).sum();
            if(ans == target)
                answer++;
            
            return;
        }

        selected[k] = numbers[k];
        dfs(k+1, numbers, target);

        selected[k] = numbers[k] * -1;
        dfs(k+1, numbers, target);
    }
}