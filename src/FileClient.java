import java.io.*;
import java.net.*;

public class FileClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345); // Indirizzo IP del server e porta

        File file = new File("prova.conf");
        byte[] buffer = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        bis.read(buffer, 0, buffer.length);

        OutputStream out = socket.getOutputStream();

        // Invia il file
        out.write(buffer, 0, buffer.length);
        out.flush();
        socket.close();
        fis.close();
        bis.close();
    }
}