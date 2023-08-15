import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Scanner sc = new Scanner(System.in);
    static int T, V, E;
    static ArrayList<Integer>[] adj;
    static int[] visit;
    public static void main(String[] args) throws IOException {
        T = sc.nextInt();
        while(T-- >0) {
            input();
            pro();
        }
    }

    public static void input() throws IOException {
        V = sc.nextInt();
        E = sc.nextInt();
        adj = new ArrayList[V+1];
        visit = new int[V+1];
        for(int i=1; i<=V; i++) adj[i] = new ArrayList<>();

        while(E-- >0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    // 즉, 이분 그래프는 어떤 한 정점에서 연결된 모든 다른 정점이 다른 값을 가져야합니다.
    public static void pro() {
        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=V; i++) {
            if(visit[i] == 0) {
                q.add(i);
                visit[i] = 1;
            }

            while(!q.isEmpty()) {
                int now = q.poll();

                for(int j=0; j<adj[now].size(); j++) {
                    // 연결된 정점이 방문한 적이 없다면
                    if(visit[adj[now].get(j)] == 0) {
                        q.add(adj[now].get(j));
                    }
                    // 현재 정점과 연결된 정점의 색이 같다면 이분 그래프가 아니다!
                    if(visit[adj[now].get(j)] == visit[now]) {
                        System.out.println("NO");
                        return;
                    }
                    if(visit[adj[now].get(j)] == 0) {
                        if(visit[now] == 1) {
                            visit[adj[now].get(j)] = 2;
                        }

                        if(visit[now] == 2) {
                            visit[adj[now].get(j)] = 1;
                        }
                    }
                }
            }
        }

        System.out.println("YES");
    }
}