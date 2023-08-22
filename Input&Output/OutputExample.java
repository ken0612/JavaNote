import java.io.*;

public class Main {
    public static void main(String[] args) {
        try{
            FileInputStream inpt = new FileInputStream("test.txt");
            int i ;
            while((i=inpt.read())!=-1){
                System.out.print((char)i);
            }
            System.out.println();
            System.out.println("Success...");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
