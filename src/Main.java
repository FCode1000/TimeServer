public class Main {
    public static void main(String[] args) {
        int PORT;
        try{
            PORT = Integer.parseInt(args[0]);
        }
        catch(Exception e){
            PORT = 8080;
            System.out.println("Using default port 8080");
        }
        try{
            TcpTimeServer tcpTimeServer = new TcpTimeServer(PORT);
            UdpTimeServer udpTimeServer = new UdpTimeServer(PORT);
            tcpTimeServer.start();
            udpTimeServer.start();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}