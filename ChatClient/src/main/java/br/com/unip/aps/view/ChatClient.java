package br.com.unip.aps.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * 
 * @author Rodrigo Chibana
 * 
 * */

public class ChatClient extends JFrame{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	private String clientName;

	private PrintWriter writer;
	private Socket socket;
	private Scanner reader;
	
	private JTextField textToSend;
	private JTextArea textReceived;
	private JButton sendButtom;

	public ChatClient(String name){
		super("Chat: " + name);

	
		this.clientName = name;

		Font font = new Font("Serif", Font.PLAIN, 14);

		textToSend = new JTextField();
		textToSend.setFont(font);

		sendButtom = new JButton("Send");
		sendButtom.setFont(font);
		sendButtom.addActionListener(new SendListener());

		Container chatPanel = new JPanel();
		chatPanel.setLayout(new BorderLayout());
		chatPanel.add(BorderLayout.CENTER, textToSend);
		chatPanel.add(BorderLayout.EAST, sendButtom);

		textReceived = new JTextArea();
		textReceived.setFont(font);
		JScrollPane scroll = new JScrollPane(textReceived);

		getContentPane().add(BorderLayout.CENTER, scroll);
		getContentPane().add(BorderLayout.SOUTH, chatPanel);

		configureNetwork();

		init();
		
	}

	/*
	 * 
	 * Initialize the attributes from the ChatClient class
	 * 
	 * */
	
	public void init(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	
	/*
	 * 
	 * Configure the network parameters 
	 *  
	 */
	private void configureNetwork(){
		try {
			socket = new Socket("127.0.0.1", 5000);
			writer = new PrintWriter(socket.getOutputStream());
			reader = new Scanner(socket.getInputStream());
			new Thread(new EscutarServidor()).start();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private class SendListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			writer.println(clientName + ": " + textToSend.getText());
			writer.flush();
			textToSend.setText("");
			textToSend.requestFocus();
		}
	}	
	
	private class EscutarServidor implements Runnable{

		public void run() {
			try{
				String text;
				while((text = reader.nextLine()) != null){
					textReceived.append(text + "\n");
				}
			}catch (Exception e) {
				System.out.println("Connection closed");
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		new ChatClient("Outra pessoa1");
	}
	
}
