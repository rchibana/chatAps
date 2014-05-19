package br.com.unip.aps.controller;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import br.com.unip.aps.view.ChatHome;
import br.com.unip.aps.view.ChatLogin;

public class ControllerChatLogin extends AbstractController{

	private ChatLogin chatLogin;
	
	public ControllerChatLogin(ChatLogin chatLogin){
		super();
		this.chatLogin = chatLogin;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if (command.equalsIgnoreCase("gotochat")){
			String name = chatLogin.getClientName();
			Font font = chatLogin.getFont();
			
			if (name.replaceAll(" ", "").equalsIgnoreCase("")){
				JOptionPane.showMessageDialog(null, "The name field is required");
			}else{
				new ChatHome(font, name);
				chatLogin.dispose();
			}
		}else if (command.equalsIgnoreCase("exit")){
			System.out.println("exit");
		}
		
	}
	
}
