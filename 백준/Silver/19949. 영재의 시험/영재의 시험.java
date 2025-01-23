import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int len = 10;
    static int[] answer = new int[len];
    static int[] arr;
    static int[] numbers = IntStream.rangeClosed(1, 5).toArray();
    static long count = 0L;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++)
            answer[i] = Integer.parseInt(st.nextToken());
    }

    static void process() {
        arr = new int[len];
        backTracking(0, 0);
        System.out.println(count);
    }

    static void backTracking(int depth, int score) {
        // 모든 답안 선택 완료
        if (depth == len) {
            if (score >= 5)
                count++;

            return;
        }

        // 고르지 못할 수 확인
        int cantPickNumber = 0;

        if (depth >= 2) {
            if (arr[depth - 1] == arr[depth - 2])
                cantPickNumber = arr[depth - 1];
        }

        // 1번부터 5번까지의 선택지
        for (int n : numbers) {
            if (n == cantPickNumber)
                continue;

            arr[depth] = n;
            backTracking(depth + 1, score + ((answer[depth] == n) ? 1 : 0));
            arr[depth] = 0;
        }
    }
}