package cliente;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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

    boolean isLogged = newCliente.login(USER, PASSWORD);

    if (isLogged) {
      System.out.println("Login correcto...");
    }

    do {

      System.out.println("\n*********** \n");

      System.out.println("1. Iniciar Sesion   ");

      System.out.println("2. Cerrar sesion  ");

      System.out.println("3. Listar todos los archivos y directorios ");

      System.out.println("4. Subir un fichero  ");

      System.out.println("5. Descargar fichero del servidor ");

      System.out.println("6. Eliminar fichero ");

      System.out.println("7. Eliminar directorio  ");

      System.out.println("8. Crear directorio  ");

      System.out.println("9. Cambiar de directorio actual  ");

      System.out.println("10.  ");

      System.out.println("11. Pulsa 0 para cerrar sesion \n");

      switch (opcion = Leer.pedirEnteroValidar()) {
        case 1:

          break;

        case 2:

          newCliente.disconnect();
          System.out.println("Cerrando la sesion");

          break;

        case 3:

          System.out.println("Directorio actual: " + newCliente.printWorkingDirectory());

          FTPFile[] files = newCliente.listFiles();
          System.out.println("Ficheros en el directorio actual: " + files.length);
          for (int i = 0; i < files.length; i++) {
            System.out.println(files[i].getName());
          }

          break;

        case 4:

          InputStream inputstream = new FileInputStream(
              "C:\\Users\\elman\\OneDrive\\Escritorio\\JUECES\\J1_modelo.pdf");

          newCliente.storeFile("J1_modelo.pdf", inputstream);
          System.out.println("fichero subido");

          break;

        case 5:
          OutputStream output = new FileOutputStream("C:\\Users\\elman\\OneDrive\\Escritorio\\JUECES\\J1_modelo.pdf");
          newCliente.retrieveFile("descarga.txt", output);
          System.out.println("Fichero descargado");

          break;

        case 6:
          System.out.println("Dime el nombre del archivo que deseas eliminar");
          newCliente.deleteFile(Leer.pedirCadena());

          break;

        case 7:
          System.out.println("Directorio que desea eliminar");
          newCliente.removeDirectory(Leer.pedirCadena());

          break;

        case 8:

          System.out.println("Directorio que desea crear");
          newCliente.makeDirectory(Leer.pedirCadena());

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

    } while (opcion != 2);

  }
}
