import java.util.*;

class Solution {
    static int [][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public int solution(String[][] board, int h, int w) {
        int N = board.length;
        int ANS = 0;
        
        for(int k=0; k<4; k++) {
            int nx = w + dir[k][0];
            int ny = h + dir[k][1];
            
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(board[h][w].equals(board[ny][nx])) ANS++;
        }
        
        return ANS;
    }
}