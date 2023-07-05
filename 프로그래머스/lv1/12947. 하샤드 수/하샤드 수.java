class Solution {
    public boolean solution(int x) {
        int N = 0;
        int origin = x;
        
        while(x>0) {
            N += x%10;
            x /= 10;
        }
        
        if(origin%N == 0) return true;
            
        return false;
    }
}