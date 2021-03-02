package cliente;

import java.io.EOFException;
import java.io.IOException;
import cliente.Leer;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

//Me tengo que acordar de crear un nuevo usuario y hacer lo shared folder, para hacer la ruta absoluta.

public class App2 {
    static final int PORT = 14147;
    static final String HOST = "localhost";
    static final String USER = "msancho";
    static final String PASSWORD = "9110";

    public static String nombre;
    public static String passwd;
    public static int opcion;
    public static String operacion;

    public static void main(String[] args) throws IOException {
        FTPClient newCliente = new FTPClient();

        newCliente.connect(HOST);

        if (newCliente.getReplyCode() == 220) {
            System.out.println(newCliente.getReplyString());
            System.out.println("El servidor FTP está preparado \n");
        }

        try {

            boolean isLogged = newCliente.login(USER, PASSWORD);

            if (isLogged) {
                System.out.println("Login correcto...");
            }

            operacion = Leer.pedirCadena();
            String[] comando = operacion.split(" ");
            for (int i = 0; i < comando.length; i++) {
                System.out.println(comando[i]);
            }

            System.out.println("Cerrando la sesion");

        } catch (Exception e) {
            System.out.println("Login incorrecto...");
        }

    }
}
