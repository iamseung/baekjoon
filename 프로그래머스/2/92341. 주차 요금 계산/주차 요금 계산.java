import java.util.*;
import java.util.stream.*;

class Solution {
    static final String IN = "IN";
    static final int TIME = 1439;
    
    public int[] solution(int[] fees, String[] records) {
        List<int[]> answer = new ArrayList<>();

        // 출차 내역 정보
        Map<String, Integer> carMap = new HashMap<>();
        // 시간 누적 계산
        Map<String, Integer> timeMap = new TreeMap<>();

        for (String record : records) {
            StringTokenizer st = new StringTokenizer(record, " ");
            int time = toTime(st.nextToken());
            String name = st.nextToken();
            String mode = st.nextToken();

            if (mode.equals(IN)) {
                carMap.put(name, time);
            } else {
                // 시간 계산
                int timeGap = time - carMap.get(name);
                timeMap.put(name,
                        timeMap.getOrDefault(name, 0) + timeGap);

                // 출차 내역은 삭제
                carMap.remove(name);
            }
        }

        // 출차되지 않은 차, 정산
        for (String key : carMap.keySet()) {
            int t = TIME - carMap.get(key);
            timeMap.put(key, timeMap.getOrDefault(key, 0) + t);
        }

        for (String key : timeMap.keySet()) {
            // 기본 시간 이상을 주차한 경우
            int parkingTime = timeMap.get(key);

            if (parkingTime > fees[0]) {
                // 기본 요금 + (주차 시간 - 기본 시간) / 단위 시간 X 단위 요금
                int gap = ((parkingTime - fees[0]) % fees[2] == 0) ? (parkingTime - fees[0]) / fees[2] * fees[3]
                        : ((parkingTime - fees[0]) / fees[2] + 1) * fees[3];
                int pay = fees[1] + gap;

                timeMap.put(key, pay);
            } else {
                // 기본 요금 부과
                timeMap.put(key, fees[1]);
            }

            System.out.println(key + " : " + timeMap.get(key));
        }

        return timeMap.values().stream()
                .mapToInt(i -> i)
                .toArray();
    }

    // 시간으로 컨버팅
    public static int toTime(String str) {
        String[] time = str.split(":");
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
}