class Solution {
    public long solution(int r1, int r2) {
        long answer = (r2-r1+1)*4;
        long cir1 = (long) Math.pow(r1, 2);
        long cir2 = (long) Math.pow(r2, 2);
        
        for(int i=1; i<r2; i++) {
            double c2 = Math.floor(Math.sqrt(cir2 - Math.pow(i, 2)));
            double c1;
            if(i>=r1) 
                c1 = 1;
            else {
                c1 = Math.ceil(Math.sqrt(cir1 - Math.pow(i, 2)));
            }
            answer += (c2-c1+1)*4;
        }
        
        return answer;
    }
}