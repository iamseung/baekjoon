import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

/*
1. 같은 알파벳을 두번 지날 수 없으니 중복을 허용하지 않는 재귀함수이다.
  - 1차원 방문배열 사용(알파벳 26개)
2. 가지치기를 통한 재귀함수이니 백트래킹 알고리즘이다.
3. 가지치기
  - 맵 범위를 벗어나는 경우
  - 이미 방문한 알파벳인 경우
*/

public class Main {
    static int R, C;
    static boolean visited[];
    static char map[][];
    static int max_count = Integer.MIN_VALUE;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    void DFS(int x, int y, int count) {
        int idx = map[x][y] - 'A';
        visited[idx] = true;
        max_count = Math.max(max_count, count);
        // 탐색시작
        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 가지치기
            if (nx<0 || nx>=R || ny<0 || ny>=C) continue; // 범위 벗어나면 패스
            idx = map[nx][ny] - 'A';
            if (visited[idx]) continue; // 방문한 알파벳이면 패스
            // 탐색진행
            DFS(nx, ny, count+1);
            // 백트래킹으로 이전 노드로 복귀하면 다음을 위해 방문처리 취소
            visited[idx] = false;
            
        }
        
    }

	void Solve() {
        visited = new boolean[26];
        DFS(0, 0, 1);
        System.out.println(max_count);
	}

    void inputData() throws Exception {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i=0; i<R; i++) {
            //st = new StringTokenizer(br.readLine());
            String str = br.readLine();
            for (int j=0; j<C; j++) {
                //map[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = str.charAt(j);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.inputData(); // 입력 받는 부분
        m.Solve();// 여기서부터 작성
    }
}