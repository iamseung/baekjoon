import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static final int len = 9;
    static int[][] map = new int[len][len];

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    public static void input() throws IOException {
        for(int i=0; i<len; i++) {
            String str = br.readLine();
            for(int j=0; j<len; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
    }

    public static void process(){
        recursion(0, 0);
    }

    static void recursion(int x, int y) {
        // 맨 우측
        if(x == len) {
            recursion(0, y+1);
            return;
        }

        // 도착
        if(y == len) {
            for(int i=0; i<len; i++) {
                for(int j=0; j<len; j++)
                    sb.append(map[i][j]);

                sb.append("\n");
            }

            System.out.println(sb.toString());
            System.exit(0);
        }

        // 숫자가 차있는 경우, 다음 구간 탐색
        if(map[y][x] != 0) {
            recursion(x+1, y);
            return;
        }

        for(int n : getPossibleNumbers(x, y)) {
            map[y][x] = n;
            recursion(x+1, y);
            map[y][x] = 0;
        }
    }

    static int[] getPossibleNumbers(int x, int y) {
        boolean[] numbers = new boolean[10];
        
        int bX = (x / 3) * 3;
        int bY = (y / 3) * 3;
        
        // 3 X 3
        for(int i = bY; i < bY + 3; i++) {
            for(int j = bX; j < bX + 3; j++) {
                numbers[map[i][j]] = true;
            }
        }
        
        for(int i=0; i<len; i++) {
            numbers[map[y][i]] = true;
            numbers[map[i][x]] = true;
        }

        List<Integer> list = new ArrayList<>();

        for(int i=1; i<=9; i++) {
            if(!numbers[i])
                list.add(i);
        }

        return list.stream().mapToInt(i->i).toArray();
    }
}