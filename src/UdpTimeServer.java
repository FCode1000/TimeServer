import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.time.LocalTime;

public class UdpTimeServer extends Thread {
    private int port;
    public UdpTimeServer(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try{
            try (DatagramSocket udpSocket = new DatagramSocket(port)) {
                while (true) {
                    // UDP
                    byte[] receiveBuffer = new byte[1024];
                    DatagramPacket udpReceivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                    udpSocket.receive(udpReceivePacket);
                    byte[] buf = LocalTime.now().toString().getBytes();
                    DatagramPacket packet = new DatagramPacket(buf, buf.length, udpReceivePacket.getAddress(), udpReceivePacket.getPort());
                    udpSocket.send(packet);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }



}
