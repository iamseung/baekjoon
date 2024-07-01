import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int w : works)
            queue.offer(w);

        while (n-- > 0 && !queue.isEmpty()) {
            int cur = queue.poll();
            if(cur == 1)
                continue;

            queue.offer(cur-1);
        }

        while (!queue.isEmpty()) {
            answer += Math.pow(queue.poll(), 2);
        }

        return answer;
    }
}