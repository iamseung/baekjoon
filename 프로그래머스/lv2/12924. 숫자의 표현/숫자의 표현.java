class Solution {
    public int solution(int n) {
        /**
            홀수면 n/2 + n/2-1 로 표현 가능 +1
            자기자신 +1
            루프 범위는 1 ~ n/2
            투포인터, 누적합으로 풀이
        */
        
        int cnt = (n%2 == 1) ? 2 : 1;
        if(n ==1) cnt = 1;
        int R=0, total = 0;
        for(int L=1; L<=n/2; L++) {
            total -= L-1;
            
            while(R+1 <= n/2 && total < n) {
                total += ++R;
            }
            
            if(total == n) cnt++;
        }
        
        return cnt;
    }
}