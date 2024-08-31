import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, S;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

    }

    static void process() {
        int len = N + 1;
        int sum = 0;

        for (int l = 1, r = 0; l <= N; l++) {
            sum -= arr[l - 1];

            while (r + 1 <= N && sum < S) {
                sum += arr[++r];
            }

            if (sum >= S) {
                len = Math.min(r - l + 1, len);
            }
        }

        if (len == N + 1)
            len = 0;

        System.out.println(len);
    }
}