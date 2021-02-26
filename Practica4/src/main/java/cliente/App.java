package cliente;

import java.io.EOFException;
import java.io.IOException;
import cliente.Leer;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

//Me tengo que acordar de crear un nuevo usuario y hacer lo shared folder, para hacer la ruta absoluta.

public class App 
{
    static final int PORT = 14147;
    static final String HOST = "localhost";
    static final String USER = "msancho";
    static final String PASSWORD = "9110";
    public String nombre;
    public String passwd;
    public static void main( String[] args ) throws IOException
    {
        FTPClient newCliente = new FTPClient();

        newCliente.connect(HOST);

        if(newCliente.getReplyCode() == 220){
            System.out.println(newCliente.getReplyString());
            System.out.println("El servidor FTP está preparado");
          }
      
          boolean isLogged = newCliente.login(USER, PASSWORD);
      
          if(isLogged){
            System.out.println("Login correcto...");
          } else{
            System.out.println("Login incorrecto...");
          }
      
          System.out.println("Directorio actual: " + newCliente.printWorkingDirectory());
      
          FTPFile[] files = newCliente.listFiles();
          System.out.println("Ficheros en el directorio actual: " + files.length);
      
          newCliente.disconnect();
        
    }
}
