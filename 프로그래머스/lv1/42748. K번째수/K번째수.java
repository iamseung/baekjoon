import java.util.*;
import java.io.*;

class Solution 
{
    static StringBuilder sb = new StringBuilder();
    static int[] list;
    
    public int[] solution(int[] array, int[][] commands) 
    {
        list = new int[commands.length];
        for(int i=0; i<commands.length; i++)
        {
            int stIndex = commands[i][0];
            int edIndex = commands[i][1];
            int target  = commands[i][2];

            int[] newArr = Arrays.copyOfRange(array, stIndex-1, edIndex);
            Arrays.sort(newArr);
            list[i] = newArr[target-1];
        }
        
        return list;
    }
}