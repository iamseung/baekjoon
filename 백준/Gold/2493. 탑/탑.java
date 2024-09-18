import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int top = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty()) {
                // value 비교, 이전 값이 더 크다면 레이저 수신이 가능함
                if (stack.peek()[1] >= top) {
                    sb.append(stack.peek()[0] + " ");
                    break;
                }

                stack.pop();
            }

            // 송신할 탑이 없는 경우 0
            if (stack.isEmpty()) {
                sb.append("0 ");
            }

            stack.push(new int[] { i, top });
        }
    }

    static void process() {
        System.out.println(sb.toString());
    }
}