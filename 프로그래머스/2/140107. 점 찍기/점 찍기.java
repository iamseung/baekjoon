class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        // x축 기준으로 로우별 계산
        for(long x = 0; x <= d; x += k){
            int maxY = (int) Math.sqrt((long)d*d - (long)x*x); 
            answer += maxY / k + 1;
        }
        
        return answer;
    }
}