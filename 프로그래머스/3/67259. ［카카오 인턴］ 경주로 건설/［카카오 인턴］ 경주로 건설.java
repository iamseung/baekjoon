import java.util.*;
class Solution {
    
    class Pos {
        int x;
        int y;
        int sum; // 누적 비용
        int dir; // 0:상, 1:하, 2:좌, 3:우
        
        Pos(int y, int x, int sum, int dir) {
            this.x = x;
            this.y = y;
            this.sum = sum;
            this.dir = dir;
        }
        
    }
    
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int cost[][][] = new int[board.length][board.length][4]; // [y][x][dir]
        
        int[] dx = {0, 0, -1, 1}; // dx[dir] : dir 방향 좌표 갱신
        int[] dy = {-1, 1, 0, 0}; // dy[dir] : dir 방향 좌표 갱신
        
        // cost[i][j][dir] 위치 최대 비용 갱신
        for(int i=0; i<cost.length; i++) {
            for(int j=0; j<cost[i].length; j++) {
                Arrays.fill(cost[i][j], 987654321);
            }
        }
        
        // 시작 좌표에서 하, 우로만 시작 가능 [0][0][1], [0][0][3]
        Stack<Pos> s = new Stack<>();
        s.push(new Pos(0,0,0,1));
        s.push(new Pos(0,0,0,3));
        
        while(!s.empty()) {
            Pos pos = s.pop();
            int y = pos.y;
            int x = pos.x;
            int sum = pos.sum;
            int dir = pos.dir;
            
            // 우측 하단 도착
            if(y == board.length-1 && x == board.length-1) {
                answer = Math.min(answer, sum); // 최소 비용으로 갱신
                continue;
            }
            
            // 4방향으로 좌표 이동 시켜봄
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx>=0 && nx<board.length && ny>=0 && ny<board.length && board[ny][nx] == 0) {
                    // i 방향으로 이동하는데 현재 방향과 동일하다면
                    if(i == dir && sum + 100 < cost[ny][nx][i]) {
                        cost[ny][nx][i] = sum + 100;
                        s.push(new Pos(ny, nx, sum+100, i));
                    } else if (i != dir && sum + 600 < cost[ny][nx][i]) { // 현재 방향과 다르다면 비용 600
                        cost[ny][nx][i] = sum + 600;
                        s.push(new Pos(ny, nx, sum+600, i));
                    }
                }
            }
            
        }        
        
        return answer;
    }
}