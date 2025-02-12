import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] cards, index, score;
    static final int len = 1_000_000;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        cards = new int[N + 1]; // 입력받는 카드
        score = new int[N + 1]; // 점수 계산
        index = new int[len + 1]; // 입력받는 카드의 index

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
            // 3 의 index 1, 4 의 index 4
            index[cards[i]] = i;
        }
    }

    // A 로 B 를 나누어 떨어지면 승리
    // A 가 B 로 나누어 떨어지면 패배
    // 나머지는 무승부
    static void process() {
        for (int i = 1; i <= N; i++) {
            // cards[i] 의 배수 순회
            for (int idx = cards[i] * 2; idx <= len; idx += cards[i]) {
                // 타인의 카드를 나눌 수 있는 경우
                if (index[idx] >= 1) {
                    // 타인은 - 1
                    score[index[idx]]--;
                    // 본인은 + 1
                    score[i]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++)
            sb.append(score[i] + " ");

        System.out.println(sb.toString());
    }
}