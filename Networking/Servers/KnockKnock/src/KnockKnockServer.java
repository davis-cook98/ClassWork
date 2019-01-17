import java.net.*;

public class KnockKnockServer{
    // Knock-knock port is 7659
    public final static int PORT = 7659;
    // Standard main method. 
    public static void main(String[] args) {
        try {
            // Creating server instance, listening on the KnockKnock Port 7659.
            ServerSocket server = new ServerSocket(PORT);
            // Allows the server to run forever
            boolean running = true;
            while (running){
                // Waiting for a connection via the server socket's accept method
                Socket client = server.accept();
                KnockKnockThread handler = new KnockKnockThread(client);
                handler.start();
            }
            //  Server disconnects
            server.close();
        }
        catch(Exception e){
           System.err.println("Error: " + e); 
        }
    }
}
