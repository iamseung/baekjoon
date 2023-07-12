class Solution {
    public int solution(int n, int m, int[] section) {
        int cnt = 0;
        // 칠해야 할 구간 체크, true
        boolean[] paint = new boolean[n+1];
        for(int k : section) paint[k] = true;
        
        for(int i=1; i<=n; i++) {
            // 칠해져 있다면 pass
            if(!paint[i]) continue;
            
            for(int j=i; j<i+m; j++) {
                if(j > n) continue;
                paint[j] = false;
            }    
            cnt++;
        }
        
        return cnt;
    }
}