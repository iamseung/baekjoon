import java.util.*;
import java.util.stream.*;

class Solution {
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    static class Node {
        int x, y, move,price;

        Node(int x, int y, int move, int price) {
            this.x = x;
            this.y = y;
            this.move = move;
            this.price = price;
        }
    }
    
    public int solution(int[][] board) {
        int answer = 0;
        int N = board.length;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0,-1,0));
        boolean[][][] visited = new boolean[N][N][4];
        int min = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if(cur.x == N-1 && cur.y == N-1) {
                min = Math.min(min, cur.price);
            }
            
            for(int k=0; k<4; k++) {
                int nx = cur.x + dir[k][0];
                int ny = cur.y + dir[k][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(board[nx][ny] == 1) continue;

                int nextPrice = cur.price;

                if(k == cur.move || cur.move == -1) {
                    nextPrice += 100;
                } else {
                    nextPrice += 600;
                }

                if(!visited[nx][ny][k] || board[nx][ny] >= nextPrice) {
                    queue.offer(new Node(nx, ny, k, nextPrice));
                    visited[nx][ny][k] = true;
                    board[nx][ny] = nextPrice;
                }
            }
        }

        return min;
    }
}