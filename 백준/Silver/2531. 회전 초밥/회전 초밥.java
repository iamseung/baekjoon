import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, D, K, C;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 접시의 수
        D = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
        K = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        C = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        arr = new int[N + K - 1];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        // K-1 개 만큼 이어서 붙여서 마지막 경우의 수도 검증
        for (int i = 0; i < K - 1; i++)
            arr[N++] = arr[i];
    }

    static void process() {
        int[] eaten = new int[D + 1];
        int max = 1; // 쿠폰으로 먹었을 경우
        eaten[C] += 1;

        // 슬라이딩 윈도우의 첫 부문
        int start = 0;
        for (int i = start; i < K; i++) {
            // 먹은 적이 없다면 가짓수 갱신
            if (eaten[arr[i]] == 0)
                max++;

            // 가짓수 카운트
            eaten[arr[i]]++;
        }

        // 윈도우 이동
        start = 0;

        int result = max;

        for (int i = K; i < arr.length; i++) {
            eaten[arr[start]] -= 1;

            // 가짓수가 줄었다면 차감
            if (eaten[arr[start]] == 0)
                result -= 1;

            // 가짓수가 늘었다면 갱신
            if (eaten[arr[i]] == 0)
                result += 1;

            eaten[arr[i]]++;

            max = Math.max(max, result);
            start++;
        }

        System.out.println(max);
    }
}