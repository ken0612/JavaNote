public class Test {
    public static void staircase(int n) {
        int k = n-1;
        String[] arr = new String[n];
        String space = " ";
        for(int p = 0;p<arr.length;p++){
            arr[p]=space;
        }

        for(int i=0 ; i < arr.length ; i++){
            for(int j=-1;j<i;j++){
                if(k>=0){
                    arr[k] = "#";
                    k--;
                }else{
                    continue;
                }
                for(String z :arr){
                    System.out.print(z);
                }
                System.out.println();
            }

        }
    }

    public static void main(String[] args) {
        Test.staircase(20);
    }
}