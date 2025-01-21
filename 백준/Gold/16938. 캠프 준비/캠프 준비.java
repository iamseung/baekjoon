import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, L, R, X, cnt = 0;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    /*
    문제 난이도의 합은 L보다 크거나 같고, R보다 작거나 같아야 한다.
    가장 어려운 문제와 가장 쉬운 문제의 난이도 차이는 X보다 크거나 같아야 한다.
    */
    public static void process(){
        visited = new boolean[N];
        backTracking(0,0,Integer.MIN_VALUE,Integer.MAX_VALUE,0);
        System.out.println(cnt);
    }

    public static void backTracking(int depth, int selected, int maxV, int minV, int sumV) {
        if(depth > 1) {
            if(sumV >= L && sumV <= R && (maxV - minV >= X))
                cnt++;
        }

        for(int i=depth; i<N; i++) {
            if(visited[i])
                continue;

            visited[i] = true;
            backTracking(i+1, selected+1, Math.max(maxV, arr[i]), Math.min(minV, arr[i]), sumV + arr[i]);
            visited[i] = false;
        }
    }
}