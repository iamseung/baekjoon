import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int X, Y;
    static int[][] tomato, dist;
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        tomato = new int[Y][X];

        for (int i = 0; i < Y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < X; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void process() {
        // 거리 계산
        BFS();

        int time = Integer.MIN_VALUE;

        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (tomato[i][j] == -1)
                    continue;
                if (dist[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }

                time = Math.max(time, dist[i][j]);
            }
        }

        System.out.println(time);
    }

    static void BFS() {
        Queue<int[]> queue = new LinkedList<>();
        dist = new int[Y][X];

        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                dist[i][j] = -1;

                if (tomato[i][j] == 1) {
                    queue.add(new int[] { j, i });
                    dist[i][j] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] q = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = q[0] + dir[k][0];
                int ny = q[1] + dir[k][1];

                if (nx < 0 || ny < 0 || nx >= X || ny >= Y)
                    continue;
                if (dist[ny][nx] != -1)
                    continue;
                if (tomato[ny][nx] == -1)
                    continue;

                dist[ny][nx] = dist[q[1]][q[0]] + 1;
                queue.add(new int[] { nx, ny });
            }
        }
    }

    static void print() {
        System.out.println("--------------------------");
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}