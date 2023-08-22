import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int R,C,K,Count;
    static char[][] map;
    static boolean[][] visit;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main (String[] args) throws IOException {
        input();
        process();
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken()); // 세로
        C = Integer.parseInt(st.nextToken()); // 가로
        K = Integer.parseInt(st.nextToken()); // 길이

        map = new char[R][C];
        visit = new boolean[R][C];

        String str; 
        for(int i=0; i<R; i++) {
            str = br.readLine();
            for(int j=0; j<C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

    }

    public static void process() {
        // 시작지점 (0,2)
        // 도착지점 (3,0)
        DFS(0,R-1,1);
        System.out.println(Count);
    }

    public static void DFS(int x, int y, int length) {
        if(x == C-1 && y == 0 && length == K) {
            Count++;
            return;
        }
        visit[y][x] = true;

        for(int k=0; k<4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx<0 || ny<0 || nx>=C || ny>=R) continue;
            if(visit[ny][nx]) continue;
            if(map[ny][nx] == 'T')  continue;

            DFS(nx, ny, length+1);
            
            visit[ny][nx] = false;
        }

    }
}