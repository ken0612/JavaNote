import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        // Write your code here
        int[] temp = new int[queries.size()];
        for(int i =0 ;i<strings.size();i++){
            for(String k:queries){
                if(strings.get(i).equals(k)){
                    temp[i]++;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int kk:temp){
            ans.add(kk);
        }
        return ans;
    }
}
