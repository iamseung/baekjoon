import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        // 예약 시간 오름차순 정렬
        Arrays.sort(book_time, (o1, o2) -> o1[0].equals(o2[0]) ? o1[1].compareTo(o2[1]) : o1[0].compareTo(o2[0]));

        // 예약 시간 정수로 변경
        int[][] time = new int[book_time.length][2];

        for (int i = 0; i < book_time.length; i++) {
            String[] startParts = book_time[i][0].split(":");
            String[] endParts = book_time[i][1].split(":");

            int start_time = Integer.parseInt(startParts[0]) * 60 + Integer.parseInt(startParts[1]);
            int end_time = Integer.parseInt(endParts[0]) * 60 + Integer.parseInt(endParts[1]) + 10;

            time[i][0] = start_time;
            time[i][1] = end_time;
        }

        // 예약 시간별로 객실 할당하기, Room 은 끝나는 시간 기준
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        
        for (int[] t : time) {
            if (!rooms.isEmpty() && rooms.peek() <= t[0]) {
                rooms.poll();
            }
            rooms.add(t[1]);
        }

        return rooms.size();
    }
}