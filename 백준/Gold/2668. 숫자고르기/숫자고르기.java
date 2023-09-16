import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int N;
    static boolean[] visit;
    static ArrayList<Integer> ANS = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];

        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    public static void process() {
        for(int i=1; i<=N; i++) {
            visit = new boolean[N+1];

            DFS(i, i);
        }

        sb.append(ANS.size()+"\n");
        for(int K : ANS) sb.append(K+"\n");
        System.out.println(sb.toString());
    }

    public static void DFS(int start, int origin) {
        visit[start] = true;

        // 싸이클이 존재 
        if(arr[arr[start]] == origin) {
            ANS.add(origin);
            return;
        }

        if(!visit[arr[arr[start]]]) {
            DFS(arr[start], origin);
        }

    }
}