import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static String A, B;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    public static void input() throws IOException {
        A = br.readLine();
        B = br.readLine();
    }

    public static void process() {
        int aLen = A.length();
        int bLen = B.length();
        int max = 0;

        int[][] dp = new int[aLen + 1][bLen + 1];

        for (int a = 1; a <= aLen; a++) {
            for (int b = 1; b <= bLen; b++) {
                if (A.charAt(a - 1) == B.charAt(b - 1)) {
                    dp[a][b] = dp[a - 1][b - 1] + 1;
                    max = Math.max(dp[a][b], max);
                }
            }
        }

        System.out.println(max);
    }
}