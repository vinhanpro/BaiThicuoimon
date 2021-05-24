package socket.cau_2;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Cau_2c_Chat {

    public final static int SERVER_PORT = 7;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            System.out.println("lien ket voi port " + SERVER_PORT + ", vui long doi!  ...");
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server bat dau: " + serverSocket);
            System.out.println("vui long cho client khac vao ! ...");
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("Client da vao: " + socket);

                    OutputStream os = socket.getOutputStream();
                    InputStream is = socket.getInputStream();
                    int ch = 0;
                    while (true) {
                        ch = is.read(); // Receive data from client
                        if (ch == -1) {
                            break;
                        }
                        os.write(ch); // Send the results to client
                    }
                    socket.close();
                } catch (IOException e) {
                    System.err.println(" ket noi loi: " + e);
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

}