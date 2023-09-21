import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] wheels;
    static int K;
    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    public static void input() throws IOException {
        wheels = new int[4][8]; // 톱니바퀴 상태 입력
		for (int i = 0; i < 4; i++) {
			String s = br.readLine();
			for (int j = 0; j < 8; j++) {
				wheels[i][j] = s.charAt(j) - '0';
			}
		}

        K = Integer.parseInt(br.readLine());
    }

    public static void process() throws IOException {
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()) - 1;   // 회전할 톱니 번호
            int d = Integer.parseInt(st.nextToken());       // 회전 방향 ( 1 => 시계, -1 => 반시계)
            int isTurn[] = new int[4]; // 회전 여부 저장
            isTurn[n] = d;

            // 톱니바퀴 좌측 비교
            for (int j = 0; n != 0 && j < n; j++) {
                // 주어진 톱니바퀴와 방향을 기준으로 톱니바퀴 좌측 비교
                if (wheels[n - j][6] != wheels[n - j - 1][2])
                    // j가 짝수면 다른 방향, 홀수면 같은 방향
                    isTurn[n - j - 1] = j % 2 == 0 ? -d : d; 
                else
                    // 같은 극이면 움직이지 않움
                    break;
            }

            // 톱니바퀴 우측 비교
            for (int j = 0; n != 3 && j < 4 - n - 1; j++) {
                // 주어진 톱니바퀴와 방향을 기준으로 톱니바퀴 우측 비교
                if (wheels[n + j][2] != wheels[n + j + 1][6])
                    // j가 짝수면 다른 방향, 홀수면 같은 방향
                    isTurn[n + j + 1] = j % 2 == 0 ? -d : d;
                else
                    // 같은 극이면 움직이지 않움
                    break;
            }

            // 톱니바퀴 회전
            for (int j = 0; j < 4; j++) {
                // 시계방향 회전
                if(isTurn[j] == 1) 
                    goTurn(j);
                // 반시계방향 회전
                else if(isTurn[j] == -1) 
                    goBack(j);
            }
        }

        int result = 0;	// 점수
		for (int i = 0; i < 4; i++) {
			if(wheels[i][0] == 1)
				result += Math.pow(2, i);	// i번째 톱니바퀴 점수 : 2^i
		}

		System.out.println(result);
    }

    // 반시계방향
	private static void goBack(int n) {
		int temp = wheels[n][0];
		for (int i = 0; i <= 6; i++)
			wheels[n][i] = wheels[n][i + 1];
		wheels[n][7] = temp;
	}
 
	// 시계방향
	private static void goTurn(int n) {
		int temp = wheels[n][7];
		for (int i = 6; i >= 0; i--)
			wheels[n][i + 1] = wheels[n][i];
		wheels[n][0] = temp;
	}
}
