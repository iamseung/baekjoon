class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int A = arr1.length;
        int B = arr1[0].length;
        
        int[][] answer = new int[A][B];
        
        for(int i=0; i<A; i++) {
            for(int j=0; j<B; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }
}