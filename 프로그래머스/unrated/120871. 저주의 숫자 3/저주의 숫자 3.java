class Solution {
    static int[] arr = new int[101];
    public int solution(int n) {
        makeArr();
        
        return arr[n];
    }
    
    static void makeArr() {
        int index = 1;
        for(int i=1; i<=100; i++) {
            while(index%3 == 0 || Integer.toString(index).contains("3")) index++;
            
            arr[i] = index;
            index++;
        }
    }
}