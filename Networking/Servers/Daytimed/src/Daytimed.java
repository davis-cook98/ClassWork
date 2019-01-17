// Davis Cook
// CSAS 3211
// This is code for a server that sends the current date and time.
import java.io.*;
import java.net.*;
import java.util.Date;
public class Daytimed {
	//This can all be run in main
	public static void main(String[] args) {
		//Makes a new ServerSocket
		ServerSocket server;
		try {
			server = new ServerSocket(13);
			System.out.println("Server setup, waiting: " + server);
			//Allows the server to run forever
			boolean running = true;
			while (running) {
				//Makes a new socket
				Socket client = server.accept();
				System.out.println("Client connected: " + client);
				//Makes a new PrintWriter for sending the date.
				PrintWriter out = new PrintWriter(
						new OutputStreamWriter(
								client.getOutputStream()));

				//Gets the date then flushes the stream. I noticed
				//in the documentation that you said we did not need
				//the flush method but my code did not work without it.
				Date today = new Date();
				out.println(today);
				out.flush();
				//Closes the Socket
				client.close();
			}
			//Closes the ServerSocket
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
