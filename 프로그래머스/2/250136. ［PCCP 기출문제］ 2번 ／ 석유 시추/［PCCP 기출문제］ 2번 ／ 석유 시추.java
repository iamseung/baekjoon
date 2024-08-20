import java.util.*;
import java.util.stream.*;

class Solution {
    static final int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int xLen, yLen;
    static boolean[][] visited;
    static int[] oil;
    static Set<Integer> xList;
    static int sum = 0;

    public int solution(int[][] land) {
        yLen = land.length;
        xLen = land[0].length;

        visited = new boolean[yLen][xLen];
        oil = new int[xLen];

        for (int i = 0; i < yLen; i++) {
            for (int j = 0; j < xLen; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    xList = new HashSet<>();
                    sum = 0;
                    dfs(i, j, land);

                    for (int x : xList)
                        oil[x] += sum;
                }
            }
        }

        return Arrays.stream(oil).max().getAsInt();
    }
    
    static void dfs(int y, int x, int[][] land) {
        visited[y][x] = true;
        sum++;
        xList.add(x);

        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if (nx < 0 || ny < 0 || nx >= xLen || ny >= yLen)
                continue;
            if (visited[ny][nx])
                continue;
            if (land[ny][nx] != 1)
                continue;

            dfs(ny, nx, land);
        }
    }
}