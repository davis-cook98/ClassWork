
import java.net.*	;
import java.io.*;

public class WebDownload {
	public static void main(String[] args) {
		System.out.println("This program will download an arbitrary webpage");
		// The host to connect to
		String host = "sciris.shu.edu";
		// The port to use for the connection
		int port = 80;
		// The file to retrieve
		String file = "/";
		
		if (args.length == 2) {
			file = args[1];
		}
		if (args.length >= 1) {
			host = args[0];
		}
		else {
			System.out.println("Usage: java WebDownload host [file]");
			System.exit(-1);
		}
		
		try {
			// connecting...
			System.out.println("Connecting to " + host + " on port " + port);
			Socket s = new Socket(host, port);
			System.out.println("Connection established " + s);
			System.out.println("Setting up input and output streams of characters");
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
							s.getInputStream()));
			PrintWriter out = new PrintWriter(
					new OutputStreamWriter(
							s.getOutputStream()));	
			sendHTTPCode(out, file, host);
			reciveHTTPData(in);
			
			in.close();
			out.close();
			s.close();
			System.out.println("Disconnected");
		}
		catch(Exception e) {
			System.err.println("Error: " + e);
		}
	}
	
	private static void sendHTTPCode(PrintWriter out, String file, String host) {
		out.println("GET " + file + " HTTP/1.1");
		out.print("HOST: " + host);
		out.println();
		out.flush();
	}
	
	private static void reciveHTTPData(BufferedReader out) throws Exception{
		String line = out.readLine();
		while (line != null) {
			System.out.println("Got " + line);
			line = out.readLine();
		}
	}

}
