/*
 * This was made my kevin phelan
 * for networking
 *
 */
package tcp;

import java.io.*;
import java.net.*;
import java.util.Scanner;

// usage: $ java TCPClient localhost
// if your server is a remote machine, use the remote machine's name, instead of localhost

public class TCPClient {
    public static final int SERVER_PORT = 5432; // the server's well known port
    public static void main(String[] args) throws IOException {
        String hostName = "127.0.0.1";
	   // remote server's address info are specified in clientSocket
        Socket clientSocket = new Socket(hostName, SERVER_PORT);
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        Scanner in = new Scanner(System.in);
        String userInput;

        while ((userInput = in.next()) != null) {
	    // this is the main loop that sends the user input to the remote server
            out.println(userInput);
        }
    }
}
