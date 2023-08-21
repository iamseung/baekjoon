import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, B, W;
    static char[][] map;
    static boolean[][] visit;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] agrs) throws IOException {
        input();
        process();
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 가로
        M = Integer.parseInt(st.nextToken()); // 세로

        map = new char[M][N];
        visit = new boolean[M][N];

        String str;
        for(int i=0; i<M; i++) {
            str = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        B = W = 0;
    }

    public static void process() {
        int count;
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(!visit[i][j]) {
                    addCount(map[i][j], BFS(j,i, map[i][j]));
                }
            }
        }

        System.out.println(W+" "+B);
    }

    public static int BFS(int startX, int startY, char C) {
        int cnt = 1;
        visit[startY][startX] = true;

        Queue<Integer> que = new LinkedList<>();
        que.add(startX);
        que.add(startY);

        int x,y,nx,ny;
        while(!que.isEmpty()) {
            x = que.poll();
            y = que.poll();
            
            for(int k=0;k<4;k++) {
                nx = x + dir[k][0];
                ny = y + dir[k][1];

                if(nx<0||ny<0||nx>=N||ny>=M) continue;
                if(visit[ny][nx]) continue;
                if(map[ny][nx] != C) continue;

                cnt++;
                visit[ny][nx] = true;
                que.add(nx);
                que.add(ny);
            }
        }

        return cnt;
    }

    public static void addCount(char C, int count) {
        count = (int)Math.pow(count,2);
        if(C == 'B')
            B += count;
        else
            W += count;
    }
}