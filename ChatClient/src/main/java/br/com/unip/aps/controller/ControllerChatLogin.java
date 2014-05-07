package br.com.unip.aps.controller;

import java.awt.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.unip.aps.view.ChatClient;

public class ControllerChatLogin extends AbstractController{

	public ControllerChatLogin(){
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if (command.equalsIgnoreCase("gotochat")){
			System.out.println("go to chat");
		}else if (command.equalsIgnoreCase("exit")){
			System.out.println("exit");
		}
		
	}
	
}
