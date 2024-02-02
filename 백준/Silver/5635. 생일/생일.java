import java.io.*;
import java.util.*;

public class Main {
    static class User implements Comparable<User> {
        String name;
        int day;
        int month;
        int year;

        User(String Name, int Day, int Month, int Year) {
            this.name = Name;
            this.day = Day;
            this.month = Month;
            this.year = Year;
        }

        @Override
        public int compareTo(User u) {
            if(year == u.year) {
                return month - u.month;
            }
            if(u.month == month) {
                return day - u.day;
            }
            return year - u.year;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static User[] user;
    static int N;
    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        user = new User[N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            user[i] = new User(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        } 
    }

    static void process() {
        Arrays.sort(user);
        
        StringBuilder sb = new StringBuilder();
        sb.append(user[N-1].name+"\n"+user[0].name);
        System.out.println(sb.toString());
    }
}
