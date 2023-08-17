import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer>[] adj;
    static int N,X,S;
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N];
        for(int i=0; i<N; i++) adj[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            int t = Integer.parseInt(st.nextToken());
            // 시작 기점
            if(t == -1) {
                S = i;
                continue;
            }
            // 트리 연결
            adj[t].add(i);
        }

        X = Integer.parseInt(br.readLine());
    }

    public static void pro() throws IOException {
        if(X == S) {
            System.out.println(0);
            return;
        }
        // X번 노드 삭제
        removeNode(X);
        // 탐색
        System.out.println(BFS(S));
    }

    public static void removeNode(int node) {
        // [재귀] 해당 노드, 자식노 드 모두 조회
        if(adj[node].size()>0) {
            int size = adj[node].size();
            while(size-- > 0) {
                int child = adj[node].get(size);
                removeNode(child);
            }   
        }

        // 해당 노드, 자식 노드 모두 삭제 
		for(int i=0; i<N; i++) {
			if(adj[i].contains(node)) {
				for(int j=0; j<adj[i].size(); j++) {
					if(adj[i].get(j) == node) {
						adj[i].remove(j);
					}
				}
			}
		}
    }

    public static int BFS(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);

        int cnt = 0;

        while(!que.isEmpty()) {
            int x = que.poll();
            
            // 리프노드
            if(adj[x].size() == 0) {
                cnt++;
                continue;
            }

            for(int k : adj[x]) {
                que.add(k);
            }
        }
        
        return cnt;
    }
}