import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

        // 끝나는 지점을 기준으로 오름차순
        Arrays.sort(targets, (a,b) -> a[1] - b[1]);
        
        int before = 0;
        for(int i=0;i<targets.length;i++){
            // 이전 구간보다 현재의 시작점이 같거나 큰 경우, 끝나는 지점으로 갱신
            if(before <= targets[i][0]){
                before = targets[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}