import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> Q = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++) {
            int N = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0) N++;
            Q.add(N);
        }
        
        while(!Q.isEmpty()) {
            int T = Q.poll(); // 7
            int cnt = 1;
            while(!Q.isEmpty()) {
                if(T >= Q.peek()) {
                    Q.poll();
                    cnt++;
                } else {
                    break;
                }
            }
            
            answer.add(cnt);
        }
        
        int[] arr = answer.stream()
	        .mapToInt(Integer::intValue)
    	    .toArray();
        return arr;
    }
}