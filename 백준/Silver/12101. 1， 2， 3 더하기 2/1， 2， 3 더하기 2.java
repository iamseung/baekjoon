import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N,K;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }

    public static void process(){
        dfs(0, "");
        System.out.println(-1);
    }

    static void dfs(int sum, String s) {
        if(sum > N)
            return;

        if(sum == N) {
            if(++cnt == K) {
                System.out.println(s.substring(1));
                System.exit(0);
            }
            
            return;
        }

        for(int i=1; i<=3; i++) {
            // System.out.println(s + "+"+ String.valueOf(i));
            dfs(sum + i, s + "+"+ String.valueOf(i));
        }
    }
}