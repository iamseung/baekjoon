import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long K, P, N;
    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken()); // 처음 바이러스 수
        P = Integer.parseInt(st.nextToken()); // P 배씩 증가
        N = Integer.parseInt(st.nextToken()); // 초
    }

    static void process() {
        long answer =K;

        while (N-- > 0) {
            answer = (answer * P) % 1000000007;
        }

        System.out.println(answer);
    }   
}