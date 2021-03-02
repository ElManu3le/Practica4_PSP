package cliente;

import java.io.EOFException;
import java.io.IOException;
import cliente.Leer;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

//Me tengo que acordar de crear un nuevo usuario y hacer lo shared folder, para hacer la ruta absoluta.

public class App {
  static final int PORT = 14147;
  static final String HOST = "localhost";
  static final String USER = "msancho";
  static final String PASSWORD = "9110";

  public static String nombre;
  public static String passwd;
  public static int opcion;

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

      do {

        System.out.println("\n*********** \n");

        System.out.println("1. Listar todos los archivos y directorios  ");

        System.out.println("2.  ");

        System.out.println("3.  ");

        System.out.println("4.  ");

        System.out.println("5.  ");

        System.out.println("6.  ");

        System.out.println("7.  ");

        System.out.println("8.  ");

        System.out.println("9.  ");

        System.out.println("10.  ");

        System.out.println("11. Pulsa 0 para cerrar sesion \n");

        switch (opcion = Leer.pedirEnteroValidar()) {
          case 1:
            System.out.println("Directorio actual: " + newCliente.printWorkingDirectory() + "\n");

            FTPFile[] files = newCliente.listFiles();
            System.out.println("Ficheros en el directorio actual: " + files.length);
            for (int i = 0; i < files.length; i++) {
              System.out.println(files[i].getName());
            }

            break;

          case 2:

            break;

          case 3:

            break;

          case 4:

            break;

          case 5:

            break;

          case 6:

            break;

          case 7:

            break;

          case 8:

            break;

          case 9:

            break;

          case 10:

            break;

          case 11:
            

            break;

          default:
            break;
        }

      } while (opcion != 0);
      newCliente.disconnect();
      System.out.println("Cerrando la sesion");

    } catch (Exception e) {
      System.out.println("Login incorrecto...");
    }

  }
}
