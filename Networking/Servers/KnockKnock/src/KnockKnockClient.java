import java.io.*;
import java.net.*;

public class KnockKnockClient {

	public static void main(String[] args) {
		// Defines the port
		int PORT = 7659;
		// Defines the String
		String VERSION = "1.0";
		try {
			// Makes a new Socket
			Socket Client = new Socket("localhost", PORT);
			// Typical BufferedReader and PrintWriter
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
							Client.getInputStream()));
			PrintWriter out = new PrintWriter(
					new OutputStreamWriter(
							Client.getOutputStream()));
			// Sends the version
			println(out, "KK " + VERSION);
			// Gets the response
			String response = in.readLine();
			// Makes sure that the message follows the proper protocol
			if (response.startsWith("KK OK:")) {
				// Gets part of the response that we want.
				response = response.substring(response.indexOf(":") + 1);
				// Defines the max number of jokes possible
				int maxJokes = Integer.parseInt(response);
				// Gives an index for the joke
				int jokeNum = (int) (maxJokes * Math.random());
				// Sends the jokeNum
				println(out, Integer.toString(jokeNum));
				// Reads the response
				response = in.readLine();
				// Checks if response is what is expected
				if (response.equals("KK OK")) {
					// Adds the current part of the joke to the Joke String
					String Joke = "Knock Knock \nWho's there? \n";
					// Gets the response
					response = in.readLine();
					// Gets the setup for the joke, then adds it to the Jokes String
					response = response.substring(response.indexOf(":") + 1);
					Joke += response + "\n" + response + " who? \n";
					// Gets the response, then adds the punchline to the Jokes String
					response = in.readLine();
					response = response.substring(response.indexOf(":") + 1);
					Joke += response;
					// Returns the Joke
					System.out.println(Joke);
				} 
				else
					System.err.println(response);
			} 
			else
				System.err.println(response);
			// Closes Client
			Client.close();
		} 
		catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	//Given println method for making sending messages easy
	public static void println(PrintWriter out, String msg) {
		out.println(msg);
		out.flush();
	}
}