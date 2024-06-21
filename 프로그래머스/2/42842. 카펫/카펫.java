class Solution {
    public int[] solution(int brown, int yellow) {
        int area = brown + yellow;

        int[] answer = new int[2];
        for(int x=1; x<= (int) Math.sqrt(area); x++) {
            if(area % x == 0) {
                int y = area/x;
                if((x-2) * (y-2) == yellow) {
                    answer[0] = Math.max(x,y);
                    answer[1] = Math.min(x,y);
                }
            }
        }

        return answer;
    }
}