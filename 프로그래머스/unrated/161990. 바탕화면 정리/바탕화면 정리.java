import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int rowMin = Integer.MAX_VALUE;
        int rowMax = Integer.MIN_VALUE;
        int colMin = Integer.MAX_VALUE;
        int colMax = Integer.MIN_VALUE;
        for(int i=0; i<wallpaper.length; i++) {
            for(int j=0; j<wallpaper[i].length(); j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    rowMin = Math.min(rowMin, i);
                    rowMax = Math.max(rowMax, i);
                    
                    colMin = Math.min(colMin, j);
                    colMax = Math.max(colMax, j);
                }
            }
        }
        int[] answer = {rowMin, colMin, rowMax+1, colMax+1};
        return answer;
    }
}