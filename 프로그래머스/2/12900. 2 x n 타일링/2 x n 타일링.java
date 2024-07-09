class Solution {
    static final int mod = 1000000007;
    
    public int solution(int n) {
        int[] arr = new int[n+1];

        arr[1] = 1;
        arr[2] = 2;

        for(int i=3; i<=n; i++)
            arr[i] = (arr[i-1] + arr[i-2])%1000000007;
        
        return arr[n];
    }
}