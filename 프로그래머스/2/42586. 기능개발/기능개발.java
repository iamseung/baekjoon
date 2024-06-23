import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<progresses.length; i++) {
            int gap = (100-progresses[i])/speeds[i];
            if((100-progresses[i])%speeds[i] != 0)
                gap++;

            queue.offer(gap);
            
        }

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            int cnt = 1;
            while(!queue.isEmpty() && queue.peek() <= cur) {
                queue.poll();
                cnt++;
            }

            ans.add(cnt);
        }

        return ans.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
}