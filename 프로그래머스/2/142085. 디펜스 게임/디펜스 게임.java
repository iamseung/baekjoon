import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        // 적군 수 우선순위 큐 (내림차순 정렬)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // 게임 진행
        for(int i = 0; i < enemy.length; i ++) {
            // 병사가 부족하고 무적권도 없을 경우
            if(n < enemy[i] && k == 0) 
                break;   
            
            // 적군 수 우선순위 큐에 추가
            pq.offer(enemy[i]); 
            
            // 병사가 부족해서 무적권을 사용할 경우
            if(n < enemy[i]) {
                // 지금까지 가장 많았던 적군 수 만큼 채우기, 지금 라운드 포함
                n += pq.poll();
                // 무적권 사용
                k --;   
            }
            
            n -= enemy[i];  // 병사 사용
            answer ++;  // 라운드 추가
        }

        return answer;
    }
}