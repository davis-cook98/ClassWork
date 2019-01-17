// Davis Cook
// CSAS 3211
// This is code for a server that sends the current date and time.
import java.net.*;
import java.util.*;

public class UDPDaytimed {
	public static void main(String[] args){
		// Asks user for an input port. Must be same 
		// as the other program.
		Scanner input = new Scanner(System.in);
		System.out.println("Which port would you like to use? ");
		int port = input.nextInt();
		input.close();
		try {
			// Makes the socket on the specified port
			DatagramSocket s = new DatagramSocket(port);
			// Allows server to run infinitely
			boolean running = true;
			while(running) {
				DatagramPacket teaser = waitForTeaser(s);
				// Extract client InetAdress and port that client listens to
				sendDate(s, teaser.getAddress(), teaser.getPort());
			}
			// Closes server
			s.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static DatagramPacket waitForTeaser(DatagramSocket s) throws Exception{
		// Creates a Datagram packet to recieve data, then waits
		// for the data to be recieved, then returns the data.
		byte[] buffer = new byte[256];
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
		s.receive(packet);
		return packet;

	}
	private static void sendDate(DatagramSocket s, InetAddress client, int port) throws Exception{
		// First gets the date, then converts it into an array 
		// of bytes that can be sent. Then, using input data
		// sends the packet.
		Date today = new Date();
		byte[] data = today.toString().getBytes();
		DatagramPacket packet = new DatagramPacket(data, data.length, client, port);
		s.send(packet);
	}
}
