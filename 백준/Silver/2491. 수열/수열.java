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
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
    }

    static void process() {
        int[] longest = new int[N + 1];
        int[] shortest = new int[N + 1];

        // 최장 증가 수열
        for (int i = 1; i <= N; i++) {
            longest[i] = 1;
            shortest[i] = 1;

            int j = i - 1;
            if (arr[i] >= arr[j])
                longest[i] = Math.max(longest[i], longest[j] + 1);

            if (arr[i] <= arr[j])
                shortest[i] = Math.max(shortest[i], shortest[j] + 1);
        }

        int longLen = Arrays.stream(longest).max().getAsInt();
        int shortLen = Arrays.stream(shortest).max().getAsInt();

        int answer = longLen > shortLen ? longLen : shortLen;
        System.out.println(answer);
    }
}