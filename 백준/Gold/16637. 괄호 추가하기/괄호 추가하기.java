import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static List<Character> ops = new ArrayList<>();
    static List<Integer> nums = new ArrayList<>();
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        for (char c : input.toCharArray()) {
            if (isOps(c)) {
                ops.add(c);
                continue;
            }

            nums.add(c - '0');
        }
    }

    static boolean isOps(char c) {
        return c == '+' || c == '-' || c == '*';
    }

    static void process() {
        DFS(nums.get(0), 0);
        System.out.println(answer);
    }

    static void DFS(int result, int opIdx) {
        if (opIdx >= ops.size()) {
            answer = Math.max(result, answer);
            return;
        }

        // 1. 괄호가 없는 경우
        int res1 = calculate(ops.get(opIdx), result, nums.get(opIdx + 1));
        DFS(res1, opIdx + 1);

        // 2. 괄호가 있는 경우
        if (opIdx + 1 < ops.size()) {
            // result의 오른쪽에 있는 값을 연산함.
            int res2 = calculate(ops.get(opIdx + 1), nums.get(opIdx + 1), nums.get(opIdx + 2));

            // 현재 result와 방금 구한 괄호 값을 연산한 결과와 괄호 오른쪽에 존재하는 연산자의 인덱스를 넘김.
            DFS(calculate(ops.get(opIdx), result, res2), opIdx + 2);
        }
    }

    static int calculate(char ops, int v1, int v2) {
        switch (ops) {
            case '+':
                return v1 + v2;
            case '-':
                return v1 - v2;
            case '*':
                return v1 * v2;
        }
        return -1;
    }
}