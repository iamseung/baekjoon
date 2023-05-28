import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, max;
    static int[] score, team;
	static ArrayList<Integer>[] major;
	static HashMap<Integer,Integer> majorRank;

    static void input() 
    {
        N = scan.nextInt();
        score = new int[N+1]; // 랭크입력
        team = new int[201];  // 1 - 200
		major = new ArrayList[201];
		majorRank = new HashMap<>();

        for(int i=1; i<=N; i++)
        {
            score[i] = scan.nextInt();
            team[score[i]]++; // 인원수 체크

			// 6명이 모두 있다면 비교할 팀에 등록
            if(team[score[i]] == 6)
			{
				// index 는 팀번호
				major[score[i]] = new ArrayList<>();
				majorRank.put(score[i], 0);
				team[score[i]] = 0; // 초기화
			}
        }
    }

	static void pro() 
    {   
		int index = 1;

		// 각 팀에 등수별로 점수 반환
		for(int i=1; i<=N; i++)
        {
            if(!majorRank.containsKey(score[i])) continue;

			// 4위까지 점수 측정
			if(team[score[i]] < 4)
			{
				majorRank.put(score[i], majorRank.get(score[i]) + index);
			}

			major[score[i]].add(index);
			team[score[i]]++;
			index++;
        }

		int min = Integer.MAX_VALUE;
		int minTeam = 201;
		for(int k : majorRank.keySet())
		{
			int value = majorRank.get(k);

			if(min > value)
			{
				min = value;
				minTeam = k;
			}
			else if(min == value)
			{
				if(major[minTeam].get(4) > major[k].get(4))
				{
					// 점수는 동일, team 만 스위칭
					minTeam = k;
				}
			}
		}
		sb.append(minTeam+"\n");
	}

    public static void main(String[] args) 
    {
		int T = scan.nextInt();
		while(T--> 0)
		{
			input();
			pro();
		}
		System.out.println(sb);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}