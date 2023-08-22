import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try{
            FileOutputStream inpt = new FileOutputStream("test.txt");
            String a = "hello world java";
            byte b[] = a.getBytes();
            inpt.write(b);
            inpt.flush();
            inpt.close();
            System.out.println("Success...");
        }catch(IOException e){
            System.out.println("file not found");
        }
    }
}
