import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static char map[][] = new char[5][9];
    static boolean visited[] = new boolean[13];
    static ArrayList<Node> list = new ArrayList<>(); // 알파벳으로 채워야 할 곳을 담아두는 리스트
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'x') {
                    list.add(new Node(i, j));
                } else if (map[i][j] != '.') {
                    visited[map[i][j] - 65] = true;
                }
            }
        }

        dfs(0);
    }

    public static void dfs(int idx) {
        if (idx == list.size()) {
            if (check()) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 9; j++) {
                        sb.append(map[i][j]);
                    }

                    sb.append("\n");
                }

                System.out.println(sb.toString());
                System.exit(0);
            }

            return;
        }

        for (int i = 0; i < 12; i++) {
            if (!visited[i]) {
                Node a = list.get(idx);
                char alpha = (char) (65 + i);
                map[a.x][a.y] = alpha;

                visited[i] = true;
                dfs(idx + 1);
                visited[i] = false;

                map[a.x][a.y] = '.';
            }
        }
    }

    public static boolean check() {
        int sum1 = (map[0][4] - 'A' + 1) + (map[1][3] - 'A' + 1) + (map[2][2] - 'A' + 1) + (map[3][1] - 'A' + 1);
        int sum2 = (map[0][4] - 'A' + 1) + (map[1][5] - 'A' + 1) + (map[2][6] - 'A' + 1) + (map[3][7] - 'A' + 1);
        int sum3 = (map[1][1] - 'A' + 1) + (map[1][3] - 'A' + 1) + (map[1][5] - 'A' + 1) + (map[1][7] - 'A' + 1);
        int sum4 = (map[3][1] - 'A' + 1) + (map[3][3] - 'A' + 1) + (map[3][5] - 'A' + 1) + (map[3][7] - 'A' + 1);
        int sum5 = (map[4][4] - 'A' + 1) + (map[3][3] - 'A' + 1) + (map[2][2] - 'A' + 1) + (map[1][1] - 'A' + 1);
        int sum6 = (map[4][4] - 'A' + 1) + (map[3][5] - 'A' + 1) + (map[2][6] - 'A' + 1) + (map[1][7] - 'A' + 1);

        if (sum1 == 26 && sum2 == 26 && sum3 == 26 && sum4 == 26 && sum5 == 26 && sum6 == 26) {
            return true;
        }
        return false;
    }

    public static boolean isRange(int x, int y) {
        if (x >= 0 && y >= 0 && x < 5 && y < 9) {
            return true;
        }
        return false;
    }
}

class Node {
    int x, y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}