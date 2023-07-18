class Solution {
    static boolean[][] area;
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        area = new boolean[n][n];
        
        for(int i=0; i<n; i++) {
            toBinary(arr1[i], n, i); toBinary(arr2[i], n, i);
        }
        
        String[] ans = new String[n];
        for(int i=0; i<n; i++) {
            ans[i] = "";
            for(int j=0; j<n; j++) {
                if(area[i][j])
                    ans[i] +="#";
                else
                    ans[i] +=" ";
            }
        }
        return ans;
    }
    
    /**
    * k : 10진수 수
    * size : 길이
    * index : area 데이터 접근을 위한 index 값
    */
    static void toBinary(int k, int size, int index) {
        String binary = "";
        for(int i=0; i<size; i++) {
            if((int) Math.pow(2, size-i-1) <= k) {
                area[index][i] = true;
                k -= (int) Math.pow(2, size-i-1);
            }
        }
    }
}