import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long L = 0;
        long R = times[times.length - 1] * (long) n;

        while(L<=R) {
            long mid = (L+R)/2;
            long complete = 0;

            /*
             * 각 심사대 별로 주어진 시간동안
             * 몇명의 사람을 심사할 수 있는지 계산
             */
            for(int time : times)
                complete += mid/time;

            // 주어진 시간동안 모든 사람을 심사할 수 없음
            if(complete < n) {
                L = mid + 1;
            } else {
                // 모든 사람을 심사할 수 있음
                R = mid - 1;
                answer = mid;
            }
        }

        return answer;
    }
}