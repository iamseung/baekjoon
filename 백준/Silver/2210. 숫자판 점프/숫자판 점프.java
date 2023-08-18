import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int cnt = 0;
    static int[][] map = new int[5][5];
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    static HashSet<String> list = new HashSet<String>();
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    public static void input() throws IOException {
        StringTokenizer st;
        for(int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }   
        }
    }

    public static void pro() {
        String s = "";
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                DFS(i,j,0, s);
            }
        }
        
        System.out.println(list.size());
    }

    public static void DFS(int x, int y, int count, String s) {
        if(count == 6) {
            list.add(s);
            return;
        }
        else {
            for(int k=0; k<4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
    
                if(nx<0||ny<0||nx>=5||ny>=5) continue;

                DFS(nx, ny, count+1, s+map[y][x]);

            }
        }
    }
}