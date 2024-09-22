import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[][] map;
    static List<Point> person;
    static List<Point> chicken;
    static int ans;
    static boolean[] open;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 최대 M 개의 치킨집을 선택

        map = new int[N][N];
        person = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    person.add(new Point(j, i));
                }

                if (map[i][j] == 2) {
                    chicken.add(new Point(j, i));
                }
            }
        }
    }

    // 0 -> 빈칸, 1 -> 집, 2 -> 치킨집
    static void process() {
        ans = Integer.MAX_VALUE;
        open = new boolean[chicken.size()];
        DFS(0, 0);
        System.out.println(ans);
    }

    static void DFS(int start, int cnt) {
        if (cnt == M) {
            int res = 0;

            // 사람 개개인 마다의 최소 치킨 거리를 갱신
            for (int i = 0; i < person.size(); i++) {
                int temp = Integer.MAX_VALUE;

                for (int j = 0; j < chicken.size(); j++) {
                    if (open[j]) {
                        int distance = calDistance(person.get(i).x, person.get(i).y,
                                chicken.get(j).x, chicken.get(j).y);

                        temp = Math.min(temp, distance);
                    }
                }

                res += temp;
            }

            ans = Math.min(ans, res);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            open[i] = true;
            DFS(i + 1, cnt + 1);
            open[i] = false;
        }
    }

    static int calDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}