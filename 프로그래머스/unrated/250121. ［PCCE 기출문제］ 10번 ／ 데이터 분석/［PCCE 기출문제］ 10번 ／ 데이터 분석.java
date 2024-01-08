import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        HashMap<String, Integer> dataType = new HashMap<String, Integer>();
        dataType.put("code", 0);
        dataType.put("date", 1);
        dataType.put("maximum", 2);
        dataType.put("remain", 3);
        
        List<int[]> filtered_data = new ArrayList<>();
        for(int[] d : data) {
            if(d[dataType.get(ext)] < val_ext) {
                filtered_data.add(d);
            }
        }
        
        filtered_data.sort(Comparator.comparingInt(arr -> arr[dataType.get(sort_by)]));
        
        return filtered_data.toArray(new int[0][]);
    }
}