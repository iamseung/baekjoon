class Solution 
{
    static String[] key = {"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) 
    {
        int answer = 0;
        
        for(int k=0;k< babbling.length;k++)
        {   
            String str = babbling[k];
            
            for(String j : key)
            {
                str = str.replace(j, "1");
            }
            str = str.replaceAll("1", "");
            
            if(str.length() == 0) answer++;
        }
        
        return answer;
    }
}