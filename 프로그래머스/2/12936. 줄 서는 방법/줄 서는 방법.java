import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();

        long factorial = 1;
        for(int i=1; i<=n; i++) {
            list.add(i);
            factorial *= i;
        }

        k--; 
        int idx = 0;
        while(idx < n) {
            factorial /= n - idx;
            answer[idx++] = list.remove((int) (k / factorial));
            k %= factorial;
        }

        return answer;
    }
}