import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static class Room
    {
        ArrayList<User> users = new ArrayList<>();
    }

    static class User implements Comparable<User>
    {
        int level;
        String player;

        public User(int level, String player)
        {
            this.level  = level;
            this.player = player;
        }

        @Override
        public int compareTo(User other)
        {
            return player.compareTo(other.player);
        }
    }

    static int N, M;
    static ArrayList<Room> rooms = new ArrayList<>();

    static void input() 
    {
        N = scan.nextInt(); M = scan.nextInt();
    }

    static void pro()
    {
        while(N-- > 0)
        {
            st = new StringTokenizer(scan.nextLine());

            int level     = Integer.parseInt(st.nextToken());
            String player = st.nextToken();
            boolean flag  = false;

            // 생성된 룸을 조회
            for(Room room : rooms)
            {
                // 정원초과
                if(room.users.size() >= M) continue;
                // 룸에 넣을 수 있는 경우
                // 처음 입장한 플레이어 기준
                if(!room.users.isEmpty() && room.users.get(0).level - 10 <= level 
                && level <= room.users.get(0).level + 10)
                {
                    flag = true;
                    room.users.add(new User(level, player));
                    break;
                }
            }
            // 룸에 넣지 못한 경우, 새 룸을 새성
            if(!flag)
            {
                Room room = new Room();
                room.users.add(new User(level, player));
                rooms.add(room);
            }
        }

        for (Room room : rooms) 
        {
            // 플레이어 이름 순으로 정렬
            Collections.sort(room.users);
            // 정원이 모두 찬 경우
            if(room.users.size() == M)
                sb.append("Started!\n");
            else
                sb.append("Waiting!\n");

            for(int i=0;i<room.users.size();i++)
                sb.append(Integer.toString(room.users.get(i).level)+" "+room.users.get(i).player+"\n");
        }

        System.out.println(sb);
    }   
    
    public static void main(String[] args) 
    {
        input();
        pro();
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

        String next() 
        {
            while (st == null || !st.hasMoreElements()) 
            {
                try {
                    st = new StringTokenizer(br.readLine());
                } 
                catch (IOException e) {
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
            try          
            {
                str = br.readLine();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}