import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int LEN = 9;
    static int[][] arr = new int[LEN][LEN];

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        StringTokenizer st;

        for (int i = 0; i < LEN; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < LEN; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void process() {
        sudoku(0, 0);
    }

    static void sudoku(int x, int y) {
        // 해당 열의 행을 모두 조회 했으면 열 + 1
        if (x == LEN) {
            sudoku(0, y + 1);
            return;
        }

        // 9 X 9 를 모두 탐색했으면 출력
        if (y == LEN) {
            for (int i = 0; i < LEN; i++) {
                for (int j = 0; j < LEN; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }

            System.exit(0);
        }

        // 비어있는 구간이면 탐색 시작
        if (arr[y][x] == 0) {
            // 1 - 9 까지 비교, 가능하다면 재귀 호출
            for (int i = 1; i <= LEN; i++) {
                if (isPossible(x, y, i)) {
                    arr[y][x] = i;
                    sudoku(x + 1, y);
                }
            }

            arr[y][x] = 0;
            return;
        }

        // 다음 행 재귀 호출
        sudoku(x + 1, y);
    }

    static boolean isPossible(int x, int y, int value) {
        for (int i = 0; i < LEN; i++) {
            // 행 조회
            if (arr[y][i] == value)
                return false;
            // 열 조회
            if (arr[i][x] == value)
                return false;
        }

        // 3 X 3 그룹 조회
        int groupX = (x / 3) * 3;
        int groupY = (y / 3) * 3;

        for (int i = groupY; i < groupY + 3; i++) {
            for (int j = groupX; j < groupX + 3; j++) {
                if (arr[i][j] == value)
                    return false;
            }
        }

        return true;
    }
}