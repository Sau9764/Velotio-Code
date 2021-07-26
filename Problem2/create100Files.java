import java.io.*;

public class create100Files {

     public void createFiles(int n){
        try {  
            for(int i = 1; i <= n; i++){
                FileOutputStream fos = new FileOutputStream("Files\\file" + i + ".txt", true);  
                String str = "";
                for(int j = 1; j <= n; j++){
                    str += "file" + i + "content" + j + " ";
                }
                byte[] data = str.getBytes();
                fos.write(data);
                fos.close();
            }
            System.out.println("Files are created Successfully!!");

        }catch (IOException e){  
            e.printStackTrace();
        }
    }
}