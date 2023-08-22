import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,M,startX,startY,C;
    static char[][] area;
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    static boolean[][] visit;

    public static void main (String[] args) throws IOException {
        input();
        process();
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // Y
        M = Integer.parseInt(st.nextToken()); // X

        area = new char[N][M];
        visit = new boolean[N][M];

        String str;
        for(int i=0; i<N; i++) {
            str = br.readLine();
            for(int j=0; j<M; j++) {
                area[i][j] = str.charAt(j);

                // 도연이의 위치
                if(area[i][j] == 'I') {
                    startX = j; startY = i;
                }
            }
        }
    }

    public static void process() {
       DFS(startX, startY);

       System.out.println((C==0)?"TT":C);
    }

    public static void DFS(int x, int y) {
        visit[y][x] = true;

        for(int k=0; k<4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx<0||ny<0||nx>=M||ny>=N) continue;
            if(visit[ny][nx]) continue;
            if(area[ny][nx] == 'X') continue;

            if(area[ny][nx] == 'P') C++;

            DFS(nx, ny);
        }
        
    }
}