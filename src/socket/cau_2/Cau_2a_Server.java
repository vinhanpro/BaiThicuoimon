package socket.cau_2;

import java.io.DataOutputStream;
import java.io.IOException;

import java.net.ServerSocket;

import java.net.Socket;

public class Cau_2a_Server {

        public static void main(String[] args) throws IOException {
            Socket socketofServer;



                ServerSocket serverSocket

                        = new ServerSocket( 55342);
                System.out.println("vui long nhap : 55342 tren Telnet localhost de ket noi sever !");
                System.out.println("Server dang ket noi ...");

               while (true){

                    socketofServer = serverSocket.accept();
                   DataOutputStream outToClient = new DataOutputStream(socketofServer.getOutputStream());
                   new Thread(() -> {
                           for (int i=0; i<10; i++) {
                              try {
                                  outToClient.writeBytes(i+ " ");
                                  Thread.sleep(1000);

                              }catch (IOException e) {
                                e.printStackTrace();
                              } catch (InterruptedException e) {
                               e.printStackTrace();
                           }
                   }
               }).start();
           }
        }
}
