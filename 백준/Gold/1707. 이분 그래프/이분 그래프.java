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

    /*
     * 이분 그래프는 어떤 한 정점에서 연결된 모든 다른 정점이 다른 값을 가져야합니다.
     * int[] visit 으로 표현하자면
     * 0    : 방문하지 않음
     * 1,2  : 서로 다른 정점을 표기
     */
    public static void pro() {
        Queue<Integer> q = new LinkedList<>();

        // 모든 정점을 탐색
        for(int i=1; i<=V; i++) {
            // 해당 정점을 방문한 적이 없다면 큐에 INSERT
            if(visit[i] == 0) {
                q.add(i);
                visit[i] = 1;
            }

            while(!q.isEmpty()) {
                int now = q.poll();
                // 해당 정점과 연결된 모든 정점탐색 시작
                for(int j=0; j<adj[now].size(); j++) {
                    int connectedDot = adj[now].get(j);

                    // 현재 정점과 연결된 정점의 색이 같다면 이분 그래프가 아님!
                    if(visit[connectedDot] == visit[now]) {
                        System.out.println("NO");
                        return;
                    }
                    // 연결된 정점이 방문한 적이 없다면
                    if(visit[connectedDot] == 0) {
                        // 큐에 넣어서 탐색
                        q.add(connectedDot);

                        // 현재 정점과 다른 색상을 부여
                        // visit[now] 는 색상을 부여받고 큐에 넣어지기 때문에 0인 가능성을 배제
                        visit[connectedDot] = (visit[now] == 1) ? 2 : 1;
                    }
                }
            }
        }

        System.out.println("YES");
    }
}