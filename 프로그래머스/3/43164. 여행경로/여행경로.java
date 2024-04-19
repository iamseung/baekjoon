import java.util.*;

class Solution {
    static List<String> allRoute = new ArrayList<>();
    static boolean[] visited;
    static String[][] T;
    static int N;
    
    public String[] solution(String[][] tickets) {
        T = tickets; N = tickets.length;
        visited = new boolean[tickets.length];

        dfs("ICN", "ICN", 0);

        Collections.sort(allRoute);
        return allRoute.get(0).split(" ");
    }
    
    static void dfs(String start, String route, int dep) {
        if(N == dep) {
            allRoute.add(route);
            return;
        }

        for(int i=0; i<N; i++) {
            String cur = T[i][0], next = T[i][1];
            if(start.equals(cur) && !visited[i]) {
                visited[i] = true;
                dfs(next, route + " " + next, dep + 1);
                visited[i] = false;
            }
        }
    }
}