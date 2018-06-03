import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class ServerStarterTest {

    @Test
    public void startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);
//        String name = "db/table2.xml";
        String name = "db/temp_table.xml";
        while (true) {
            try (Socket socket = serverSocket.accept();
                 BufferedReader sourceStream = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(name)));
                 BufferedWriter outputStream = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                 BufferedReader inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ) {
                String line;
                System.out.println("Got new request from client:");

                line= inputStream.readLine();
                if ((line!=null)&&(!line.isEmpty())) {
                    System.out.println(line);
                }
                //process request from client and sent response
                System.out.println("- - - - - - ");

                System.out.println("Starting sending response...  ");
                while ((line = sourceStream.readLine()) != null ) {
                    outputStream.write(line);
                    outputStream.flush();
                }
                System.out.println("Response was send ");
                System.out.println("------------------------------------------------- ");
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }
    }
}


