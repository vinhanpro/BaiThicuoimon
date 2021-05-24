package socket.cau_1;
import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
public class Cau_1a_Server {
    public static void main(String argv[]) throws Exception
    {
        String sentence_from_client;
        String sentence_to_client;

        ServerSocket welcomeSocket = new ServerSocket(55342);

        while(true) {

            Socket connectionSocket = welcomeSocket.accept();

            BufferedReader inFromClient =
                    new BufferedReader(new
                            InputStreamReader(connectionSocket.getInputStream()));

            DataOutputStream outToClient =
                    new DataOutputStream(connectionSocket.getOutputStream());

            sentence_from_client = inFromClient.readLine();

            sentence_to_client = sentence_from_client +" (la ki tu duoc nhap tu ban phim)" + '\n';

            outToClient.writeBytes(sentence_to_client);
            return;
        }

    }
}