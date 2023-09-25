import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int M, N;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static boolean FLAG;
    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    public static void input() throws IOException {
        M = Integer.parseInt(br.readLine());

        adj = new ArrayList[26];
        for(int i=0; i<26; i++) 
            adj[i] = new ArrayList<>();
        
        int A,B;
        StringTokenizer st;

        while(M-->0) {
            st = new StringTokenizer(br.readLine());
            A = st.nextToken().charAt(0)-'a';
            st.nextToken();
            B = st.nextToken().charAt(0)-'a';
            adj[A].add(B);
        }
    }

    public static void process() throws IOException {
        N = Integer.parseInt(br.readLine());

        int A,B;
        StringTokenizer st;

        while(N-- > 0) {
            visit = new boolean[26];
            st = new StringTokenizer(br.readLine());
            A = st.nextToken().charAt(0)-'a';
            st.nextToken();
            B = st.nextToken().charAt(0)-'a';

            FLAG = false;
            DFS(A,B);
            sb.append(FLAG ? "T" : "F");
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void DFS(int start, int target) {
        if(start == target) {
            FLAG = true;
        }

        visit[start] = true;

        for(int next : adj[start]) {
            if(visit[next]) continue;

            DFS(next, target);
        }
    }
}