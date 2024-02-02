import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String target;
    static String bomb;
    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException {
        target = br.readLine();
        bomb = br.readLine();
    }

    static void process() {
        Stack<Character> st = new Stack<>();
        int bombSize = bomb.length();

        for(char c : target.toCharArray()) {
            st.push(c);

            // 폭발 문자열의 길이가 같아지면 탐색
            if(st.size() >=bombSize) {
                boolean flag = true;

                // 문자열 비교
                for(int j=0; j<bombSize; j++) {
                    if(st.get(st.size()-bombSize+j) != bomb.charAt(j)) {
                        flag =false;
                        break;
                    }
                }

                // 문자열 삭제
                if(flag) {
                    for(int t=0; t<bombSize; t++) st.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Character c : st) sb.append(c);

        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}