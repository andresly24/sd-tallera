import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HiloSocket extends Thread {
    
    private Socket socket;
    private static List<String> list = new ArrayList<>();

    public HiloSocket(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // I/O Buffers
            // Entrada
            InputStreamReader in_reader = new InputStreamReader( this.socket.getInputStream() );
            BufferedReader in_socket = new BufferedReader(in_reader);

            // Salida
            OutputStreamWriter out_writer = new OutputStreamWriter(this.socket.getOutputStream());
            PrintWriter out_socket = new PrintWriter(out_writer, true);

            String input = "", output = "";

            while((input = in_socket.readLine()) != null) {

                try {
                    int numero = Integer.parseInt(input);
                    list.add(input);
                } catch (NumberFormatException e) {
                    out_socket.println("No es un numero");
                    continue;   
                }

            System.out.println("Lista: " + list);

            out_socket.print(output);
            out_socket.flush();
        }
            
        } catch(IOException ex) {
        } 
    }
}
