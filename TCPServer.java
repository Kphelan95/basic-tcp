/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp;

import java.net.*;
import java.io.*;

// usage: $ java TCPServer

public class TCPServer {
    public static final int SERVER_PORT=5432; // the server's well known port
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
	while (true) {
	    // everytime it accepts a client, a new socket is created for the client.
            // the new socket is used to conduct communications with the current client. 
            // the old socket is available to accept other clients only after the server is done with the current client
            Socket newSocket = serverSocket.accept();
	    // the newSocket is used to conduct communications with the current client.
            BufferedReader in = new BufferedReader(new InputStreamReader(newSocket.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                // receives the information from the current client and prints the information to its local standard output
                System.out.println(inputLine);
            }
	    // the current client finishes, the newSocket should be closed; notice that the old serverSocket is always open
	    newSocket.close();
        }
    }
}
