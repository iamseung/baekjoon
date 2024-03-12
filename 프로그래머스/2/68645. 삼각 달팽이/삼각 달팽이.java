import java.util.stream.*;

class Solution {
    public int[] solution(int n) {
        int L = IntStream.rangeClosed(1, n).sum();
        int[][] matrix = new int[n][n];

        int x = 0, y = 0, index = 1;

        matrix[0][0] = 1;

        while (index < L) {
            // 왼쪽 Line
            while (y + 1 < n && matrix[y+1][x] == 0) {
                matrix[++y][x] = ++index;
            }

            // 맨 밑의 Line
            while (x + 1 < n && matrix[y][x+1] == 0) {
                matrix[y][++x] = ++index;
            }

            // 오른쪽 대각선 Line
            while (y > 0 && matrix[y-1][x-1] == 0) {
                matrix[--y][--x] = ++index;
            }
        }

        return IntStream.range(0, n)
                    .flatMap(i -> IntStream.range(0, i + 1)
                    .map(j -> matrix[i][j]))
                    .toArray();
    }
}