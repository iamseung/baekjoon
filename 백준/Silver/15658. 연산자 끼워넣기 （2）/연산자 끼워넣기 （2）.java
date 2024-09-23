import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] numbers;
    static int[] odds = new int[4];

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++)
            numbers[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            odds[i] = Integer.parseInt(st.nextToken());
        }
    }

    // + - x /
    static void process() {
        backtracking(numbers[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    static void backtracking(int sum, int depth) {
        if (depth == N) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (odds[i] > 0) {
                odds[i]--;
                backtracking(calculate(sum, numbers[depth], transOdd(i)), depth + 1);
                odds[i]++;
            }
        }
    }

    static char transOdd(int i) {
        switch (i) {
            case 0:
                return '+';
            case 1:
                return '-';
            case 2:
                return 'x';
            case 3:
                return '/';
        }

        return '0';
    }

    static int calculate(int a, int b, char c) {
        switch (c) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case 'x':
                return a * b;
            case '/':
                return a / b;
        }

        return -1;
    }
}