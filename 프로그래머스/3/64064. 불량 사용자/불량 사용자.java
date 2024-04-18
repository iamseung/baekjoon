import java.util.*;

class Solution {
    static String[] userIds;
    static String[] bannedIds;
    static boolean[] visited;
    static HashSet<HashSet<String>> result = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        userIds = user_id; bannedIds = banned_id;
        visited = new boolean[userIds.length];

        dfs(new HashSet<>(), 0);

        return result.size();
    }
    
    static void dfs(HashSet<String> set, int dep) {
        if(dep == bannedIds.length) {
            result.add(set);
            return;
        }

        for(int i=0; i<userIds.length; i++) {
            if(set.contains(userIds[i]))
                continue;
            
            // 정규식 매칭
            if(check(userIds[i], bannedIds[dep])) {
                set.add(userIds[i]);
                dfs(new HashSet<>(set), dep + 1);
                set.remove(userIds[i]);
            }
        }
    }

    static boolean check(String userId, String bannedId) {
        if(userId.length() != bannedId.length())
            return false;
        
        for(int i=0; i<userId.length(); i++) {
            if(bannedId.charAt(i) == '*')
                continue;
            
            if(userId.charAt(i) != bannedId.charAt(i))
                return false;
        }
        
        return true;
    }
}