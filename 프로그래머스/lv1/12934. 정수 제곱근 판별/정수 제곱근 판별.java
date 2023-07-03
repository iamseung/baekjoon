class Solution {
    public long solution(long n) {
        long answer = 0;
        double J = Math.sqrt(n);
        if(J % 1.0 == 0) {
            answer = (long) Math.pow(J+1, 2);
        }
        else {
            answer = -1;
        }
        
        return answer;
    }
}