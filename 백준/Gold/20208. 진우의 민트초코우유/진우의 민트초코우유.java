import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Pair> milk;
    static int[] homeDist;
    static int N, H, M, len, result;
    static int sX, sY;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 초기 체력
        H = Integer.parseInt(st.nextToken()); // 마실 때마다 증가하는 체력의 양

        milk = new ArrayList<>();
        // Input
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) {
                    sX = j;
                    sY = i;
                } else if (val == 2) {
                    // 우유의 좌표
                    milk.add(new Pair(j, i));
                    len++;
                }
            }
        }
    }

    static void process() {
        homeDist = new int[len];
        for (int i = 0; i < len; i++) {
            Pair p = milk.get(i);
            homeDist[i] = getDist(sX, sY, p.x, p.y);
        }

        visited = new boolean[len];
        solve(sX, sY, M, 0);
        System.out.println(result);
    }

    static void solve(int x, int y, int move, int eatCount) {
        // 이미 최대값만큼 먹었거나 움직일 수 없는 경우
        if (result == len) {
            return;
        }

        for (int i = 0; i < milk.size(); i++) {
            Pair m = milk.get(i);
            int d = getDist(x, y, m.x, m.y);

            // 갈 수 없거나 먹은 적 있다면 넘어간다.
            if (d > move || visited[i]) {
                continue;
            }

            int nextMove = move - d + H;
            if (nextMove >= homeDist[i] && eatCount + 1 > result) {
                result = eatCount + 1;
            }

            visited[i] = true;
            solve(m.x, m.y, nextMove, eatCount + 1);
            visited[i] = false;
        }
    }

    private static int getDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}