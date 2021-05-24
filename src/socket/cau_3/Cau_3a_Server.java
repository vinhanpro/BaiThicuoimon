package socket.cau_3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class Cau_3a_Server {
    public static void main(String[] args) {
        Socket Socket = null;
        try {
            ServerSocket server = null;
            try {
                server = new ServerSocket(55342);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Server dang cho...");
            while (true) {
                try {
                    Socket = server.accept();
                    for (int i= 1; i<15; i++){
                        System.out.println("thuc hien "+i);
                        Thread.sleep(1000);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Finish...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}