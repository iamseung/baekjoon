import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;

        // 시작 지점을 기준으로 오름차순
        Arrays.sort(routes, (a,b) -> (a[1] - b[1]));

        // 첫번째의 끝나는 지점을 기준으로 시작
        int last = routes[0][1];

        for(int i=1; i<routes.length; i++) {
            if(routes[i][0] <= last && routes[i][1] >= last)
                continue;
            
            last = routes[i][1];
            answer++;
        }
        
        return answer;
    }
}