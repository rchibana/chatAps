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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.unip.aps.model.User;

/*
 * 
 * @author Rodrigo Chibana
 * 
 * */

public class ChatClient extends JPanel {

	private static final long serialVersionUID = 1L;

	private User user;

	private PrintWriter writer;
	private Socket socket;
	private Scanner reader;

	private JTextField textToSend;
	private JTextArea textReceived;
	private JButton sendButtom;

	public ChatClient(Font font, User user) {

		this.user = user;

		textToSend = new JTextField();
		textToSend.setFont(font);

		sendButtom = new JButton("Send");
		sendButtom.setFont(font);
		sendButtom.addActionListener(new SendListener());

		textReceived = new JTextArea();
		textReceived.setFont(font);
		textReceived.setWrapStyleWord(true);
		textReceived.setLineWrap(true);
		
		this.setLayout(new BorderLayout());
		this.setSize(500, 500);
		
		addPanel(new JScrollPane(textReceived));
		

		configureNetwork();

	}

	private void addPanel(JScrollPane scroll){
		Container messagePanel = new JPanel();
		messagePanel.setLayout(new BorderLayout());
		messagePanel.add(BorderLayout.CENTER, scroll);

		Container userPanel = new JPanel();
		userPanel.setLayout(new BorderLayout());
		userPanel.add(BorderLayout.CENTER, textToSend);
		userPanel.add(BorderLayout.EAST, sendButtom);

		this.add(BorderLayout.CENTER, messagePanel);
		this.add(BorderLayout.SOUTH, userPanel);
	}
	
	/*
	 * 
	 * Configure the network parameters
	 */

	private void configureNetwork() {
		try {
			socket = new Socket("127.0.0.1", 5000);
			System.out.println("Conexão estabelecida");
			writer = new PrintWriter(socket.getOutputStream());
			reader = new Scanner(socket.getInputStream());
			new Thread(new ServerListener()).start();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Não foi possível estabelecer conexão com o servidor");
			System.out.println("Verify the proxy or the internet host are correct");
		}

	}

	private class SendListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			writer.println(user.getName() + ": " + textToSend.getText());
			writer.flush();
			textToSend.setText("");
			textToSend.requestFocus();
		}
	}

	private class ServerListener implements Runnable {

		public void run() {
			try {
				String text;
				while ((text = reader.nextLine()) != null) {
					textReceived.append(text + "\n");
				}
			} catch (Exception e) {
				System.out.println("Connection closed");
			}
		}

	}

}
