import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main{

    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        Collections.sort(A);
        Collections.sort(B,Collections.reverseOrder());
        for(int i=0;i<A.size();i++){
            for(int j=0;j<B.size();j++){
                if(A.get(i)+B.get(j)>=k){
                    continue;
                }else if(A.get(i)+B.get(j)<k){
                    return "NO";
                }
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        List<Integer> arr1 = new ArrayList<>();
        arr.add(1);arr.add(2);arr.add(2);arr.add(1);
        arr1.add(3);arr1.add(3);arr1.add(3);;arr1.add(4);

        Main.twoArrays(5,arr,arr1);


    }
}