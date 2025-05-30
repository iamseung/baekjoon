import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static final int MOD = 1_000_000_000;

    public static void main(String args[]) throws IOException {
        input();
        process();
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    public static void process() {
        if (N < 0 && N % 2 == 0) {
            System.out.println("-1");
        } else if (N == 0) {
            System.out.println("0");
        } else {
            System.out.println("1");
        }

        N = Math.abs(N);

        long[] fibo = new long[N + 2];
        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= N; i++) {
            fibo[i] = (fibo[i - 1] % MOD + fibo[i - 2] % MOD) % MOD;
        }

        System.out.println(fibo[N]);
    }
}