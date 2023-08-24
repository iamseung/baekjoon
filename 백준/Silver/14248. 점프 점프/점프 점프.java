import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,start,C = 1;
    static int[] area;
    static boolean[] visit;
    
    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        area = new int[N+1];
        visit = new boolean[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++) area[i] = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());
    }

    public static void process() {
        DFS(start);

        System.out.println(C);
    }

    // start => index
    public static void DFS(int start) {
        visit[start] = true;

        int plus = start + area[start];
        int minus = start - area[start];

        if(plus <= N && !visit[plus]) {
            visit[plus] = true;
            DFS(plus);
            C++;
        }

        if(minus >= 1 && !visit[minus]) {
            visit[minus] = true;
            DFS(minus);
            C++;
        }
    }
}
