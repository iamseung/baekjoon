import java.util.*;

class Solution {
    // 바구니에 담길 Stack
    static Stack<Integer> backet = new Stack<>();
    static ArrayList<Integer>[] doll;
    static int boardSize, cnt;
    
    public int solution(int[][] board, int[] moves) {
        boardSize = board.length;
        // 보드 데이터 생성
        doll = new ArrayList[boardSize];
        for(int i=0; i<boardSize; i++) doll[i] = new ArrayList<>();
        
        // 보드 데이터 입력
        for(int i=boardSize-1; i>=0; i--) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] == 0) continue;
                doll[j].add(board[i][j]);
            }
        }
        
        pickDoll(moves);
        
        return cnt;
    }
    
    static void pickDoll(int[] moves) {
        for(int index : moves) {
            // 0번째 라인부터 시작
            index--;
            // 뽑을 인형이 있는지 확인
            if(!possible(index)) continue;
            // 해당 라인에 마지막 인형을 뽑아옴
            int pick = doll[index].get(doll[index].size()-1);
            // Delete
            doll[index].remove(doll[index].size()-1);
            // 없으면 insert
            if(backet.isEmpty()) {
                backet.push(pick);
                continue;
            }
            // 뽑은 것과 직전에 넣은 것이 같다면 삭제
            if(backet.peek() == pick) {
                backet.pop(); cnt += 2;
            }
            else {
                backet.push(pick);
            }
        }
    }
    
    static boolean possible(int index) {
        if(doll[index].size() == 0) return false;
        return true;
    }
}