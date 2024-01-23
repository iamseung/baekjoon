import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int s : scoville) 
            pq.offer(s);
        
        int index = 0;
        while (pq.peek() < K) {
            if(pq.size() == 1) {
                return -1;
            }
            
            int a = pq.poll();
            int b = pq.poll();

            pq.offer(a + b*2);

            index++;
        }

        return index;
    }
}