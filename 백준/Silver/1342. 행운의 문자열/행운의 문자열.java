import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] alpha = new int[27];
    static int len;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    public static void input() throws IOException {
        String str = br.readLine();
        len = str.length();

        // 알파벳 개수 카운팅
        for(char c : str.toCharArray())
            alpha[c - 'a']++;
    }

    public static void process(){
        dfs(0, ' ');
        System.out.println(cnt);
    }

    public static void dfs(int depth, char c) {
        // 문자열 완성
        if(depth == len) {
            cnt++;
            return;
        }

        for(int i=0; i<27; i++) {
            if(alpha[i] == 0)
                continue;

            // 이전 문자와 같지 않은 경우
            if(c != (char) (i + 'a')) {
                alpha[i]--;
                dfs(depth+1, (char) (i + 'a'));
                alpha[i]++;
            }
            
        }
    }
}