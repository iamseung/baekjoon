import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, R, trunk, branch;
    static List<int[]>[] nodes;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 노드의 개수
        R = Integer.parseInt(st.nextToken()); // 루트 노드의 번호

        nodes = new ArrayList[N+1];
        for(int i=1; i<=N; i++)
            nodes[i] = new ArrayList<>();

        int a,b,d;
        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            // 양방향
            nodes[a].add(new int[]{b,d});
            nodes[b].add(new int[]{a,d});
        }
    }

    /*
     * 기가 노드 -> 루트 노드에서 만나는 처음으로 자식 노드가 2개 이상인 노드
     * 리프 노드가 단 1개인 경우 리프 노드 = 기가 노드
     * 루트 노드가 동시에 기가 노드가 될 수 있음
     */
    public static void process(){
        visited = new boolean[N+1];
        visited[R] = true;

        if(nodes[R].size() == 1) {
            visited[nodes[R].get(0)[0]] = true;
            trunk += nodes[R].get(0)[1];
            findBranch(findTrunk(nodes[R].get(0)[0]), 0);
        } else {
            // 루트에서 간선이 2개 이상이면 루트 노드 = 기가 노드
            findBranch(R, 0);
        }

        System.out.println(trunk + " " + branch);
    }

    // 기둥
    static int findTrunk(int root) {
        while (nodes[root].size() == 2) {
            for (int[] node : nodes[root]) {
                if (!visited[node[0]]) {
                    visited[node[0]] = true;
                    trunk += node[1];
                    root = node[0];
                }
            }
        }
        return root;
    }

    // 가지
    static void findBranch(int v, int length) {
        // 리프 노드일 경우 가지의 최대 길이 갱신
        if (nodes[v].size() == 1) 
            branch = Math.max(branch, length);

        for (int[] node : nodes[v]) {
            if (!visited[node[0]]) {
                visited[node[0]] = true;
                findBranch(node[0], node[1] + length);
                visited[node[0]] = false;
            }
        }
    }
}