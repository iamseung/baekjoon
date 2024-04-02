import java.util.*;

class Solution {
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static int[][] ditT = {{1,1},{1,-1},{-1,1},{-1,-1}};
    static char[][] room;
    static final int waitingRoom = 5;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[waitingRoom];
        for(int i=0; i<waitingRoom; i++)
            answer[i] = simulate(places[i]);
        return answer;
    }
    
    static int simulate(String[] place) {
        // 응시자 좌표
        Queue<int[]> people = new LinkedList<>();

        // 매핑
        room = new char[waitingRoom][waitingRoom];
        for(int i=0; i<waitingRoom; i++) {
            for(int j=0; j<waitingRoom; j++) {
                room[i][j] = place[i].charAt(j);
                if(room[i][j] == 'P') people.add(new int[]{j,i});
            }
        }

        while(!people.isEmpty()) {
            int[] p = people.poll();

            if(direct(p[0], p[1])) 
                return 0;

            if(near(p[0], p[1]))
                return 0;
        }

        return 1;
    }

    // 붙어있는 경우 체크
    static boolean direct(int x, int y) {
        for(int k=0; k<4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx<0||ny<0||nx>=waitingRoom||ny>=waitingRoom) continue;
            if(room[ny][nx] == 'P') return true;
            
            // 빈 테이블일 경우
            if(room[ny][nx] == 'O') {
                int nnx = nx + dir[k][0];
                int nny = ny + dir[k][1];

                if(nnx<0||nny<0||nnx>=waitingRoom||nny>=waitingRoom) continue;
                if(room[nny][nnx] == 'P') 
                    return true;
            }   

        }

        return false;
    }

    // 대각선에 있는 경우 체크
    static boolean near(int x, int y) {
        for(int k=0; k<4; k++) {
            int nx = x + ditT[k][0];
            int ny = y + ditT[k][1];

            if(nx<0||ny<0||nx>=waitingRoom||ny>=waitingRoom) continue;
            // 대각선에 사람이 있는 경우, 빈 테이블 확인
            if(room[ny][nx] == 'P') {
                if(room[ny][x] == 'P' || room[ny][x] == 'O' || room[y][nx] == 'P' || room[y][nx] == 'O')
                    return true;
            }

        }

        return false;
    }
}