import java.util.*;
import java.io.*;
class Solution {
    /**
     * 개인정보 수집 유효기간
     * @param today 오늘 날짜 YYYY.MM.DD
     * @param terms 약관의 유효기간 (약관종류 유효기간) : 공백으로 구분, 유효기간은 개월수
     * @param privacies 수집된 개인정보 (날짜 약관정보) : 공백으로 구분
     * @return 파기해야할 개인정보의 번호 오름차순
     */
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        Map<String, String> termsMap = new HashMap<>(); // key : 종류, value : 기간
        for (String term : terms) {
            String[] termSplit = term.split(" ");
            termsMap.put(termSplit[0], termSplit[1]);
        }

        Integer number = 1; // privacies 의 번호
        List<Integer> result = new ArrayList<>();
        // 현재 총 날짜 수
        Integer todayTotalDate = getTotalDate(today, 0);
        for (String p : privacies) {
            String[] privateSplit = p.split(" ");
            // 개인별 날짜
            String privateDate = privateSplit[0];
            // 개인별 약관 정보
            String privateTerm = privateSplit[1];
            // 약관 개월수
            Integer termsMonth = Integer.valueOf(termsMap.get(privateTerm));

            // 기간 경과 후 총 날짜 수
            Integer privateTotalDate = getTotalDate(privateDate, termsMonth) - 1; // 기간이므로 -1
            // 기간경과후 날짜가 현재 날짜보다 과거이면 폐기대상이다.
            if (privateTotalDate < todayTotalDate) { // 현재 당일은 아직 폐기대상 아님
                // 유효기간 경과하여 폐기대상인 번호를 추가
                result.add(number);
            }
            // privacies 의 번호 +1
            number++;
        }
        answer = result.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    /**
     * (YYYY.MM.DD)을 총 날짜 수로 환산
     * @param strDate YYYY.MM.DD
     * @param termsMonth 약관 개월 수
     * @return 날짜로 환산한 총 날짜 수
     */
    private Integer getTotalDate(String strDate, Integer termsMonth) {
        // 날짜 정보
        String[] dateSplit = strDate.split("\\.");
        Integer year = Integer.valueOf(dateSplit[0]);
        Integer month = Integer.valueOf(dateSplit[1]) + termsMonth;
        Integer day = Integer.valueOf(dateSplit[2]);

        // 모두 일 수로 환산, 한 달은 28일
        return (year * 12 * 28) + (month * 28) + day;
    }
}