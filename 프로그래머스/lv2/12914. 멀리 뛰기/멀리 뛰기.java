class Solution {
    static int[] arr;
    public long solution(int n) {
        long answer = 0;
        arr = new int[2001];
        
        makeArray();
        return arr[n];
    }
    
    static void makeArray() {
        arr[1] = 1;
        arr[2] = 2;
        
        for(int i=3; i<=2000; i++) {
            arr[i] = (arr[i-1] + arr[i-2])%1234567;
        }
    }
}