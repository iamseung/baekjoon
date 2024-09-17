import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int T, N;
    static String[] strs;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();
            process();
        }

        System.out.println(sb.toString());
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        strs = new String[N];
        for (int i = 0; i < N; i++)
            strs[i] = br.readLine();
    }

    static void process() {
        Arrays.sort(strs, (a, b) -> a.compareTo(b));

        boolean isCollect = true;
        for (int i = 1; i < N; i++) {
            if (strs[i].startsWith(strs[i - 1])) {
                isCollect = false;
                break;
            }

        }

        sb.append(isCollect ? "YES" : "NO").append("\n");
    }
}