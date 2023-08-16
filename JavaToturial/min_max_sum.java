import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void miniMaxSum(List<Integer> arr) {
        long max=arr.get(0);
        long min=arr.get(0);
        long total=0;
        for(int i=0 ;i<arr.size();i++){
            if(max<arr.get(i)){
                max=arr.get(i);
            }else if(min>arr.get(i)){
                min=arr.get(i);
            }
            total+=arr.get(i);
        }
        System.out.println((total-max) +" "+ (total-min));

    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        Test.miniMaxSum(arr);

    }

}
