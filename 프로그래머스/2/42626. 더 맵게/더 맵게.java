import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int idx = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int s : scoville)
            queue.offer(s);

        while(queue.peek() < K) {
            if(queue.size() < 2 ) {
                idx = -1;
                break;
            }
            
            queue.offer(queue.poll() + queue.poll() * 2);
            idx++;
        }
        
        return idx;
    }
}