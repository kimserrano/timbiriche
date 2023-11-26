package Cliente;

import datos.ipsDTO;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public ipsDTO obtenerIPs(Socket svSockets) throws IOException {

        ObjectInputStream in = new ObjectInputStream(svSockets.getInputStream());
        try {
            ipsDTO ips = (datos.ipsDTO) in.readObject();
            return ips;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }

}
