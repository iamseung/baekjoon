class Solution {
    static int[] answer = new int[2];
    static int[][] map;

    public int[] solution(int[][] arr) {
        map = arr;
        quad(0, 0, arr.length);
        return answer;
    }

    public boolean zip(int x, int y, int size, int val) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != val)
                    return false;
            }
        }

        return true;
    }

    public void quad(int x, int y, int size) {
        // (x,y) 좌표부터 size 만큼의 구역을 압축할 수 있으면
        if (zip(x, y, size, map[x][y])) {
            if (map[x][y] == 1)
                answer[1]++;
            else
                answer[0]++;
            
            return;
        }

        // 4분할 quad 재귀
        int half = size / 2;

        quad(x, y, half);
        quad(x, y + half, half);
        quad(x + half, y, half);
        quad(x + half, y + half, half);
    }
}