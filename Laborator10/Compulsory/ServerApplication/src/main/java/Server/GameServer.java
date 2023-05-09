package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    private Integer port;
    private ServerSocket serverSocket;
    public GameServer(Integer port){ this.port = port;}

    public void start(){
        try{
            serverSocket = new ServerSocket(port);
            System.out.println("Serverul este on la portul "+ port);
            while (true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client conectat la adresa :" + clientSocket.getInetAddress().getHostAddress());
                ClientThread clientThread = new ClientThread(clientSocket, this);
                clientThread.start();
            }
        } catch (IOException e) {
            System.out.println("Serverul s-a oprit!");
        }
    }

    public void stop() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        GameServer gameServer = new GameServer(8000);
        gameServer.start();
    }
}