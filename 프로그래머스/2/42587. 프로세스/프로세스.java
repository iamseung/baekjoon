import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0, len = priorities.length;

        // 우선 순위 내림차순
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int p : priorities)
            pq.add(p);

        while(!pq.isEmpty()) {
            for(int i=0; i<len; i++) {
                // 우선 순위가 높은 순으로 조회, 같은 우선 순위인 경우
                if(priorities[i] == pq.peek()) {
                    pq.poll();
                    answer++;
                    // 찾는 index 의 값
                    if(i == location)
                        return answer;
                }
            }
        }

        return answer; 
    }
}