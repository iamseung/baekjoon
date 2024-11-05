import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, M, B;
    static int min = Integer.MAX_VALUE, max = -1;
    static int[][] area;
    static final int LIMIT = 256;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        area = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, area[i][j]);
                max = Math.max(max, area[i][j]);
            }
        }
    }

    public static void process() {
        int minSec = Integer.MAX_VALUE;
        int highBlock = 0;

        for (int i = min; i <= max; i++) {
            int second = 0;
            int block = B;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (i > area[j][k]) {
                        second += i - area[j][k];
                        block -= i - area[j][k];
                    } else if (i < area[j][k]) {
                        second += (area[j][k] - i) * 2;
                        block += area[j][k] - i;
                    }
                }
            }
            if (block < 0)
                continue;

            if (minSec >= second) {
                minSec = second;
                highBlock = Math.max(highBlock, i);
            }
        }

        System.out.println(minSec + " " + highBlock);
    }
}