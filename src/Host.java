
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Host {
    private int port = 8087;
    private ServerSocket serverSocket = null;
    private Socket socket = null;
    private Scanner reader = null;
    private String msg = null;
    private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private ServerInfoSave save = null;

    private void getServerSocket()throws Exception{
            serverSocket = new ServerSocket(8087);
            System.out.println("等待连接");
            socket = serverSocket.accept();

            System.out.println(socket.getInetAddress()+"已成功连接到此台服务器上。");
            System.out.println("套接字创建成功，");

            System.out.println("开始创建输入流");
            reader = new Scanner(socket.getInputStream());
            System.out.println("输入流创建成功");
            save = new ServerInfoSave();
            System.out.println("接受信息：");
            while (true){
                String inData = reader.nextLine();//接受客户端信息
                String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//获取当前时间
                try{
                    save.saveToFile(now,inData,socket.getInetAddress().toString(),socket.getPort());
                }catch (Exception e){}
//                System.out.println(socket.getInetAddress());
//                System.out.println(socket.getLocalPort());
//                System.out.println(socket.getPort());
//                System.out.println(socket.getLocalSocketAddress());
//                System.out.println(socket.getRemoteSocketAddress());
                System.out.println("客户端："+inData);
            }


    }

    public static void main(String[] args)throws Exception {
        Host host = new Host();
        host.getServerSocket();
    }
}
