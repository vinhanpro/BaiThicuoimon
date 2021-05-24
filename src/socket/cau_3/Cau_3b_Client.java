package socket.cau_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Cau_3b_Client {

    public static void main(String[] args) {
        Socket clientSocket = null;
        try {
            clientSocket = new Socket("127.0.0.1", 55342);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("ket noi thanh cong !");
    }
}