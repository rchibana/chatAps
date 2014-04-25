package br.com.unip.aps.controller;

import java.awt.event.ActionEvent;

public class ControllerChatHome extends AbstractController{

	public ControllerChatHome(){
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getSource());
		System.out.println(e.getActionCommand());
		System.out.println("teste");
	}
	
}
