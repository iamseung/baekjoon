class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] people = new int[n+1];
        
        for(int q : reserve) people[q] = 1;
        for(int k : lost) people[k]--;
        
        for(int i=1; i<=n; i++) {
            if(people[i] == -1) {
                // 좌측
                if(i-1>=1 && people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                }
                // 우측
                else if(i+1 <=n && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                } 
            }
        }
        
        for(int p : people) if(p >= 0) answer++;
        
        return answer-1;
    }
}