class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = gcd(n,m);
        answer[1] = n*m / answer[0];
        
        return answer;
    }
    
    static int gcd(int p, int q) {
	    if(q==0) return p;
        
	    return gcd(q, p%q);					
	}
}