package br.com.unip.aps.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import br.com.unip.aps.controller.AbstractController;
import br.com.unip.aps.controller.ControllerChatHome;

public class ChatHome extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JTextField clientName;
	private JButton goToChat;
	private JButton exit;
	private JLabel clientLabel;

	private AbstractController chatHome;
	
	public ChatHome() {
		
		Font font = new Font("Arial", Font.PLAIN, 14);
		
		chatHome = new ControllerChatHome();
		
		//Fields
		this.clientLabel = new JLabel("Name: ");
		this.clientLabel.setFont(font);
		
		this.clientName = new JTextField();
		this.clientName.setFont(font);
		
		this.goToChat = new JButton("GoToChat");
		this.goToChat.setActionCommand("gotochat");;
		this.goToChat.setFont(font);
		
		this.exit = new JButton("Exit");
		this.exit.setActionCommand("exit");
		this.exit.setFont(font);
		
		Container homePanel = new JPanel();
		
		homePanel.setLayout(new BorderLayout());
		homePanel.add(BorderLayout.WEST, exit);
		homePanel.add(BorderLayout.EAST, goToChat);
		
		getContentPane().add(BorderLayout.NORTH,clientLabel);
		getContentPane().add(BorderLayout.CENTER,clientName);
		getContentPane().add(BorderLayout.SOUTH,homePanel);
		
		init();
		addListener();
	}
	
	public void addListener(){
		System.out.println("teste");
		
		this.goToChat.addActionListener(chatHome);
		this.exit.addActionListener(chatHome);
	}
	
	private void init(){
		//Initialize all attributes from chathome class
		this.setResizable(false);
		this.setSize(300,100);
		this.setTitle("Chat Home");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new ChatHome();
	}
	
}
