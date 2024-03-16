package laboratorio3.servidor;


import laboratorio2.Persona;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class UsersTCPServer {
    public static final int PORT = 3400;
    private ServerSocket listener;
    private Socket serverSideSocket;
    private PrintWriter toNetwork;
    private BufferedReader fromNetwork;
    private HashMap<String, Persona> personas = new HashMap<>();
    public UsersTCPServer() {
        System.out.println("Users TCP server is running on port: " + PORT);
    }
    public void init() throws Exception {
        listener = new ServerSocket(PORT);
        while (true) {
            serverSideSocket = listener.accept();
            createStreams(serverSideSocket);
            protocol(serverSideSocket);
        }
    }
    public void protocol(Socket socket) throws Exception {
        String nombre = fromNetwork.readLine();
        Persona persona = contarLogins(nombre);
        System.out.println("[Server] From client: " + nombre);
        String answer = "Bienvenido, "+persona.getNombre() + " usted ha hecho login " + persona.getContador() +
                " veces.";
        toNetwork.println(answer);
    }

    public Persona contarLogins(String nombre) {
        Persona persona = verificarExistencia(nombre);
        if(persona == null) {
            persona = new Persona();
            persona.setNombre(nombre.split(" ")[1]);
            persona.setContador(persona.getContador()+1);
            personas.put(nombre.split(" ")[1], persona);
        } else {
            persona.setContador(persona.getContador()+1);
        }
        return persona;
    }

    public Persona verificarExistencia(String nombre) {
        Persona persona = null;
        for(Persona p: personas.values()) {
            if(nombre.split(" ")[1].equals(p.getNombre()))
                persona = p;
        }
        return persona;
    }

    private void createStreams(Socket socket) throws Exception {
        toNetwork = new PrintWriter(socket.getOutputStream(), true);
        fromNetwork = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public static void main(String args[]) throws Exception {
        UsersTCPServer es = new UsersTCPServer();
        es.init();
    }
}
