import java.util.*;
import java.io.*;

// 물의 현재 상태와 물을 붓는 행위를 관리하는 구조체
class State {
    int[] X;
    State(int[] _X) {
        X = new int[3];
        for(int i=0; i<3; i++) X[i] = _X[i];
    }

    // from 물통에서 to 물통으로 물을 옮긴다!
    State move(int from, int to, int[] Limit) {
        // 반환 해줄 물통의 양 nx, 초기화는 현재 물통의 양을 의미
        int[] nX = new int[] {X[0],X[1],X[2]};

        // 1. to 가 먼저 차는 상황
        // Limit[to] 는 to 라는 index 를 가진 물통의 양을 의미
        // 즉 현재 물통에서 from 과 to의 양의 합이 Limit[to] 를 가득 채우거나 넘치는 경우!
        if(X[from] + X[to] >= Limit[to]) {
            nX[from] -= Limit[to] - X[to];  // 넘치는 양을 빼준다  
            nX[to] = Limit[to];             // Limit 까지 가득 채운다
        }
        // 2. from 의 물이 먼저 비는 상황
        else {
            nX[to] += nX[from];             // 넘치지 않는 만큼 더해준다
            nX[from] = 0;                   // 물통이 비었음을 의미
        }

        // 옮기고 난 뒤의 양을 반환
        return new State(nX);
    }
}
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] Limit = new int[3];
    static boolean[] possible;
    static boolean[][][] visit;
    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<3; i++) Limit[i] = Integer.parseInt(st.nextToken());
        visit = new boolean[205][205][205];
        possible = new boolean[205];
    }

    public static void process() {
        // 현재 C 물통만 가득 채워져 있는 상황
        BFS(0,0,Limit[2]);

        for(int i=0; i<=Limit[2]; i++) {
            if(possible[i]) sb.append(i+" ");
        }

        System.out.println(sb.toString());
    }

    public static void BFS(int x1, int x2, int x3) {
        Queue<State> Q = new LinkedList<>();
        visit[x1][x2][x3] = true;
        Q.add(new State(new int[]{x1,x2,x3}));

        while(!Q.isEmpty()) {
            // st는 현재 물의 상태
            State st = Q.poll();
            // A번 물통이 비어있다면 C의 양은 가질 수 있음
            if(st.X[0] == 0) possible[st.X[2]] = true;

            // 탐색 시작
            for(int from=0; from<3; from++) {
                for(int to=0; to<3; to++) {
                    // 같은 물통에서 같은 물통은 pass
                    if(from == to) continue;

                    // 물을 옮긴다
                    State nxt = st.move(from,to,Limit);
                    // 물이 이동한 좌표가 방문한 적이 없다면
                    if(!visit[nxt.X[0]][nxt.X[1]][nxt.X[2]]) {
                        visit[nxt.X[0]][nxt.X[1]][nxt.X[2]] = true;
                        Q.add(nxt);
                    }
                }
            }
        }
    }
}