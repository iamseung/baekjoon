import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int len = 5;
    static final int limit = 7;
    static final int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static char[][] arr = new char[len][len];
    static boolean[] visited;
    static int[] selected = new int[limit];
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        for (int i = 0; i < len; i++) {
            String str = br.readLine();
            for (int j = 0; j < len; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
    }

    // S -> 이다솜, Y -> 임도연
    // S 가 적어도 4명 이상 반드시 포함, 7명
    static void process() {
        backTracking(0, 0, 0);
        System.out.println(cnt);
    }

    // numY -> Y 의 수
    static void backTracking(int depth, int numY, int start) {
        // 적어도 S 가 4명 이상, Y가 4 이상이 될 경우를 제외
        if (numY >= 4)
            return;

        if (depth == limit) {
            visited = new boolean[7];
            BFS();
            return;
        }

        // 5개의 Row 를 25 의 Index 로 표기
        for (int i = start; i < len * len; i++) {
            selected[depth] = i;

            // i/5 = y, i%5 = x
            if (arr[i / 5][i % 5] == 'Y') {
                backTracking(depth + 1, numY + 1, i + 1);
            } else {
                backTracking(depth + 1, numY, i + 1);
            }
        }
    }

    static void BFS() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { selected[0] / 5, selected[0] % 5 });
        visited[0] = true;
        int conn = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                int next = ny * 5 + nx;

                if (nx < 0 || ny < 0 || nx >= len || ny >= len)
                    continue;

                // 선택된 7 명의 사람이 현재 좌표에서 연결되어 있는지 검증
                for (int j = 0; j < limit; j++) {
                    if (!visited[j] && selected[j] == next) {
                        q.add(new int[] { ny, nx });
                        visited[j] = true;
                        conn++;
                    }
                }
            }
        }

        if (conn == 7)
            cnt++;
    }

}