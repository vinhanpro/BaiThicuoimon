package socket.cau_1;
import java.io.*;
import java.net.Socket;
public class Cau_1b_Client {
    public static void main(String argv[]) throws Exception
    {
        String sentence_to_server;
        String sentence_from_server;

        System.out.print("dau vao client: ");
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        sentence_to_server = inFromUser.readLine();

        Socket clientSocket = new Socket("127.0.0.1", 55342);

        DataOutputStream outToServer =
                new DataOutputStream(clientSocket.getOutputStream());

        BufferedReader inFromServer =
                new BufferedReader(new
                        InputStreamReader(clientSocket.getInputStream()));

        outToServer.writeBytes(sentence_to_server + '\n');

        sentence_from_server = inFromServer.readLine();

        System.out.println("dau ra server: " + sentence_from_server);

        clientSocket.close();
    }
}