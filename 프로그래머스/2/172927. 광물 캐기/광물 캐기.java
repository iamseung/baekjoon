import java.util.*;

class Solution {
    static class Mineral {
        private int diamond;
        private int iron;
        private int stone;
        
        public Mineral(int diamond, int iron, int stone) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }
    }
    
    static int[][] score = {{1,1,1},{5,1,1},{25,5,1}};
    static List<Mineral> list = new ArrayList<>();
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        // 곡괭이의 개수
        int totalPicks = Arrays.stream(picks).sum();

        // 5개씩 소모값 계산
        for(int i = 0; i < minerals.length; i+=5) {
            if(totalPicks == 0) break;
            
            int dia = 0, iron = 0, stone = 0;
            for(int j = i; j < i + 5; j++) {
                if(j == minerals.length) break;
                
                int val = toInt(minerals[j]);
                
                // 주어진 광물을 3개의 곡갱이를 사용했을 때 피로도 누적 계산
                dia += score[0][val];
                iron += score[1][val];
                stone += score[2][val];
            }
            
            list.add(new Mineral(dia, iron, stone));
            totalPicks--;
        }

        // 돌 곡괭이를 사용했을 때 피로도가 큰 것부터 내림차순 정렬
        Collections.sort(list, ((o1, o2) -> (o2.stone - o1.stone)));

        for(Mineral m : list) {
            int dia = m.diamond;
            int iron = m.iron;
            int stone = m.stone;
            
            if(picks[0] > 0) {
                answer += dia;
                picks[0]--;
                continue;
            }
            if(picks[1] > 0) {
                answer += iron;
                picks[1]--;
                continue;
            }
            if(picks[2] > 0) {
                answer += stone;
                picks[2]--;
                continue;
            }
        }
        
        return answer;
    }
    
    static int toInt(String s) {
        int value = 0;

        switch (s) {
            case "iron" :
                value = 1;
                break;
            case "stone" :
                value = 2;
                break;        
            case "diamond" :
                value = 0;
                break;
            default:
                break;
        }

        return value;
    }
}