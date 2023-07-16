class Solution {
    static int[] arr = new int[1001];
    public int solution(int left, int right) {
        Make();
        int answer = 0;
        for(int i=left; i<=right; i++) answer += arr[i];
        return answer;
    }
    
    static void Make() {
        for(int i=1; i<=1000; i++) {
            for(int j=1; j<=i/2; j++) {
                if(i%j ==0) arr[i]++;
            }
            
            arr[i] = (arr[i]%2 != 0) ? i : i*-1; 
        }
    }
}