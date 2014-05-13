package br.com.unip.aps.controller;

import java.awt.Font;
import java.awt.event.ActionEvent;

import br.com.unip.aps.view.ChatHome;

public final class ControllerChatHome extends AbstractController{

	private final String name;
	private final Font font;
	
	private ControllerChatHome(Font font, String name){
		super();
		this.font = font;
		this.name = name;
	}
	
	public static ControllerChatHome instanceOf(Font font, String name){
		return new ControllerChatHome(font, name);
	}
	
	public void chatHomeInit(){
		ChatHome chatHome = new ChatHome(font, name, this);
		chatHome.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO implementar o método aqui
	}
	
}
