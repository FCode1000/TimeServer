import java.net.*;
import java.io.*;
import java.time.LocalTime;
public class TcpTimeServer extends Thread{
    private int port;
    public TcpTimeServer(int port){
        this.port = port;
    }
    @Override
    public void run(){
        try{
            ServerSocket tcpSocket = new ServerSocket(port);
            while(true){
                Socket tcpClientSocket = tcpSocket.accept();
                PrintWriter out = new PrintWriter(tcpClientSocket.getOutputStream(), true);
                out.println(LocalTime.now());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
