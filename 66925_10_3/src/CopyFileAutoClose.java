import java.io.*;

public class CopyFileAutoClose{
    public static void main(String[] args) {
        int bajt;
        try(FileInputStream fis = new FileInputStream("file.txt");
        FileOutputStream fos = new FileOutputStream("copyOfFile.txt")){

            do{
                bajt = fis.read();
                if((char)bajt == ' ') bajt = '-';
                if(bajt != -1) fos.write(bajt);
            } while(bajt != -1);
        } catch (IOException e) {
            System.out.println("Error IO");
        }
    }
}