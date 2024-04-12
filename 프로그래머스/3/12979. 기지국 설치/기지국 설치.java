import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int now = 1; // 현재 위치
        int stationsIdx = 0; // 기지국 index
        int answer = 0; // 설치해야 하는 기지국 개수

        while(now <= n) {
            /*
             * 현재 위치 기준
             * 1. 모든 기지국 범위를 넘어선 경우 
             * 2. 기지국의 범위밖에 있는 경우
             */
            if(stationsIdx >= stations.length || now < stations[stationsIdx] - w) {
                // now + w 에 설치
                answer++;
                now += w * 2 + 1;
            } else {
                /*
                 * 특정 기지국 범위내에 있는 경우
                 * 1. 현재 위치를 기지국 밖으로 이동
                 * 2. 계산할 기지국을 다음 기지국으로 변경
                 */
                now = stations[stationsIdx] + w + 1;
                stationsIdx++;
            }
        }
        
        return answer;
    }
}