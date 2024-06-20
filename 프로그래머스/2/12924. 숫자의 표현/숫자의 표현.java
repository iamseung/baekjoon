class Solution {
    public int solution(int n) {
        if(n ==1) 
            return 1;
        
        int answer = (n%2 == 1) ? 2 : 1;

        int half = n/2;
        int r = 0, sum = 0;

        for(int l=1; l<=half; l++) {
            sum -= l-1;

            while ( r+1 < half && sum < n) {
                sum += ++r;
            }

            if(sum == n)
                answer++;
        }
        
        return answer;
    }
}