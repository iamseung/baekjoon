import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

    }

    static void process() {
        Arrays.sort(arr);
        int start = 0, end = arr.length - 1;
        int sum = 0, cnt = 0;

        while (start < end) {
            sum = arr[start] + arr[end];

            if (sum < M) {
                start++;
            } else if (sum > M) {
                end--;
            } else {
                start++;
                end--;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}