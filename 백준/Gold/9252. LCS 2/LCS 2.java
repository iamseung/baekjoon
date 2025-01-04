import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String A, B;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        A = br.readLine();
        B = br.readLine();
    }

    static void process() {
        int aLen = A.length();
        int bLen = B.length();

        int[][] dp = new int[aLen + 1][bLen + 1];

        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[aLen][bLen]);

        if (dp[aLen][bLen] != 0) {
            Stack<Character> st = new Stack<>();
            while (aLen > 0 && bLen > 0) {
                if (aLen == 0 || bLen == 0)
                    break;

                if (dp[aLen][bLen] == dp[aLen - 1][bLen]) {
                    aLen--;
                } else if (dp[aLen][bLen] == dp[aLen][bLen - 1]) {
                    bLen--;
                } else {
                    st.push(A.charAt(aLen - 1));
                    aLen--;
                    bLen--;
                }

            }

            while (!st.isEmpty()) {
                System.out.print(st.pop());
            }
        }
    }
}