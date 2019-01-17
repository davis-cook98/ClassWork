// Davis Cook
// CSAS 3211
// This is code for a client that receives the current date and time
import java.net.*;
import java.util.Scanner;

public class UDPDaytime {
	public static void main(String[] args){
		// Asks user for an input port. Must be same 
		// as the other program.
		Scanner input = new Scanner(System.in);
		System.out.println("Which port would you like to use? ");
		int port = input.nextInt();
		input.close();
		try {
			// Sets up the client
			DatagramSocket s = new DatagramSocket(0);
			// Allows the client to timeout if it waits
			// for too long.
			s.setSoTimeout(5000);
			System.out.println("Client setup, waiting: " + s);
			// Gets the local ip address
			String host = InetAddress.getLocalHost().getHostName();
			sendRequest(s, host, port);
			waitForDate(s);
			s.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	private static void sendRequest(DatagramSocket s, String host, int port) throws Exception{
		// Gets the address from the input host, then sends the test
		// byte to the server.
		InetAddress address = InetAddress.getByName(host);
		byte[] data = new byte[1];
		DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
		s.send(packet);
	}
	private static void waitForDate(DatagramSocket s) throws Exception{
		// Waits for the date then, when it is recieved,
		// decodes the information then prints the date.
		byte[] buffer = new byte[256];
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
		s.receive(packet);
		String today = new String(packet.getData());
		System.out.println(today);
	}
}
