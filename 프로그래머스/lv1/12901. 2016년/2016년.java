class Solution {
    static int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String[] Y = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
    // 2016년 1월 1일 : 금요일
    public String solution(int a, int b) {
        int day = b-1;
        for(int i=0; i<a-1; i++) day += days[i];
        
        return Y[day%7];
    }
}