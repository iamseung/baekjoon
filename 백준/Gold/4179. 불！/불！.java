import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int R,C;
    static char[][] map;
    static int[][] distF, distJ;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static Queue<Node> QF = new LinkedList<>(); // 불의 좌표
    static Queue<Node> QJ = new LinkedList<>(); // 지훈이 좌표
    
    public static void main(String[] args) throws IOException{
        input();
        process();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); // 행, 가로
        C = Integer.parseInt(st.nextToken()); // 열, 세로

        map = new char[R][C];
        distF = new int[R][C];
        distJ = new int[R][C];

        for(int i=0; i<R; i++) {
            String str = br.readLine();
            for(int j=0; j<C; j++) {
                map[i][j] = str.charAt(j);
                distF[i][j] = -1;// 불의 전파 시간
                distJ[i][j] = -1; // 지훈이의 이동 시간

                // 불좌표
                if(map[i][j] == 'F') {
                    QF.offer(new Node(i, j));
                    distF[i][j] = 0;
                }
                // 지훈이 좌표
                if(map[i][j] == 'J') {
                    QJ.offer(new Node(i, j));
                    distJ[i][j] = 0;
                }

            }
        }
    }

    static void process() {
        while (!QF.isEmpty()) {
            Node cur = QF.poll();

            for(int k=0; k<4; k++) {
                int nx = cur.X + dir[k][0];
                int ny = cur.Y + dir[k][1];

                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(distF[nx][ny] >= 0 || map[nx][ny] == '#') continue; // 불이 지나갔거나 벽은 예외처리

                distF[nx][ny] = distF[cur.X][cur.Y] + 1; // 거리 갱신, 현재 좌표에서 + 1
                QF.offer(new Node(nx, ny)); // 큐 갱신
            }
        }

        while (!QJ.isEmpty()) {
            Node cur = QJ.poll();

            for(int k=0; k<4; k++) {
                int nx = cur.X + dir[k][0];
                int ny = cur.Y + dir[k][1];

                // 지역을 벗어난 경우, 탈출
                if(nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    System.out.println(distJ[cur.X][cur.Y] + 1);
                    return;
                }

                // 지나갔거나 벽은 예외처리
                if(distJ[nx][ny] >= 0 || map[nx][ny] == '#') continue;

                // 불의 시간이 더 작은 경우는 해당 좌표에 더 빠르게 도착했단 의미, 예외처리
                // 불이 지나가지 않은 것도 감안해야 한다.
                if(distF[nx][ny] != -1 && (distF[nx][ny] <= distJ[cur.X][cur.Y] + 1)) continue;

                distJ[nx][ny] = distJ[cur.X][cur.Y] + 1; // 거리 갱신
                QJ.offer(new Node(nx, ny)); // 큐 갱신
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}

class Node {
    int X, Y;
    Node(int x, int y) {
        this.X = x;
        this.Y = y;
    }
}