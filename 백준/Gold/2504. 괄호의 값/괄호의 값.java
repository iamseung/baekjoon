import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String str;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        str = br.readLine();
    }

    // () -> 2, [] -> 3
    static void process() {
        int len = str.length();
        int result = 0;
        int weight = 1;
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < len; ++i) {
            char c = str.charAt(i);
            if (isOpenCharacter(c)) {
                s.add(c);
                // 가중치를 곱해준다. ( 분배법칙 적용 )
                weight *= getWeight(c);
            } else {
                // 괄호열의 쌍이 맞다면, 식을 계산한다.
                if (!s.isEmpty() && isMatch(s.peek(), c)) {
                    if (c == ')') {
                        // 바로 직전이 여는 괄호열이였다면, 바로 숫자로 처리하여 계산
                        if (str.charAt(i - 1) == '(')
                            result += weight;

                        s.pop();
                        // 분배법칙이 함께 적용될 괄호가 종료되었음.
                        weight /= 2;
                    } else {
                        // 바로 직전이 여는 괄호열이였다면, 바로 숫자로 처리하여 계산
                        if (str.charAt(i - 1) == '[')
                            result += weight;

                        s.pop();
                        // 분배법칙이 함께 적용될 괄호가 종료되었음.
                        weight /= 3;
                    }
                } else { // 쌍이 안 맞는 경우 처리
                    result = 0;
                    break;
                }
            }
        }

        if (!s.isEmpty()) // 괄호열이 남았다. 올바르지 못한 괄호열이다.
            result = 0;

        System.out.println(result);
    }

    private static int getWeight(char c) {
        return c == '(' ? 2 : 3;
    }

    private static boolean isMatch(Character peek, char c) {
        if (peek == '(' && c == ')')
            return true;
        if (peek == '[' && c == ']')
            return true;
        return false;
    }

    private static boolean isOpenCharacter(char c) {
        return c == '(' || c == '[';
    }
}