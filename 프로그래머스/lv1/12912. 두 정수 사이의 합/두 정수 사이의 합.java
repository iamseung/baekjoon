class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        if(a-b == 0) return (long)a;
        
        int max = 0, min = 0;
        if(a >= b) {
            max = a; min = b;
        } else {
            max = b; min = a;
        }
        
        for(int i=min; i<=max; i++) answer += (long)i;
        return answer;
    }
}