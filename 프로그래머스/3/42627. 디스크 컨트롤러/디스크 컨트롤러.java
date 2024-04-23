import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 작업을 요청 시간 기준으로 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]); // 소요 시간 기준으로 최소 힙
        int count = 0;
        int currentTime = 0;
        int totalWaitingTime = 0;
        int index = 0;

        // 모든 작업을 처리할 때까지 반복
        while (count < jobs.length) {
            // 현재 시간까지 들어온 모든 작업을 큐에 추가
            while (index < jobs.length && jobs[index][0] <= currentTime) {
                queue.add(jobs[index++]);
            }

            if (queue.isEmpty()) {
                // 처리할 작업이 없다면, 다음 작업이 요청되는 시점으로 시간을 이동
                currentTime = jobs[index][0];
            } else {
                // 작업 처리
                int[] job = queue.poll();
                currentTime += job[1];
                totalWaitingTime += currentTime - job[0];
                count++;
            }
        }
        
        return totalWaitingTime / jobs.length; // 평균 대기 시간 반환
    }
}