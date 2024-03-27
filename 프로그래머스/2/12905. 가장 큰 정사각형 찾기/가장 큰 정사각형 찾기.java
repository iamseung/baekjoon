class Solution
{
    static int X;
    static int Y;
    static int[][] map;
    
    public int solution(int [][]board)
    {
        X = board[0].length; Y = board.length;        
        map = new int[Y+1][X+1];
        
        int maxLen = 0;
        for(int i=1; i<=Y; i++) {
            for(int j=1; j<=X; j++) {
                if(board[i-1][j-1] != 0) {
                    // 좌측, 좌측상단대각선, 상측 중 가장 작은 값 + 1
                    int min = Math.min(Math.min(map[i - 1][j], map[i][j - 1]), map[i - 1][j - 1]);
                    map[i][j] = min + 1;

                    maxLen = Math.max(maxLen, min + 1);
                }
            }
        }


        return maxLen*maxLen;
    }
}