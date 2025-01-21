import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int C, max;
    static int[][] arr;
    static final int len = 11;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        C = Integer.parseInt(br.readLine());

        while (C-- > 0) {
            input();
            process();
        }
    }

    public static void input() throws IOException {
        arr = new int[len][len];
        for(int i=0; i<len; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<len; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void process(){
        max = -1;
        visited = new boolean[len];
        backTracking(0, 0);
        System.out.println(max);
    }

    public static void backTracking(int depth, int sum) {
        if(depth == len) {
            max = Math.max(max, sum);
            return;
        }

        for(int i=0; i<len; i++) {
            int v = arr[depth][i];

            if(v == 0 || visited[i])
                continue;

            visited[i] = true;
            backTracking(depth + 1, sum + v);
            visited[i] = false;
        }
    }
}