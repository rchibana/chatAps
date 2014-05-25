package br.com.unip.aps.controller;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import org.springframework.stereotype.Controller;

import br.com.unip.aps.model.User;
import br.com.unip.aps.view.ChatHome;
import br.com.unip.aps.view.ChatLogin;

@Controller
public class ControllerChatLogin extends AbstractController{

	private ChatLogin chatLogin;
	private User user;
	
	public ControllerChatLogin(ChatLogin chatLogin){
		super();
		this.chatLogin = chatLogin;
		this.user = new User();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if (command.equalsIgnoreCase("gotochat")){
			this.user.setName(chatLogin.getClientName());
			Font font = chatLogin.getFont();
			if (this.user.getName().length()<=19)
				if (this.user.getClearName().equalsIgnoreCase("")){
					JOptionPane.showMessageDialog(null, "The name field is required");
				}else{
					new ChatHome(font, user);
					chatLogin.dispose();
				}
			else{
				JOptionPane.showMessageDialog(null, "The name field can not contain more than 20 characters");
			}
		}else if (command.equalsIgnoreCase("exit")){
			System.out.println("exit");
		}
		
	}
	
}
