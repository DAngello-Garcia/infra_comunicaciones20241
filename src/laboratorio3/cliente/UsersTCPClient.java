package laboratorio3.cliente;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class UsersTCPClient {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String SERVER = "0.tcp.ngrok.io";
    public static final int PORT = 14911;
    private PrintWriter toNetwork;
    private BufferedReader fromNetwork;
    private Socket clientSideSocket;
    public UsersTCPClient() {
        System.out.println("Users TCP client is running ...");
    }
    public void init() throws Exception {
        clientSideSocket = new Socket(SERVER, PORT);
        createStreams(clientSideSocket);
        protocol(clientSideSocket);
        clientSideSocket.close();
    }
    public void protocol(Socket socket) throws Exception {
        String fromUser = "LOGIN ";
        System.out.print("Ingrese su nombre de usuario: ");
        fromUser += SCANNER.nextLine();
        toNetwork.println(fromUser);
        String fromServer = fromNetwork.readLine();
        System.out.println("[Client] From server: " + fromServer);
    }
    private void createStreams(Socket socket) throws Exception {
        toNetwork = new PrintWriter(socket.getOutputStream(), true);
        fromNetwork = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
    public static void main(String args[]) throws Exception {
        UsersTCPClient ec = new UsersTCPClient();
        ec.init();
    }
}
