import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static final int COUNTRY_CNT = 6;
    static final int RESULT_CNT = 3;
    static final int LEN = 4;
    static int[][] play = new int[COUNTRY_CNT][RESULT_CNT];
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        input();
    }

    static void input() throws Exception {
        StringTokenizer st;
        for (int i = 0; i < LEN; i++) {
            answer = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < COUNTRY_CNT * RESULT_CNT; j++)
                play[j / 3][j % 3] = Integer.parseInt(st.nextToken());

            boolean flag = false;

            for (int j = 0; j < COUNTRY_CNT; j++) {
                if (isNotPredictableResult(j)) {
                    flag = true;
                    break;
                }
            }

            if (!flag)
                search(0, 1);

            sb.append(answer).append(" ");
        }

        System.out.println(sb.toString());
    }

    static void search(int idx, int nxt) {
        if (answer == 1) // 해당 결과가 올바른 것일 때 재귀 종료!
            return;
        // F국가까지 올바르게 경기가 진행되었을 때
        if (idx == 5) {
            answer = 1;
            return;
        }
        // 현재 국가가 상대 국가에게 이겼을 때
        if (play[idx][0] > 0 && play[nxt][2] > 0) {
            play[idx][0]--;
            play[nxt][2]--;
            if (nxt == 5) { // 현재 국가 탐색 완료
                search(idx + 1, idx + 2);
            } else
                search(idx, nxt + 1);
            play[idx][0]++;
            play[nxt][2]++;
        }
        // 현재 국가와 상대 국가가 무승부 했을 때
        if (play[idx][1] > 0 && play[nxt][1] > 0) {
            play[idx][1]--;
            play[nxt][1]--;
            if (nxt == 5) { // 현재 국가 탐색 완료
                search(idx + 1, idx + 2);
            } else
                search(idx, nxt + 1);
            play[idx][1]++;
            play[nxt][1]++;
        }
        // 현재 국가가 상대 국가에게 패배하였을 때
        if (play[idx][2] > 0 && play[nxt][0] > 0) {
            play[idx][2]--;
            play[nxt][0]--;
            if (nxt == 5) { // 현재 국가 탐색 완료
                search(idx + 1, idx + 2);
            } else
                search(idx, nxt + 1);
            play[idx][2]++;
            play[nxt][0]++;
        }
    }

    static boolean isNotPredictableResult(int idx) {
        return play[idx][0] + play[idx][1] + play[idx][2] != 5;
    }
}