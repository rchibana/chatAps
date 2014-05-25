package br.com.unip.aps.view;

import java.awt.Font;

import javax.swing.JFrame;

import br.com.unip.aps.model.User;

public class ChatHome extends JFrame {

	private static final long serialVersionUID = 1L;
	private User user;
	private ChatClient chatClient;

	public ChatHome(Font font, User user) {

		this.user = user;
		init();
		
		chatClient = new ChatClient(font, user);
		setInterface();

	}

	private void init() {
		// Initialize all attributes from chathome class

		this.setResizable(false);
		this.setSize(500, 500);
		this.setTitle("Chat: "+ this.user.getName());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);

	}

	private void setInterface() {
		getContentPane().removeAll();
		getContentPane().add(chatClient);
		getContentPane().validate();
		getContentPane().repaint();
		chatClient.setFocusable(true);
		chatClient.requestFocusInWindow();
	}

}
