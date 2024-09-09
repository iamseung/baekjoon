import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] primeArr = { 2, 3, 5, 7 };
    static int[] odd = { 1, 3, 5, 7, 9 };
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
    }

    static void process() {
        for (int p : primeArr)
            dfs(1, p);

        System.out.println(sb.toString());
    }

    static void dfs(int depth, int value) {
        if (isPrime(value))
            return;

        if (depth == N) {
            sb.append(value).append("\n");
            return;
        }

        for (int cur = 0; cur < odd.length; cur++) {
            dfs(depth + 1, value * 10 + odd[cur]);
        }
    }

    static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return true;
        return false;
    }
}