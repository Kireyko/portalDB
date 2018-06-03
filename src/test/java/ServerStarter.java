import com.kireiko.portalDB.Server;
import org.junit.Test;

import java.io.IOException;

public class ServerStarter {
    @Test
    public void testServer() throws IOException {
        Server server = new Server();
        server.setPort(3000);
        server.setDbFolderPath("db");
        server.start();
    }
}
