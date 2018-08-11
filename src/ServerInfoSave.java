import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerInfoSave {
    private FileWriter fw = null;
    public void saveToFile(String time,String data,String IP,int port){
        String info = " " + time +"  "+ IP + "  " +port+ "  " + data +"\r\n";
        try{
            fw = new FileWriter("Server.txt",true);
            if(fw != null){
                fw.append(info);
                fw.flush();
                fw.close();
            }
        }catch (IOException e){

        }


    }
}
