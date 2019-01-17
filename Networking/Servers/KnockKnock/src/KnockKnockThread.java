import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class KnockKnockThread implements Runnable {
	private Thread thread;
	private Socket client;

	public KnockKnockThread(Socket client) {
		this.client = client;
	}

	public void start() {
		if (thread == null)
			thread = new Thread(this);
		thread.start();
	}

	public void stop() {
		thread = null;
	}

	public final static String VERSION = "1.0";
	// Error codes and their meanings:
	// 001: invalid protocol or version
	public final static String ERROR_001 = "Error 001: invalid protocol or version";
	// 100: requested joke id out of range
	public final static String ERROR_100 = "Error 100: requested joke is out of range";
	// 200: requested joke id not an integer
	public final static String ERROR_200 = "Error 200: requested Joke is not an integer";

	public void run() {
		try {
			// Setting up input stream 'inStream' of type BufferedReader through the socket
			BufferedReader inStream = new BufferedReader(new InputStreamReader(client.getInputStream()));
			// Setting up output stream 'outStream' of type PrintWriter through the socket
			PrintWriter outStream = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
			// Client sends: KK 1.0 (where 1.0 is the current protocol version)
			// Server receives incoming string through inStream's readLine method, stores it
			// in "input"
			String input = inStream.readLine();
			// If version is okay, i.e. if input string equals "KK 1.0", or better "KK " +
			// VERSION
			if (input.equals("KK " + VERSION))
			// Server replies: "KK OK: " + N, where N = KKData.Jokes.length is the number of
			// jokes.
			{
				println(outStream, "KK OK:" + KKData.Jokes.length);
				// Client sends integer i. Server reads the incoming String via
				// inStream.readLine()
				input = inStream.readLine();
				// Server checks if data received represents a valid integer via the static
				// method parseInt
				// of the Integer class. If input string does not represent an integer, parseInt
				// throws
				// a NumberFormatException. Otherwise the method returns the value as int. In
				// other words:
				int jokeNum = Integer.parseInt(input);
				// and if 0<=i<N. If so:
				if ((jokeNum >= 0) && (jokeNum < KKData.Jokes.length)) {
					// Server sends: �KK OK�
					println(outStream, "KK OK");
					// Server sends: �KK SETUP:� + i-th joke setup (client listens to KK
					// SETUP:Joke:setup)
					println(outStream, "KK SETUP:" + KKData.Jokes[jokeNum][0]);
					// Server sends: �KK PUNCH:� + i-th joke punchline (Client listens to KK
					// PUNCH:line)
					println(outStream, "KK SETUP:" + KKData.Jokes[jokeNum][1]);
					// Server sends: �KK BYE�
					println(outStream, "KK BYE");
				} else {
					// else if integer received is not in range
					// Server sends: �KK ERROR 100�
					println(outStream, "KK " + ERROR_100);
				}
			} else {
				// Server sends: "KK " + ERROR_001
				println(outStream, "KK " + ERROR_001);
			}
			client.close();
		} catch (Exception e) {
			System.err.println("Error: " + e);
		}
	}

	public static void println(PrintWriter outStream, String msg) {
		// Add msg to the outStream
		outStream.println(msg);
		// and flush the stream to actually send the message out
		outStream.flush();
	}
}
