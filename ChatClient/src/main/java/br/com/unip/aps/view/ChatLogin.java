package br.com.unip.aps.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.unip.aps.controller.AbstractController;
import br.com.unip.aps.controller.ControllerChatHome;
import br.com.unip.aps.controller.ControllerChatLogin;

public class ChatLogin extends JFrame{

	private JTextField clientName;
	private JButton goToChat;
	private JButton exit;
	private JLabel clientLabel;
	private Font font;
	
	public ChatLogin(Font font) {
		
		// TODO Implementar para abrir o layout no centro.
		
		this.font = font;
		
		this.setSize(300, 100);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		
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
		addListener();
	}
	
	private void addPanels(){
		JPanel inputPanel = new JPanel(new BorderLayout());
		inputPanel.add(BorderLayout.NORTH, clientLabel);
		inputPanel.add(BorderLayout.CENTER, clientName);
		
		Panel buttonsPanel = new Panel(new BorderLayout());
		buttonsPanel.add(BorderLayout.WEST, exit);
		buttonsPanel.add(BorderLayout.EAST, goToChat);
		
		this.add(BorderLayout.SOUTH, buttonsPanel);
		this.add(BorderLayout.NORTH, inputPanel);
	}
	
	private void addListener(){
		this.goToChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(! clientName.getText().replaceAll(" ", "").equalsIgnoreCase("")){
					ControllerChatHome.instanceOf(font, clientName.getText()).chatHomeInit();
					dispose();
				}else{
					JOptionPane.showMessageDialog(null, "Please write your name in input name");
				}
			}
		});
		
		this.exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Closed!");
				System.exit(0);
			}
		});
	}
	
}


