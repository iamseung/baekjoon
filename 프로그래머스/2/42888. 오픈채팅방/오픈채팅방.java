import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> uidMap = new HashMap<>(); // 유저 아이디와 최종 닉네임을 매핑하기 위한 해시맵
        List<String> answerList = new ArrayList<>(); // 최종 결과를 저장할 리스트

        // 첫 번째 순회: 모든 기록을 순회하며, 닉네임 변경 정보 업데이트
        for (String rec : record) {
            String[] splitRec = rec.split(" ");
            String command = splitRec[0];
            String uid = splitRec[1];
            if (!command.equals("Leave")) { // Leave 명령어는 닉네임이 없으므로 제외
                String nickname = splitRec[2];
                uidMap.put(uid, nickname); // 최종 닉네임 업데이트
            }
        }

        // 두 번째 순회: 입장(Enter)과 퇴장(Leave) 기록에 따라 최종 메시지 생성
        for (String rec : record) {
            String[] splitRec = rec.split(" ");
            String command = splitRec[0];
            String uid = splitRec[1];
            if (command.equals("Enter")) {
                answerList.add(uidMap.get(uid) + "님이 들어왔습니다.");
            } else if (command.equals("Leave")) {
                answerList.add(uidMap.get(uid) + "님이 나갔습니다.");
            }
        }

        return answerList.toArray(new String[0]);
    }
}