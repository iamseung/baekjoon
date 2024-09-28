import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int len = 10;
    static int MIN = Integer.MAX_VALUE;
    static int[][] map = new int[len][len];
    static int[] colorPaper = new int[6];

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        for (int i = 0; i < len; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < len; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void process() {
        Arrays.fill(colorPaper, 5);
        backTracking(0, 0, 0);
        System.out.println(MIN == Integer.MAX_VALUE ? -1 : MIN);
    }

    static void backTracking(int x, int y, int cnt) {
        if (x == 10 && y == 9) {
            MIN = Math.min(MIN, cnt);
            return;
        }

        if (x == len) {
            backTracking(0, y + 1, cnt);
            return;
        }

        if (cnt >= MIN)
            return;

        if (map[y][x] == 1) {
            // 덮을 수 있는 종이 사이즈를 구함
            for (int k = 5; k >= 1; k--) {
                if (colorPaper[k] > 0 && validation(x, y, k)) {
                    attach(x, y, k);
                    backTracking(x + 1, y, cnt + 1);
                    detach(x, y, k);
                }
            }
        } else {
            backTracking(x + 1, y, cnt);
        }
    }

    static boolean validation(int x, int y, int width) {
        for (int i = y; i < y + width; i++) {
            for (int j = x; j < x + width; j++) {
                if (i >= len || j >= len)
                    return false;

                if (map[i][j] == 0)
                    return false;
            }
        }

        return true;
    }

    // 색종이로 덮음
    static void attach(int x, int y, int width) {
        for (int i = y; i < y + width; i++) {
            for (int j = x; j < x + width; j++) {
                map[i][j] = 0;
            }
        }

        colorPaper[width]--;
    }

    // 원복
    static void detach(int x, int y, int width) {
        for (int i = y; i < y + width; i++) {
            for (int j = x; j < x + width; j++) {
                map[i][j] = 1;
            }
        }

        colorPaper[width]++;
    }
}