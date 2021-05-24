package socket.Cau_4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Cau_4a_Server {

    public static void main(String[] args) {
        Socket socket = null;
        try {
            ServerSocket server = null;
            try {
                server = new ServerSocket(55342);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Server is waiting...");
            while (true) {
                try {
                    socket = server.accept();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                new Thread(() -> {
                    for (int i= 1; i<15; i++){
                        System.out.println("Công việc "+i);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Finish...");
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}