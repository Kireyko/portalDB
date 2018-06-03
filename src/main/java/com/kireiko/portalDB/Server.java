package com.kireiko.portalDB;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;
    private ResourceReader resourceReader;

    public void setPort(int port) {
        this.port = port;
    }

    public void setDbFolderPath(String path) {
        resourceReader = new ResourceReader();
        resourceReader.setDbFolderPath(path);
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            try (
                    Socket socket = serverSocket.accept()
            ) {
                RequestHandler requestHandler = new RequestHandler(
                        new BufferedReader(new InputStreamReader(socket.getInputStream())),
                        new BufferedOutputStream(socket.getOutputStream())
                );
                requestHandler.setResourceReader(resourceReader);
                requestHandler.handle();
            }
        }
    }
}
