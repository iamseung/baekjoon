import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static char[][] map;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for(int i=0; i<N; i++) {
            String str = br.readLine();

            for(int j=0; j<N; j++)
                map[i][j] = str.charAt(j);
        }
    }

    // 1 이 흰방, 0 이 검은방 -> 통과못함
    public static void process(){
        // 방문여부
        boolean[][] visitied = new boolean[N][N];
        
        // 해당 좌표까지 최소로 벽을 부순 개수
        int[][] brokenCnt = new int[N][N];
        for(int i=0; i<N; i++)
            Arrays.fill(brokenCnt[i], N*N);

        Queue<Coordinate> que = new PriorityQueue<>();
        brokenCnt[0][0] = (map[0][0] == '0') ? 1 : 0;
        que.add(new Coordinate(0, 0, brokenCnt[0][0]));
        
        while (!que.isEmpty()) {
            Coordinate cur = que.poll();
            int curX = cur.x;
            int curY = cur.y;

            if(visitied[curY][curX])
                continue;
            
            visitied[curY][curX] = true;

            // 도착지
            if(curX == N-1 && curY == N-1) {
                System.out.println(cur.b);
                return;
            }

            for(int k=0; k<dir.length; k++) {
                int nx = curX + dir[k][0];
                int ny = curY + dir[k][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N)
                    continue;

                if(visitied[ny][nx])
                    continue;

                int willBreak = (map[ny][nx] == '0') ? 1 : 0;

                if(brokenCnt[ny][nx] > brokenCnt[curY][curX] + willBreak)
                    brokenCnt[ny][nx] = brokenCnt[curY][curX] + willBreak;

                que.add(new Coordinate(nx, ny, brokenCnt[ny][nx]));
            }
        }
    }
}

class Coordinate implements Comparable<Coordinate> {
    int x, y, b;

    public Coordinate(int x, int y, int b) {
        this.x = x;
        this.y = y;
        this.b = b;
    }

    // 허문 벽 개수의 오름차순
    @Override
    public int compareTo(Coordinate o) {
        return b - o.b;
    }
}