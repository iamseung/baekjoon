import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int ANS = 0;
        // init
        Queue<Character> que = new LinkedList<>();
        for(char ch : skill.toCharArray())
            que.add(ch);
        
        for(String sk : skill_trees) {
            Queue<Character> clonedQueue = new LinkedList<>(que);
            boolean isLearned = false;

            for(char tree : sk.toCharArray()) {
                if(!clonedQueue.isEmpty() && clonedQueue.peek() == tree) {
                    clonedQueue.poll();
                }
            }

            boolean valid = true;
            while (!clonedQueue.isEmpty()) {
                char c = clonedQueue.poll();
                for(char tree : sk.toCharArray()) {
                    if(tree == c) {
                        valid = false;
                        break;
                    }
                }
            }

            ANS += valid ? 1 : 0;
        }

        return ANS;
    }
}