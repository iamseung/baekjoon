import java.util.*;

class Solution {
    static Map<Character, int[]> map = new HashMap<>();
    static boolean[][][] visit = new boolean[11][11][4]; // -5 ~ +5

    public int solution(String dirs) {
        setDir();
        
        int x = 0;
        int y = 0;
        int distance = 0;
        
        for(char d : dirs.toCharArray()) {
            int[] dir = map.get(d);
            
            int nx = x + dir[0];
            int ny = y + dir[1];
            int direction = dir[2];
            
            // out of range
            if(nx < -5 || ny < -5 || nx > 5 || ny > 5) continue;
            // 방문하지 않은 곳
            if(!visit[ny+5][nx+5][direction]) {
                visit[ny+5][nx+5][direction] = true;
                distance++;
                // 반대 경우도 처리
                direction = (direction%2 == 0) ? 2-direction : 4-direction;
                visit[y+5][x+5][direction] = true;
            }
            
            x = nx;
            y = ny;
        }
        
        return distance;
    }
    
    static void setDir() {
        map.put('U', new int[]{0,1,0});
        map.put('D', new int[]{0,-1,2});
        map.put('L', new int[]{-1,0,1});
        map.put('R', new int[]{1,0,3});
    }
}