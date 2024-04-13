import java.io.*;
import java.net.*;

public class FileServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345); // Porta del server

        Socket clientSocket = serverSocket.accept(); // Accetta la connessione dal client
        InputStream in = clientSocket.getInputStream();

        // Riceve il file
        FileOutputStream fos = new FileOutputStream("prova.conf");
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            fos.write(buffer, 0, bytesRead);
        }
        fos.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}