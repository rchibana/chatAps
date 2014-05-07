package br.com.unip.aps.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.unip.aps.controller.AbstractController;

public class ChatLogin extends JPanel{

	private JTextField clientName;
	private JButton goToChat;
	private JButton exit;
	private JLabel clientLabel;
	
	public ChatLogin(Font font, AbstractController chat) {

		
		// TODO Implementar para abrir o layout no centro.
		
		this.setSize(300, 100);
		this.setLayout(new BorderLayout());
		this.setAlignmentX(CENTER_ALIGNMENT);
		
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
		
		addPanels();
		addListener(chat);
	}
	
	private void addPanels(){
		Panel inputPanel = new Panel(new BorderLayout());
		inputPanel.add(BorderLayout.NORTH, clientLabel);
		inputPanel.add(BorderLayout.CENTER, clientName);
		
		Panel buttonsPanel = new Panel(new BorderLayout());
		buttonsPanel.add(BorderLayout.WEST, exit);
		buttonsPanel.add(BorderLayout.EAST, goToChat);
		
		this.add(BorderLayout.SOUTH, buttonsPanel);
		this.add(BorderLayout.NORTH, inputPanel);
	}
	
	private void addListener(AbstractController chat){
		this.goToChat.addActionListener(chat);
		this.exit.addActionListener(chat);
	}
	
}


