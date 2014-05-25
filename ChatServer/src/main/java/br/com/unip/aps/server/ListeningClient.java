package br.com.unip.aps.server;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

/*
 * 
 * @author Rodrigo Chibana
 * 
 * */

public class ListeningClient implements Runnable{
	
	private Scanner reader;
	private List<PrintWriter> writers; 
	
	public ListeningClient(Socket socket, List<PrintWriter> writers) {
		try {
			reader = new Scanner(socket.getInputStream());
			this.writers = writers;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		try {
			String text;
			while((text = reader.nextLine())!=null){
				sendsToEveryone(text);
			}
		} catch (Exception e) {
			System.out.println("The client has closed the connection!");
			System.out.println(e.getMessage());
		}
	}
	
	/*
	 * 
	 * Send the message to everyone connected in server
	 * 
	 * @param text
	 * 
	 * */
	
	public void sendsToEveryone(String text){
		for (PrintWriter writer : writers) {
			try{
				writer.println(text);
				writer.flush();
			}catch (Exception e) {
				System.out.println("Method: sendsToEveryone \n an error ocurred!!");
				System.out.println(e.getMessage());
			}
		}
	}
	
}