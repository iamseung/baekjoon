import java.io.*;
import java.util.*;
 
public class Main {
	// BOJ / 15681번 / 트리와 쿼리 / 트리 / 골드5
	static ArrayList<Integer>[] list;
	static boolean visit[];
	static int dp[];
	public static void main(String[] args) throws NumberFormatException, IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int r = Integer.parseInt(stk.nextToken());
		int q = Integer.parseInt(stk.nextToken());
		
		list = new ArrayList[n+1];
		dp = new int [n+1];
		visit = new boolean[n+1];
		
		for(int i=0; i<list.length; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=1; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(stk.nextToken());
			int v = Integer.parseInt(stk.nextToken());
			
			list[u].add(v);
			list[v].add(u);
		}
		
		dfs(r);
		StringBuffer sb = new StringBuffer();
		while(q-- > 0) {
			int query = Integer.parseInt(br.readLine());
			
			sb.append(dp[query]).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int dfs(int now) {
		if(dp[now] != 0) return dp[now];
        
		visit[now] = true;
		int count = 1;
		
		for(int node : list[now]) {
			if(visit[node]) continue;
			count += dfs(node);
		}

		dp[now] = count;
		
		return dp[now];
	}
}