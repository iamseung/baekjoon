import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] numbers;
    static int[] odds = new int[4];
    static char[] ops; // 정해진 부호들
    static int N;
    static int MAX = Integer.MIN_VALUE, MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            numbers[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++)
            odds[i] = Integer.parseInt(st.nextToken());
    }

    static void process() {
        ops = new char[N - 1];

        backTracking(0);
        System.out.println(MAX);
        System.out.println(MIN);

    }

    static void backTracking(int k) {
        if (k == N - 1) {
            cal();
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (odds[i] > 0) {
                odds[i]--;
                ops[k] = transOdd(i);
                backTracking(k + 1);
                odds[i]++;
            }
        }
    }

    static void cal() {
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        stack.push(numbers[0]);

        // 결정된 부호를 기반으로 계산
        for (int i = 0; i < N - 1; i++) {
            switch (ops[i]) {
                case '+':
                    stack.push(numbers[i + 1]);
                    break;
                case '-':
                    stack.push(numbers[i + 1] * -1);
                    break;
                // 곱셈과 나눗셈의 경우에는 직전에 넣은 수를 먼저 계산하고 Push
                case '*':
                    stack.push(stack.pop() * numbers[i + 1]);
                    break;
                case '/':
                    stack.push(stack.pop() / numbers[i + 1]);
                    break;
                default:
                    break;
            }
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        MAX = Math.max(MAX, result);
        MIN = Math.min(MIN, result);
    }

    static char transOdd(int idx) {
        char c = ' ';
        switch (idx) {
            case 0:
                c = '+';
                break;
            case 1:
                c = '-';
                break;
            case 2:
                c = '*';
                break;
            case 3:
                c = '/';
                break;
        }

        return c;
    }
}