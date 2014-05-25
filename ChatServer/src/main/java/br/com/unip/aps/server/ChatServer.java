package br.com.unip.aps.server;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ChatServer {

	private ServerSocket server;
	private List<PrintWriter> writers;
	
	public ChatServer(){
		try {
			
			server = new ServerSocket(5000);
			ListeningClient listeningClient;
			writers = new ArrayList<PrintWriter>();
			System.out.println("The server is running");
			
			while(true){
				Socket socket = server.accept();
				listeningClient = new ListeningClient(socket,writers);
				new Thread(listeningClient).start();
				PrintWriter p = new PrintWriter(socket.getOutputStream());
				writers.add(p);
			}
			
		} catch (Exception e) {
			System.out.println("Client connection closed");
		}
	}
	
	public static void main(String[] args) {
		new ChatServer();
	}
	
}
