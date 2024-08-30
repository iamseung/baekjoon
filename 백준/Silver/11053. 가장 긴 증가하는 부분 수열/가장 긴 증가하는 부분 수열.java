import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
    }

    static void process() {
        int[] len = new int[N];
        for (int i = 0; i < N; i++) {
            len[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j])
                    len[i] = Math.max(len[i], len[j] + 1);
            }
        }

        int MAX = Arrays.stream(len)
                .max()
                .getAsInt();

        System.out.println(MAX);
    }
}