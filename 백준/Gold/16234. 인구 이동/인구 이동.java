import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {
    static class Group {
        int total;
        List<int[]> list = new ArrayList<>();

        Group(int total, List<int[]> list) {
            this.total = total;
            this.list = list;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, L, R, S;
    static int[][] arr;
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static List<int[]> group;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // LINE

        // 인구차이 L 명 이상, R 명 이하
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void process() {
        int index = 0;
        while (true) {
            boolean isOpen = false;
            group = new ArrayList<>();
            visit = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j]) {
                        S = 0;
                        group = new ArrayList<>();
                        findArr(j, i);

                        if (group.size() > 1) {
                            for (int[] g : group) {
                                arr[g[1]][g[0]] = S / group.size();
                            }

                            isOpen = true;
                        }
                    }
                }
            }

            if (!isOpen)
                break;

            index++;
        }

        System.out.println(index);
    }

    static void findArr(int x, int y) {
        group.add(new int[] { x, y });
        visit[y][x] = true;
        S += arr[y][x];

        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                continue;

            if (visit[ny][nx])
                continue;

            if (isPossilbe(arr[ny][nx] - arr[y][x])) {
                findArr(nx, ny);
            }
        }
    }

    static boolean isPossilbe(int value) {
        value = Math.abs(value);
        return L <= value && value <= R;
    }
}