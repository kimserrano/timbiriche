
package Cliente;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Elkur
 */
public class ClienteInput {

    public ClienteInput() {
    }

    public int obtenerPuerto(Socket svSockets) throws IOException {
        DataInputStream in = new DataInputStream(svSockets.getInputStream());

        return in.readInt();
    }

}
